import { HttpClient } from "@angular/common/http";
import { Component, Injectable, NgModule, OnInit } from "@angular/core";
import { JwtService } from "./service/jwt.service";
import { CommonModule } from "@angular/common";
@Component({
  selector: 'app-home',
  imports:[CommonModule],
  standalone:true,
  templateUrl: './auth.component.html'

})
@Injectable({
  providedIn:'root'
})
export class _AuthComponent {
  homeData:any;

constructor(private Http:HttpClient,
  private service: JwtService,
){

}
ngOnInit(): void {
  this.service.getHomeData().subscribe((data) => {
    this.homeData = data;
    console.log(this.homeData);
    // stocke les données reçues pour l'afficher dans le template
  });
}
}
