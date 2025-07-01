import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-my-events',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './my-events.component.html',
  styleUrls: ['./my-events.component.css']
})
export class MyEventsComponent {
  constructor(private authService: AuthService) {}

  get userId(): number | null {
    const id = this.authService.getCurrentUserId();
    console.log('MyEvents userId:', id);
    return id;
  }
}
