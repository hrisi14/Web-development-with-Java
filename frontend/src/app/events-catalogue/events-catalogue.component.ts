import { Component } from '@angular/core';
import { EventContainerComponent } from '../event-container/event-container.component';

@Component({
  selector: 'app-events-catalogue',
  imports: [EventContainerComponent],
  standalone: true,
  templateUrl: './events-catalogue.component.html',
  styleUrl: './events-catalogue.component.css'
})
export class EventsCatalogueComponent {

}
