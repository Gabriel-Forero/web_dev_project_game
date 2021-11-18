import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/servicios/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  crud:boolean = true;
  tripulacion:boolean = true;
  constructor(private router:Router, private auth: AuthService) {
   
    console.log(this.auth.getUserRole());
    if(this.auth.getUserRole() == 'ADMIN')
    {
      //this.tripulacion = false;
    }
    
    if( this.auth.getUserRole() == 'CAPTAIN')
    {
      console.log(this.auth.getUserRole());
      //this.crud = false;
    }

    console.log(this.crud);
    console.log(this.tripulacion);

   }

  ngOnInit(): void {
   

    
  }
  
  logOut()
  {
    this.auth.logOut();
    this.router.navigate(['/login']);
  }
  





}
