import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EventService } from '../services/event.service';
import { Event } from '../model/event.model';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-event-review',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './event-review.component.html',
  styleUrls: ['./event-review.component.css']
})
export class EventReviewComponent implements OnInit {
  event?: Event;

  constructor(
    private route: ActivatedRoute,
    private eventService: EventService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.eventService.getEvent(id).subscribe((event: Event) => {
        console.log('Получено събитие:', event);
        this.event = event;
      });
    }
  }

  like() {
    const userId = this.authService.getCurrentUserId();
    if (!this.event?.id || !userId) return;
    this.eventService.toggleLike(this.event.id, userId).subscribe((res: any) => {
      if (res === 'liked') {
        this.event!.likes = (this.event!.likes ?? 0) + 1;
      } else if (res === 'unliked') {
        this.event!.likes = (this.event!.likes ?? 1) - 1;
      }
    });
  }

  follow() {
    console.log('Follow clicked');
  }

  attend() {
    console.log('Attend clicked');
  }

  invite() {
    console.log('Invite clicked');
  }
}
