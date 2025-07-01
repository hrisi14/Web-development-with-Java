import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-my-events',
  standalone: true,
  imports: [RouterModule],
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
