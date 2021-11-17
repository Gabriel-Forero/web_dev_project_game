import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../servicios/auth.service';

@Injectable({
  providedIn: 'root'
})
export class OtherGuard implements CanActivate {
  constructor(private auth: AuthService)
  {

  }
  canActivate(): boolean  {
    if( this.auth.getUserRole() == 'MERCHANT' || this.auth.getUserRole() == 'PILOT')
    {
      return true;
    }else
    {
      return false;
    }
  }
  
}
