import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { EventsCatalogueComponent } from './events-catalogue/events-catalogue.component';

export const routes: Routes = [
{ path: 'register', component: RegisterComponent },
{ path: '', redirectTo: 'register', pathMatch: 'full' },
{ path: 'login', component: LoginComponent },
{ path: 'events-catalogue', component: EventsCatalogueComponent },
];
