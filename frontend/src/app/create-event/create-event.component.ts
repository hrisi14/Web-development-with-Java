import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EventService } from '../services/event.service';
import { HttpClientModule } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Event } from '../model/event.model';

@Component({
  selector: 'app-create-event',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {
  event: Event = {
    id: 0,
    title: '',
    description: '',
    category: '',
    location: '',
    startDate: '',
    endDate: '',
    rules: '',
    likes: 0,
    imageUrl: 'http//example.com/default-image.jpg',
    organizerId: 1,
    sponsorId: 1
  };

  successMessage = '';
  errorMessage = '';

  constructor(
    private eventService: EventService,
    private router: Router
  ) {}

  ngOnInit() {
    console.log('CreateEventComponent зареден');
  }

  onSubmit() {
    console.log('Форма:', this.event);
    if (!this.event.title || !this.event.startDate || !this.event.endDate) {
      this.errorMessage = 'Моля, попълнете всички задължителни полета.';
      return;
    }
    if (new Date(this.event.startDate) >= new Date(this.event.endDate)) {
      this.errorMessage = 'Началната дата трябва да е преди крайната дата.';
      return;
    }
    const eventToSend = { ...this.event };
    delete (eventToSend as any).id;

    this.eventService.addEvent(eventToSend).subscribe({
      next: () => {
        this.successMessage = 'Събитието беше създадено успешно!';
        this.errorMessage = '';
        this.event = {
          id: 0,
          title: '',
          description: '',
          category: '',
          location: '',
          startDate: '',
          endDate: '',
          rules: '',
          likes: 0,
          imageUrl: 'https://example.com/default-image.jpg',
          organizerId: 1,
          sponsorId: 1
        };
        setTimeout(() => {
          this.router.navigate(['/events-catalogue']);
        }, 2000);
      },
      error: (err: unknown) => {
        console.error('Error creating event', err);
        this.successMessage = '';
        this.errorMessage = 'Възникна грешка при създаване на събитието.';
      }
    });
  }
}
