import { Component, Input } from '@angular/core';
import { Event } from '../model/event.model';

@Component({
  selector: 'app-event-container',
  standalone: true,
  imports: [],
  templateUrl: './event-container.component.html',
  styleUrls: ['./event-container.component.css']
})
export class EventContainerComponent {
  @Input() event!: Event;
}
