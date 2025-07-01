import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-my-events',
  standalone: true,
  imports: [RouterModule, NavbarComponent],
  templateUrl: './my-events.component.html',
  styleUrls: ['./my-events.component.css']
})
export class MyEventsComponent implements OnInit {
  userId: number | null = null;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.userId = this.authService.getCurrentUserId();
    console.log('MyEvents userId:', this.userId);
  }
}
