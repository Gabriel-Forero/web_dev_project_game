import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authUser:boolean = false;
  constructor(private http: HttpClient) { 
    console.log('Auth listo');
  }

  login(user:any){

    const url = `http://localhost:8081/user/login`;

    const headers = new HttpHeaders(
      {
        'Authorization': 'Token 1083a3555036905d46d8f851e23fe0a9d0c36087'
      }
    );
    this.authUser = true;
    return this.http.post(url, user,{headers});
  }

  estaAuth(): boolean
   {
     return this.authUser;
   }
  
}
