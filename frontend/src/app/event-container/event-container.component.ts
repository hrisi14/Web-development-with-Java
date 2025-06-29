import { Component, OnInit } from '@angular/core';
import { EventService } from '../../event/service/event.service'; // ⬅️ Този път трябва да съвпада
import { Event } from '../../event/model/event.model'; // ⬅️ Твоя DTO интерфейс

@Component({
  selector: 'app-event-container',
  imports: [],
  standalone: true,
  templateUrl: './event-container.component.html',
  styleUrl: './event-container.component.css'
})
export class EventContainerComponent implements OnInit {
  event?: Event;

  constructor(private eventService: EventService) {}

  ngOnInit() {
    this.eventService.getEvent(1).subscribe(event => this.event = event);
  }
}
