import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { EventService } from '../../event/service/event.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-create-event',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent {
  eventForm: FormGroup;
  errorMessage = '';
  successMessage = '';

  constructor(
    private fb: FormBuilder,
    private eventService: EventService,
    private router: Router
  ) {
    this.eventForm = this.fb.group({
      title: ['', Validators.required],
      description: [''],
      category: [''],
      location: [''],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      rules: [''],
      organizerId: [null],
      sponsorId: [null]
    });
  }

  onSubmit() {
    console.log('Формата е подадена', this.eventForm.value);
    if (this.eventForm.valid) {
      this.eventService.addEvent(this.eventForm.value).subscribe({
        next: () => {
          this.successMessage = 'Събитието беше създадено успешно!';
          this.errorMessage = '';
          this.eventForm.reset();
          setTimeout(() => {
            this.router.navigate(['/events']);
          }, 2000);
        },
        error: (err: unknown) => {
          console.error('Error creating event', err);
          this.successMessage = '';
          this.errorMessage = 'Възникна грешка при създаване на събитието.';
        }
      });
    } else {
      this.errorMessage = 'Моля, попълнете всички задължителни полета.';
    }
  }
}
