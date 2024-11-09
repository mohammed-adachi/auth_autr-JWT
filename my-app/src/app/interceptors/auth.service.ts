import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
  export class AuthService {
    private apiUrl = 'http://localhost:8082/account';

    constructor(private http: HttpClient) { }

    register(data: any): Observable<any> {
      return this.http.post(`${this.apiUrl}/register`, data);
    }

    login(data: any): Observable<any> {
      return this.http.post(`${this.apiUrl}/login`, data);
    }
}
