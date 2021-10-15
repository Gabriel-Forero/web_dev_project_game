import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { 
    console.log('Auth listo');
  }

  getQuery(query:string)
  {
    const url = `http://localhost:8081/${query}`;

    const headers = new HttpHeaders(
      {
        'Authorization': 'Token 1083a3555036905d46d8f851e23fe0a9d0c36087'
      }
    );

    return this.http.get(url, {headers});
  }

  postQuery(query:string, datos:any)
  {
    const url = `http://localhost:8081/${query}`;

    const headers = new HttpHeaders(
      {
        'Authorization': 'Token 1083a3555036905d46d8f851e23fe0a9d0c36087'
      }
    );
    console.log(url);
    console.log(datos);
    return this.http.post(url,datos, {headers});
  }

  putQuery(query:string, datos:any)
  {
    const url = `http://localhost:8081/${query}`;

    const headers = new HttpHeaders(
      {
        'Authorization': 'Token 1083a3555036905d46d8f851e23fe0a9d0c36087'
      }
    );
    console.log(url);
    console.log(datos);
    return this.http.put(url,datos, {headers});
  }
  
  getAll():Observable<any>
  {
    return this.getQuery('user/findAllUsers');
  }

  create(entidad:any):Observable<any>
  {
  
    return this.postQuery('user/addUser', entidad);
  }

  update(id:string,entidad:any):Observable<any>
  {
    return this.putQuery(`user/updateUser/${id}`, entidad);
  }

  get(id:string):Observable<any>
  {
    return this.getQuery(`user/findUserById/${id}`);
  }


}
