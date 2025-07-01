import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
providedIn: 'root',
})
export class InvitationService {
private apiUrl = 'http://localhost:8080/api/invitations';

constructor(private http: HttpClient) {}

  sendInvitation(invitationData: { senderId: number, receiverName: string, eventId: number }): Observable<any> {
    console.log("Send invitation from frontend" + invitationData);

    return this.http.post(`${this.apiUrl}/send`, invitationData);
  }

  // Optional: Get invitations sent/received
  getInvitationsByUser(userId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/user/${userId}`);
  }
}
