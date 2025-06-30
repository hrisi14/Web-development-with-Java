import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Event } from '../model/event.model';

@Component({
  selector: 'app-event-container',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './event-container.component.html',
  styleUrls: ['./event-container.component.css']
})
export class EventContainerComponent {
  @Input() event!: Event;
}
