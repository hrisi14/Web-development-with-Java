import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { EventContainerComponent } from '../event-container/event-container.component';
import { Event } from '../model/event.model';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-followed-events',
  standalone: true,
  imports: [CommonModule, EventContainerComponent],
  templateUrl: './followed-events.component.html',
  styleUrls: ['./followed-events.component.css']
})
export class FollowedEventsComponent implements OnInit {
  events: Event[] = [];
  userId!: number;

  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const idParam = params.get('id');
      if (idParam && !isNaN(Number(idParam)) && Number(idParam) > 0) {
        this.userId = Number(idParam);
        this.loadFollowedEvents();
      } else {
        const currentUserId = this.authService.getCurrentUserId();
        if (currentUserId && currentUserId > 0) {
          this.userId = currentUserId;
          this.router.navigate(['/user', this.userId, 'followed-events']);
        } else {
          this.events = [];
        }
      }
    });
  }

  loadFollowedEvents() {
    this.userService.getFollowedEvents(this.userId).subscribe({
      next: (events) => {
        this.events = events;
      },
      error: (err) => {
        console.error('Грешка при зареждане на харесаните събития', err);
        this.events = [];
      }
    });
  }
}
