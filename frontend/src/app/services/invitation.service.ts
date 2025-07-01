import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Invitation } from '../model/invitation.model';

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

   getInvitationsForUser(userId: number): Observable<Invitation[]> {
       console.log(`${userId}`);
        return this.http.get<Invitation[]>(`${this.apiUrl}/user/${userId}`);

}

}
