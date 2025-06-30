import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserRegister } from '../model/user-register.model'
import { UserLogin } from '../model/user-login.model'
import { tap } from 'rxjs/operators';

@Injectable({
providedIn: 'root',
})
export class AuthService {
private apiUrl = 'http://localhost:8080/api/users';

constructor(private http: HttpClient) {}

  register(userRegister: UserRegister): Observable<any> {
    console.log('auth.service.ts-> User Register Payload:', userRegister);
    return this.http.post(`${this.apiUrl}/register`, userRegister);
  }

  login(userLogin: UserLogin): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, userLogin).pipe(
      tap((response: any) => {
        localStorage.setItem('currentUserId', response.id);
      })
    );
  }

  getCurrentUserId(): number | null {
    const id = localStorage.getItem('currentUserId');
    return id ? Number(id) : null;
  }
}
