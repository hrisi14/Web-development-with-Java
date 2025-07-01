import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Event } from '../model/event.model';

@Injectable({
  providedIn: 'root'
})
export class  UserService {
  private apiUrl = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) {}

  getLikedEvents(userId: number): Observable<Event[]> {
    return this.http.get<Event[]>(`${this.apiUrl}/${userId}/liked-events`);
  }

}
