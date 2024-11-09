import { Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { _AuthComponent  } from './auth.auhtService';




export const routes: Routes = [
  { path: "register", component: RegisterComponent },
  {path:"home", component: _AuthComponent  },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];
