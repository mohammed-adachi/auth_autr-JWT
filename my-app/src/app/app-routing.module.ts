import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { _AuthComponent } from './auth.auhtService';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  { path: "register", component: RegisterComponent },
  {path: 'home', component: _AuthComponent},
  {path: 'login', component: LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes),[CommonModule]],
  exports: [RouterModule]
})
export class AppRoutingModule { }
