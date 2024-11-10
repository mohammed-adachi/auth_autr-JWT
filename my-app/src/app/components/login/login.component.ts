import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtService } from '../../service/jwt.service';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  imagePath: string="../assets/images/prodigy_infotech_logo.jpg";
  loginForm!: FormGroup

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
    })
  }

  submitForm() {
    if (this.loginForm.valid) {
      const formValues = this.loginForm.value; // L'objet JavaScript

      // Options HTTP avec en-tête Content-Type
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      };  
    this.service.login(
      formValues, httpOptions
    ).subscribe(
      (response) => {
        if (response.username!= null) {
          alert("Hello " + response.username);
        }
      }
    )
  }

  }

}
