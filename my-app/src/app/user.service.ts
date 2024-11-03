import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8082/home';


  constructor(private HttpClient:HttpClient ) { }
getUser(){
  return this.HttpClient.get(this.apiUrl);
}
}
