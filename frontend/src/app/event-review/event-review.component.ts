import { Component, OnInit } from '@angular/core';
import { Event } from '../model/event.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { InvitationService } from '../services/invitation.service';
import { ActivatedRoute } from '@angular/router';

@Component({
selector: 'app-event-review',
standalone: true,
imports: [CommonModule, FormsModule],
templateUrl: './event-review.component.html',
styleUrls: ['./event-review.component.css']
})
export class EventReviewComponent implements OnInit {
event: Event = {
id: 1,
title: 'Open-Air Music Festival',
description: 'A full-day music festival featuring live bands, food trucks, and activities for all ages.',
category: 'Music',
location: 'Central Park',
startDate: '2025-08-15',
endDate: '2025-08-15',
rules: 'No outside food. Bring ID.',
imageUrl: 'assets/event.jpg',
likes: 124
};

constructor(
  private route: ActivatedRoute,
  private invitationService: InvitationService
) {}

 ngOnInit(): void {
  const id = this.route.snapshot.paramMap.get('id');
  if (id) {
    this.event.id = +id;
    // Optionally: fetch the event from the server
    // this.eventService.getEventById(+id).subscribe(event => this.event = event);
  }
}

  like() {
 }

  follow() {
    console.log('Follow clicked');
  }

  attend() {
    console.log('Attend clicked');
  }

  invite(): void {
  const userData = localStorage.getItem('currentUserId');
  const senderId = userData ? JSON.parse(userData).id : null;

 const input = prompt("Enter friend’s user ID to invite:");
  if (!input) {
    alert("Invitation canceled.");
    return;
  }
  const receiverId = parseInt(input, 10);
  if (isNaN(receiverId)) {
    alert("Invalid user ID.");
    return;
  }

  const eventId = this.event?.id;
  if (!senderId || eventId === undefined) {
    alert("Missing sender or event info.");
    return;
  }

  this.invitationService.sendInvitation({ senderId, receiverId, eventId })
    .subscribe({
      next: () => alert("Invitation sent!"),
      error: err => alert("Failed to send invitation: " + err.message)
    });
}

  sendMessage(message: string) {
    console.log('Message sent:', message);
  }
}
