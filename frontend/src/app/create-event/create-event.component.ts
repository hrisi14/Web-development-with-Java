import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EventService } from '../services/event.service';
import { HttpClientModule } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Event } from '../model/event.model';
import { AuthService } from '../services/auth.service';

import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-create-event',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, NavbarComponent],
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {
  event: Event = {
    title: '',
    description: '',
    category: '',
    location: '',
    startDate: '',
    endDate: '',
    rules: '',
    likes: 0,
    imageUrl: '',
    organizerId: null,
    sponsorId: null
  };

  successMessage = '';
  errorMessage = '';

  constructor(
    private eventService: EventService,
    private router: Router,
    private authService: AuthService
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

    const organizerId = this.authService.getCurrentUserId();
    if (!organizerId) {
      this.errorMessage = 'Трябва да сте влезли в профила си, за да създадете събитие.';
      return;
    }

    const eventToSend = {
      ...this.event,
      startDate: new Date(this.event.startDate).toISOString(),
      endDate: new Date(this.event.endDate).toISOString(),
      likes: this.event.likes ?? 0,
      imageUrl: this.event.imageUrl ?? '',
      organizerId
    };

    this.eventService.addEvent(eventToSend).subscribe({
      next: () => {
        this.successMessage = 'Събитието беше създадено успешно!';
        this.errorMessage = '';
        this.event = {
          title: '',
          description: '',
          category: '',
          location: '',
          startDate: '',
          endDate: '',
          rules: '',
          likes: 0,
          imageUrl: '',
          organizerId: null,
          sponsorId: null
        };
        setTimeout(() => {
          this.router.navigate(['/events-catalogue']);
        }, 2000);
      },
      error: (err: unknown) => {
        console.error('Error creating event', err);
        this.successMessage = '';
        this.errorMessage = 'Възникна грешка при създаване на събитието. Проверете дали всички полета са попълнени коректно.';
      }
    });
  }
}
