import { Component, OnInit } from '@angular/core';
import { Event } from '../model/event.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

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

constructor() {}  //Do I need a router here?

  ngOnInit(): void {}

  like() {
 }

  follow() {
    console.log('Follow clicked');
  }

  attend() {
    console.log('Attend clicked');
  }

  invite() {
    console.log('Invite clicked');
  }

  sendMessage(message: string) {
    console.log('Message sent:', message);
  }
}
