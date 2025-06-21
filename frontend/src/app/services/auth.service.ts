import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserRegister } from '../model/user-register.model'
import { UserLogin } from '../model/user-login.model'

@Injectable({
providedIn: 'root',
})
export class AuthService {
private apiUrl = 'http://localhost:8080/api/users';

constructor(private http: HttpClient) {}

  register(userRegister: UserRegister): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, userRegister);
  }

  login(userLogin: UserLogin): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, userLogin);
}
}
