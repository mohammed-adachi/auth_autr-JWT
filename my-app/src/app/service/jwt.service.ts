import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

const BASE_URL = 'http://localhost:8082/account/';
@Injectable({
  providedIn: 'root'
})
export class JwtService {


  constructor(private http: HttpClient) {


  }

  register(signRequest: any): Observable<any> {
    return this.http.post(BASE_URL + 'register', signRequest);
  }
  private handleError(error: any) {
    console.error('Erreur détectée :', error);
    return throwError(error);
  }

  }






