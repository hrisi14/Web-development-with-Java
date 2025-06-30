import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventContainerComponent } from '../event-container/event-container.component';
import { EventService } from '../services/event.service';
import { Event } from '../model/event.model';

@Component({
  selector: 'app-events-catalogue',
  standalone: true,
  imports: [CommonModule, EventContainerComponent],
  templateUrl: './events-catalogue.component.html',
  styleUrls: ['./events-catalogue.component.css']
})
export class EventsCatalogueComponent implements OnInit {
  events: Event[] = [];

  constructor(private eventService: EventService) {}

  ngOnInit() {
    this.eventService.getAllEvents().subscribe({
      next: (events) => this.events = events,
      error: (err) => {
        console.error('Грешка при зареждане на събитията', err);
        this.events = [];
      }
    });
  }
}
