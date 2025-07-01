import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EventService } from '../services/event.service';
import { Event } from '../model/event.model';
import { AuthService } from '../services/auth.service';
import { InvitationService } from '../services/invitation.service';
import { FormsModule } from '@angular/forms';

import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-event-review',
  standalone: true,
  imports: [CommonModule, FormsModule, NavbarComponent],
  templateUrl: './event-review.component.html',
  styleUrls: ['./event-review.component.css']
})
export class EventReviewComponent implements OnInit {
  event?: Event;

  receiverName: string = '';
  showInviteForm = false;

  constructor(
    private route: ActivatedRoute,
    private eventService: EventService,
    private authService: AuthService
    private invitationService: InvitationService

  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.eventService.getEvent(id).subscribe((event: Event) => {
        console.log('Получено събитие:', event);
        this.event = event;
      });
    }
  }

  like() {
    const userId = this.authService.getCurrentUserId();
    if (!this.event?.id || !userId) return;
    this.eventService.toggleLike(this.event.id, userId).subscribe((res: any) => {
      if (res === 'liked') {
        this.event!.likes = (this.event!.likes ?? 0) + 1;
      } else if (res === 'unliked') {
        this.event!.likes = (this.event!.likes ?? 1) - 1;
      }
    });
  }

  follow() {
    const userId = this.authService.getCurrentUserId();
    if (!this.event?.id || !userId) return;
    this.eventService.toggleFollow(this.event.id, userId).subscribe((res: any) => {
      if (res === 'followed') {
        this.event!.followers = (this.event!.followers ?? 0) + 1;
      } else if (res === 'unfollowed') {
        this.event!.followers = (this.event!.followers ?? 1) - 1;
      }
    });
  }

  visit() {
    const userId = this.authService.getCurrentUserId();
    if (!this.event?.id || !userId) return;
    this.eventService.toggleVisit(this.event.id, userId).subscribe((res: any) => {
      if (res === 'visited') {
        this.event!.visitors = (this.event!.visitors ?? 0) + 1;
      } else if (res === 'unvisited') {
        this.event!.visitors = (this.event!.visitors ?? 1) - 1;
      }
    });
  }

invite(): void {
  this.showInviteForm = true;
}

submitInvitation(): void {
  if (!this.event || this.event.id === undefined) {
    alert('Event not loaded yet.');
    return;
  }

  const senderId = Number(localStorage.getItem('userId'));
  if (!this.receiverName) {
    alert('Please enter a friend’s username.');
    return;
  }

  this.invitationService.sendInvitation({
    senderId,
    receiverName: this.receiverName,
    eventId: this.event.id
  }).subscribe({
    next: () => {
      alert("Invitation sent!");
      this.receiverName = '';
      this.showInviteForm = false;
    },
    error: err => alert("Failed to send invitation: " + err.message)
  });
}
}
