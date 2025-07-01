import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { UserRegister } from '../model/user-register.model'
import { Router } from '@angular/router';
import { SeparateNavBarComponent } from '../separate-nav-bar/separate-nav-bar.component';
//TO DO: add submission and validation handling!!!


@Component({
selector: 'app-register',
standalone: true,
imports: [CommonModule, FormsModule, SeparateNavBarComponent],
templateUrl: './register.component.html',
styleUrls: ['./register.component.css']
})
export class RegisterComponent {
userRegister: UserRegister = {

username: '',
firstName: '',
lastName: '',
email: '',
password: '',
role: ''
};

constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
   console.log('User Register Payload:', this.userRegister);
    this.authService.register(this.userRegister).subscribe({
      next: () => this.router.navigate(['/events-catalogue']),
      error: (err) => alert('Registration failed: ' + err.error.message),
    });
  }

    goToLogin() {
    this.router.navigate(['/login']);
  }
}
