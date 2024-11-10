import { Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { _AuthComponent  } from './auth.auhtService';
import { LoginComponent } from './components/login/login.component'; 




export const routes: Routes = [
  { path: "register", component: RegisterComponent },
  { path: "login", component: LoginComponent },
  {path:"home", component: _AuthComponent  },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];
