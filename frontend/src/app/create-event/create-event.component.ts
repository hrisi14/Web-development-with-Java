import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EventService } from '../../event/service/event.service';
import { HttpClientModule } from '@angular/common/http';
import { OnInit } from '@angular/core';

@Component({
  selector: 'app-create-event',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {
  event = {
    title: '',
    description: '',
    category: '',
    location: '',
    startDate: '',
    endDate: '',
    rules: '',
    organizerId: null,
    sponsorId: null
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

    this.eventService.addEvent(this.event).subscribe({
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
        this.errorMessage = 'Възникна грешка при създаване на събитието.';
      }
    });
  }
}
