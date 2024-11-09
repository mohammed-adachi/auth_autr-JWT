import { Component,OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { JwtService } from '../../service/jwt.service';
@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
 templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup

  constructor(
    private service: JwtService,
    private fb: FormBuilder
  ) { }
  register() {
    const userData = {
      "username": "admin",
      "role": "user",
      "email": "omar.adachi@usmba.ac.ma",
      "password": "44556677"
    };
    this.service.register(userData).subscribe(
      response => {
        console.log('Inscription réussie:', response);
      },
      error => {
        console.error('Erreur lors de l\'inscription:', error);
      }
    );
  }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      username: ['', [Validators.required]],
      role: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
}
/*
  passwordMathValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    if (password != confirmPassword) {
      formGroup.get('confirmPassword')?.setErrors({ passwordMismatch: true });
    } else {
      formGroup.get('confirmPassword')?.setErrors(null);
  }
  }
 */

  submitForm() {

    this.service.register({
      "username": "user1",
      "role": "user2",
      "email": "mohammmmed.adachi1@usmba.ac.ma",
      "password": "12345678"
    }).subscribe(
      (response) => {
        if (response.id != null) {
          alert("Hello " + response.username);
        }
      }
    )
  }

  }



