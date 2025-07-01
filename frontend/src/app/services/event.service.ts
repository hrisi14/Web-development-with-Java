import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Event } from '../model/event.model';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  private apiUrl = 'http://localhost:8080/api/events';

  constructor(private http: HttpClient) {}

  getEvent(id: number): Observable<Event> {
    return this.http.get<Event>(`${this.apiUrl}/${id}`);
  }

  getAllEvents(): Observable<Event[]> {
    console.debug('Fetching all events from API:', this.apiUrl);
    return this.http.get<Event[]>(this.apiUrl);
  }

  addEvent(event: Partial<Event>): Observable<Event> {
    return this.http.post<Event>(this.apiUrl, event);
  }

  toggleLike(eventId: number, userId: number) {
    return this.http.post(`${this.apiUrl}/${eventId}/like?userId=${userId}`, null, { responseType: 'text' });
  }

  toggleFollow(eventId: number, userId: number) {
    return this.http.post(`${this.apiUrl}/${eventId}/follow?userId=${userId}`, null, { responseType: 'text' });
  }

  toggleVisit(eventId: number, userId: number) {
    return this.http.post(`${this.apiUrl}/${eventId}/visit?userId=${userId}`, null, { responseType: 'text' });
  }
}
