import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { Event } from '../model/event.model';

import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-event-container',
  standalone: true,
  imports: [CommonModule, RouterModule, NavbarComponent],
  templateUrl: './event-container.component.html',
  styleUrls: ['./event-container.component.css']
})
export class EventContainerComponent {
  @Input() event!: Event;

  constructor(private router: Router) {}

  goToReview() {
    const userId = Number(localStorage.getItem('userId'));
    console.log("User id");
    console.log(userId);
    if (userId < 1) {
      this.router.navigate(['/home']);
      return;
   }
    if (this.event?.id) {
      this.router.navigate(['/review-event', this.event.id]);
    }
  }
}
