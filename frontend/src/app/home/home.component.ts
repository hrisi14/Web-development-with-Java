import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

import { SeparateNavBarComponent } from '../separate-nav-bar/separate-nav-bar.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, SeparateNavBarComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(private router: Router) {}

  ngOnInit() {
     localStorage.removeItem('currentUserId');
  }
  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }
}
