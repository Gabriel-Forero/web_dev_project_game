import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TripulacionService {

  constructor(private http: HttpClient) { }

  getQuery(query: string) {
    const url = `http://localhost:8081/${query}`;

    const headers = new HttpHeaders(
      {
        'Authorization': 'Token 1083a3555036905d46d8f851e23fe0a9d0c36087'
      }
    );

    return this.http.get(url, { headers });
  }

  getTeam(id:string):Observable<any>
  {
    return this.getQuery(`user/findTeamByUserDocument/${id}`);
  }

  getUser(id:string):Observable<any>
  {
    return this.getQuery(`team/findUsersByTeam/${id}`);
  }

  getAsset(id:string):Observable<any>
  {
    return this.getQuery(`assetsByTeamController/findAllByTeamId/${id}`);
  }
}
