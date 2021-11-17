import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../servicios/auth.service';

@Injectable({
  providedIn: 'root'
})
export class CaptainGuard implements CanActivate {
  constructor(private auth: AuthService, private router: Router)
  {

  }
  canActivate(): boolean  {
    if( this.auth.getUserRole() == 'CAPTAIN')
    {
      return true;
    }else
    {
      return false;
    }
  }
  
}
