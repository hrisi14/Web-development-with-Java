import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { EventService } from '../services/event.service';
import { Event } from '../model/event.model';
import { InvitationService } from '../services/invitation.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-event-review',
  standalone: true,
  imports: [CommonModule, FormsModule],
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
  this.showInviteForm = true;
}

submitInvitation(): void {
  if (!this.event || this.event.id === undefined) {
    alert('Event not loaded yet.');
    return;
  }

  const senderId = Number(localStorage.getItem('currentUserId'));
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
