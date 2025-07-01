import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { EventsCatalogueComponent } from './events-catalogue/events-catalogue.component';
import { CreateEventComponent } from './create-event/create-event.component';
import { EventReviewComponent } from './event-review/event-review.component';
import { EventEditComponent } from './event-edit/event-edit.component';
import { HomeComponent } from './home/home.component';

import { SeparateCatalogueComponent } from './separate-catalogue/separate-catalogue.component';
import { LikedEventsComponent } from './liked-events/liked-events.component';
import { VisitedEventsComponent } from './visited-events/visited-events.component';
import { MyEventsComponent } from './my-events/my-events.component';
import { FollowedEventsComponent } from './followed-events/followed-events.component';
import { OrganizedEventsComponent } from './organized-events/organized-events.component';

export const routes: Routes = [
{ path: 'register', component: RegisterComponent },
{ path: 'home', component: HomeComponent },
{ path: '', redirectTo: 'home', pathMatch: 'full' },
{ path: 'login', component: LoginComponent },
{ path: 'events-catalogue', component: EventsCatalogueComponent },
{ path: 'create-event', component: CreateEventComponent },
{ path: 'review-event/:id', component: EventReviewComponent },
{ path: 'edit-event', component: EventEditComponent },
{ path: 'separate-catalogue', component: SeparateCatalogueComponent },
{ path: 'user/:id/liked-events', component: LikedEventsComponent },
{ path: 'user/:id/visited-events', component: VisitedEventsComponent },
{ path: 'user/:id/followed-events', component: FollowedEventsComponent },
{ path: 'user/:id/organized-events', component: OrganizedEventsComponent },
{ path: 'organized-events', component: OrganizedEventsComponent },
{ path: 'my-events', component: MyEventsComponent },
];
