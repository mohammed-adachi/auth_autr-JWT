import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './components/register/register.component';
import { _AuthComponent } from './auth.auhtService';
import { CommonModule } from '@angular/common';


const routes: Routes = [
  { path: "register", component: RegisterComponent },
  {path: 'home', component: _AuthComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),[CommonModule]],
  exports: [RouterModule]
})
export class AppRoutingModule { }
