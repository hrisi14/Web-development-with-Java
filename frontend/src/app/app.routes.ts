import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { EventsCatalogueComponent } from './events-catalogue/events-catalogue.component';
import { CreateEventComponent } from './create-event/create-event.component';
import { EventReviewComponent } from './event-review/event-review.component';
import {EventEditComponent } from './event-edit/event-edit.component';

export const routes: Routes = [
{ path: 'register', component: RegisterComponent },
{ path: '', redirectTo: 'register', pathMatch: 'full' },
{ path: 'login', component: LoginComponent },
{ path: 'events-catalogue', component: EventsCatalogueComponent },
{ path: 'create-event', component: CreateEventComponent },
{ path: 'review-event', component: EventReviewComponent },
{ path: 'edit-event', component: EventEditComponent },
];
