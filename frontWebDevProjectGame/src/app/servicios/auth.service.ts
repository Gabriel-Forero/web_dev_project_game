import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authUser:boolean = false;
  user:any = '';
  admin:boolean= false;
  role:any = '';
  constructor(private http: HttpClient, private userService: UserService) { 
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
    this.user = user;
    console.log(this.user);
    this.userService.getByUserDoc(this.user.userDocument).pipe().subscribe(data =>{
      this.role = data.userRole;
      this.admin = data.userAdmin;
    });
    return this.http.post(url, user,{headers});
  }

  estaAuth(): boolean
   {
     return this.authUser;
   }

   getUserDoc():any{
     console.log(this.user);
     return this.user.userDocument;
   }

   getUserRole():any
   { 
     return this.role;
     
   }

   logOut(): any
   {
     return this.authUser;
   }

   getUserAdmin():any
   {
    this.authUser = false;
   }

}
