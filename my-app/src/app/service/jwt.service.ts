import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap, throwError } from 'rxjs';

const BASE_URL = 'http://localhost:8082/account/';
const apiUrl = 'http://localhost:8082/home';
export interface RegisterResponse {

}
@Injectable({
  providedIn: 'root'
})
export class JwtService {



  constructor(private http: HttpClient) {


  }

  register(signRequest: any,httpOptions:any): Observable<any> {
    console.log(signRequest)
    return this.http.post("http://localhost:8082/acount/register", signRequest,httpOptions);
  }
  private handleError(error: any) {
    console.error('Erreur détectée :', error);
    return throwError(error);
  }
  getHomeData(): Observable<any> {
    return this.http.get('http://localhost:8082/home');
  }

  saveToken(token: string): void {
    localStorage.setItem('token', token);
  }
  getToken(): string | null {
    return localStorage.getItem('token');
  }
  }






