import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventContainerComponent } from '../event-container/event-container.component';
import { EventService } from '../services/event.service';
import { Event } from '../model/event.model';

import { NavbarComponent } from '../navbar/navbar.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-events-catalogue',
  standalone: true,
  imports: [CommonModule, EventContainerComponent, NavbarComponent],
  templateUrl: './events-catalogue.component.html',
  styleUrls: ['./events-catalogue.component.css']
})
export class EventsCatalogueComponent implements OnInit {
  events: Event[] = [];

  constructor(private eventService: EventService, private router: Router) {}

  ngOnInit() {
    this.loadEvents();
  }

  loadEvents() {
    this.eventService.getAllEvents().subscribe({
      next: (events) => {
        console.log('Получени събития:', events);
        this.events = events;


      },
      error: (err) => {
        console.error('Грешка при зареждане на събитията', err);
        this.events = [];
      }
    });
  }
}
