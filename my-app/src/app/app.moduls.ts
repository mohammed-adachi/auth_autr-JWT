import { NgModule } from '@angular/core';
import { NgIf } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { JwtService } from './service/jwt.service';
import { RegisterComponent } from './components/register/register.component';
import { AuthInterceptor } from './auth.interceptor';
import { _AuthComponent  } from './auth.auhtService';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './components/login/login.component';


@NgModule({

  declarations: [
    AppComponent,
    HttpClientModule,
    RegisterComponent,
    _AuthComponent,
    LoginComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    NgIf
  ],
  providers: [
    JwtService,{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
