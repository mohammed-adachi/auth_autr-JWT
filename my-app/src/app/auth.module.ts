import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { _AuthComponent } from './auth.auhtService';

@NgModule({
  declarations: [
    _AuthComponent
  ],
  imports: [
    CommonModule  // Ajouter CommonModule ici pour que ngIf fonctionne dans AuthComponent
  ],
  exports: [_AuthComponent]
})
export class AuthModule { }
