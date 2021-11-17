import { Component, OnInit } from '@angular/core';

import { AuthService } from 'src/app/servicios/auth.service';
import { TripulacionService } from 'src/app/servicios/tripulacion.service';

@Component({
  selector: 'app-tripulacion',
  templateUrl: './tripulacion.component.html',
  styleUrls: ['./tripulacion.component.css']
})
export class TripulacionComponent implements OnInit {
  
  docUser:any = '';
  team:any = {};
  user:any[] = [];
  asset:any[] = [];
  role:any = '';
  constructor(private authService:AuthService, private service:TripulacionService) { }

  ngOnInit(): void {
    this.docUser = this.authService.getUserDoc();
    this.role =  this.authService.getUserRole();
    console.log(  this.role);
    this.getTeam(this.docUser);
    
  }
  
  getTeam(id:string)
  {
    let idTeam:string;
    console.log(id);
    this.service.getTeam(id).subscribe(data =>{
      console.log(data);
      this.team = data;
      idTeam = data.teamId;
      this.getUser(idTeam);
      this.getAsset(idTeam);
    });
  
   
   
  }

  getUser(id:string)
  {
    this.service.getUser(id).subscribe(data =>{
      this.user = [];
      data.forEach((element:any) => {
        this.user.push({
          id:element.userId,
          ...element
        });
      });
    });
  }

  getAsset(id:string)
  {
    this.service.getAsset(id).subscribe(data =>{
      this.asset = [];
      data.forEach((element:any) => {
        this.asset.push({
          id:element.userId,
          ...element
        });
      });
    });
  }






}
