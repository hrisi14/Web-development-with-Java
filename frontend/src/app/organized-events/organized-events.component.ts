import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Event } from '../model/event.model';
import { EventService } from '../services/event.service';
import { AuthService } from '../services/auth.service';
import { EventContainerComponent } from '../event-container/event-container.component';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-organized-events',
  standalone: true,
  imports: [CommonModule, EventContainerComponent, NavbarComponent],
  templateUrl: './organized-events.component.html',
  styleUrls: ['./organized-events.component.css']
})
export class OrganizedEventsComponent implements OnInit {
  events: Event[] = [];
  userId: number | null = null;

  constructor(
    private eventService: EventService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.userId = this.authService.getCurrentUserId();
    if (this.userId !== null) {
      this.eventService.getAllEvents().subscribe(events => {
        this.events = events.filter(e => e.organizerId === this.userId);
      });
    }
  }

   deleteEvent(eventId: number): void {
    if (confirm('Сигурни ли сте, че искате да изтриете това събитие?')) {
      this.eventService.deleteEvent(eventId).subscribe(() => {
        this.events = this.events.filter(e => e.id !== eventId);
      });
    }
  }

}
