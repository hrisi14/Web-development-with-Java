import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EventService } from '../services/event.service';
import { HttpClientModule } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Event as EventModel } from '../model/event.model';
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
  event: EventModel = {
    title: '',
    description: '',
    category: '',
    location: '',
    startDate: '',
    endDate: '',
    rules: '',
    likes: 0,
    followers: 0,
    visitors: 0,
    imageUrl: null,
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
      followers: this.event.followers ?? 0,
      visitors: this.event.visitors ?? 0,
      imageUrl: this.event.imageUrl ?? null,
      organizerId,
      sponsorId: this.event.sponsorId ?? 0
    };

    console.log('Изпращане на събитие към backend:', eventToSend);

    this.eventService.addEvent(eventToSend).subscribe({
      next: (result) => {
        console.log('Успешно създадено събитие:', result);
        this.successMessage = 'Събитието беше създадено успешно!';
        this.errorMessage = '';
        this.event = {
          title: '',
          description: '',
          category: '',
          location: '',
          imageUrl: null,
          startDate: '',
          endDate: '',
          rules: '',
          likes: 0,
          followers: 0,
          visitors: 0,
          organizerId: null,
          sponsorId: null
        };
        setTimeout(() => {
          this.router.navigate(['/events-catalogue']);
        }, 2000);
      },
      error: (err: any) => {
        console.error('Error creating event', err);
        if (err && err.error) {
          console.error('Backend error:', err.error);
        }
        this.successMessage = '';
        this.errorMessage = 'Възникна грешка при създаване на събитието. Проверете дали всички полета са попълнени коректно.';
      }
    });
  }

  onImageSelected(event: any) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      console.log('Избран файл:', file);
      const reader = new FileReader();
      reader.onload = () => {
        console.log('Base64 изображение:', reader.result);
        this.event.imageUrl = reader.result as string;
      };
      reader.onerror = (e) => {
        console.error('Грешка при четене на изображението:', e);
      };
      reader.readAsDataURL(file);
    } else {
      console.warn('Не е избран файл за изображение');
    }
  }
}
