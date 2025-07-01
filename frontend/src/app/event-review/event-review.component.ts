import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EventService } from '../services/event.service';
import { Event } from '../model/event.model';
import { InvitationService } from '../services/invitation.service';

@Component({
  selector: 'app-event-review',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './event-review.component.html',
  styleUrls: ['./event-review.component.css']
})
export class EventReviewComponent implements OnInit {
  event?: Event;

  constructor(
    private route: ActivatedRoute,
    private eventService: EventService,
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
   }

    follow() {
      console.log('Follow clicked');
    }

    attend() {
      console.log('Attend clicked');
    }

   invite(): void {
  if (!this.event || this.event.id === undefined) {
  alert('Event not loaded yet.');
  return;
}

    const senderId = Number(localStorage.getItem('currentUserId'));


    console.log("Sender");

    const input = prompt("Enter friend’s user ID to invite:");
    if (!input) return;

    const receiverId = parseInt(input, 10);
    if (isNaN(receiverId)) {
      alert("Invalid user ID.");
      return;
    }
    this.invitationService.sendInvitation({
      senderId,
      receiverId,
      eventId: this.event.id
    }).subscribe({
      next: () => alert("Invitation sent!"),
      error: err => alert("Failed to send invitation: " + err.message)
    });
  }
}
