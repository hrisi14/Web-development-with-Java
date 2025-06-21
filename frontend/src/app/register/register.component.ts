import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';

//TO DO: add submission and validation handling!!!


@Component({
selector: 'app-register',
standalone: true,
imports: [CommonModule, FormsModule],
templateUrl: './register.component.html',
styleUrls: ['./register.component.css']
})
export class RegisterComponent {
user = {
username: '',
firstName: '',
lastName: '',
email: '',
password: '',
};

constructor(private authService: AuthService) {}

  onSubmit() {
    this.authService.register(this.user).subscribe({
      next: () => alert('Registration successful!'),
      error: (err) => alert('Registration failed: ' + err.error.message),
    });
  }
}
