import { Component, OnInit } from '@angular/core';
import { Event } from '../model/event.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
selector: 'app-event-edit',
standalone: true,
imports: [CommonModule, FormsModule],
templateUrl: './event-edit.component.html',
styleUrls: ['./event-edit.component.css']
})
export class EventEditComponent {
event: Event = {
id: 1,
title: 'Примерно събитие',
description: 'Описание...',
category: 'Развлекателно',
location: 'София',
startDate: '2025-07-01',
endDate: '2025-07-03',
rules: 'Без храни и напитки.',
likes: 42,
imageUrl: 'assets/sample-event.jpg'
};

saveChanges() {
    console.log('Saved event:', this.event);
    // Send PUT/POST request here
  }

  deleteEvent() {
    console.log('Deleting event with ID:', this.event.id);
    // Trigger delete API here
  }
}
