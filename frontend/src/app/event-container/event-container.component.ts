import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { Event } from '../model/event.model';

@Component({
  selector: 'app-event-container',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './event-container.component.html',
  styleUrls: ['./event-container.component.css']
})
export class EventContainerComponent {
  @Input() event!: Event;

  constructor(private router: Router) {}

  goToReview() {
    if (this.event?.id) {
      this.router.navigate(['/review-event', this.event.id]);
    }
  }
}
