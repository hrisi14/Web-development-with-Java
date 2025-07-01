import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { UserLogin } from '../model/user-login.model'
import { Router } from '@angular/router';



//To test submission and add data validation!

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  userLogin: UserLogin = {
  username: '',
  password: '',
};

constructor(private authService: AuthService, private router: Router) {}

//To add events submission login here!!!

  onSubmit() {
    console.log('Login Payload:', this.userLogin);
    this.authService.login(this.userLogin).subscribe({

      next: () =>  this.router.navigate(['/events-catalogue']),

      error: (err) => alert('Login failed: ' + err.error.message),
    });
  }

  goToRegistration() {
    this.router.navigate(['/register']);
  }
}
