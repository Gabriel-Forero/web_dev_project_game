import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StarService {

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

  getAll():Observable<any>
  {
    return this.getQuery('star/findAllStars');
  }
}
