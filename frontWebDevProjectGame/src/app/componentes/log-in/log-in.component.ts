import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/servicios/auth.service';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {
  
  loginForm:FormGroup;
  submitte: boolean = false;
  constructor( private router: Router, private fb: FormBuilder, private auth:AuthService) {

    this.loginForm = this.fb.group(
      {
        userDocument:['', Validators.required]
      });
   }

  ngOnInit(): void {
  }

  login()
  {
    this.submitte = true;

    if(this.loginForm.invalid)
    {
      return;
    }

    let usuario:any =
    {
      userDocument:this.loginForm.value.userDocument
    }
    
    this.auth.login(usuario).subscribe(()=>
    {
      this.router.navigate(['/juego']);
    });    

    
  }


}
