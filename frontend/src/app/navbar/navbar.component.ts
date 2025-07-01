import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent {
  showDropdown = false;

  constructor(private authService: AuthService) {}

  get userId(): number | null {
    const id = this.authService.getCurrentUserId();
    console.log('Navbar userId:', id);
    return id;
  }
}
