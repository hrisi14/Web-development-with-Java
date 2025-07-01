import { Component, OnInit } from '@angular/core';
import { InvitationService } from '../services/invitation.service';
import { Invitation } from '../model/invitation.model';
import { ActivatedRoute, Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';


@Component({
selector: 'app-profile',
standalone:true,
imports: [CommonModule, RouterModule, NavbarComponent],
templateUrl: './profile.component.html',
styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
invitations: Invitation[] = [];

constructor(
    private route: ActivatedRoute,
    private invitationService: InvitationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userId = Number(this.route.snapshot.paramMap.get('id'));

    console.log('User ID from route:', userId);

    if (userId) {
      this.invitationService.getInvitationsForUser(userId).subscribe({
        next: (data) => {
        console.log('Invitations received from API:', data);
        this.invitations = data
},
        error: (err) => console.error('Failed to fetch invitations', err)
      });
    } else {
      console.warn('User is not logged in.');
      this.router.navigate(['/login']);
    }
  }
}


