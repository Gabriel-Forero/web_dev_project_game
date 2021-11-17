import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/servicios/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  crud:boolean = false;
  tripulacion:boolean = false;
  constructor(private router:Router, private auth: AuthService) {
   
    if(this.auth.admin)
    {
      this.crud = true;
      this.tripulacion = true;
    }
    
    if( this.auth.getUserRole() == 'CAPTAIN')
    {
      console.log(this.auth.getUserRole());
      this.tripulacion = true;
    }
   }

  ngOnInit(): void {
   

    
  }
  
  logOut()
  {
    this.auth.logOut();
    this.router.navigate(['/login']);
  }
  





}
