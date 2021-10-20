import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameServiceService {
  
  enJuego:boolean = false;
  estrellaActual:number = 0;
  constructor(private http: HttpClient) { }
  

  inicialJuego()
  {
    this.enJuego = true;
  }

  estrellaAleatoria()
  {
    this.estrellaActual= Math.round(Math.random() * (300 - 1) + 1);
  }

  finalizarJuego()
  {
    this.enJuego = false;
  }

  estadoJuego():boolean
  {
    return this.enJuego;
  }

  getEstrellaActual():number
  {
    return this.estrellaActual;
  }

  getQuery(query: string) {
    const url = `http://localhost:8081/${query}`;

    const headers = new HttpHeaders(
      {
        'Authorization': 'Token 1083a3555036905d46d8f851e23fe0a9d0c36087'
      }
    );

    return this.http.get(url, { headers });
  }
  
  getEstrellasCercanas(id: string): Observable<any> {
    return this.getQuery(`starConected/findNearestStarsBySatrId/${id}`);
  }

  getPlanetasEstrellaActual(id: string): Observable<any> {
    return this.getQuery(`star/getPlanetsByStar/${id}`);
  }

  getRecursosPlanetas(id: string): Observable<any> {
    return this.getQuery(`price/findallByPlanetId/${id}`);
  }

  getRecursosDelTeam(idT: string): Observable<any> {
    return this.getQuery(`assetsByTeamController/findAllByTeamId/${idT}`);
  }

  irAEstrellaSeleccionada(idT: string, idS:string): Observable<any> {
    this.estrellaActual = parseInt(idS);
    return this.getQuery(`/team/goToOtherStar/${idT}/${idS}`);
  }
  
  postComprar(data:any): Observable<any>
  {
    return this.postQuery(`sales/buying`, data);
  }

  postVender(data:any): Observable<any>
  {
    return this.postQuery(`sales/buying`, data);
  }
  
  postQuery(query: string, datos: any) {
    const url = `http://localhost:8081/${query}`;

    const headers = new HttpHeaders(
      {
        'Authorization': 'Token 1083a3555036905d46d8f851e23fe0a9d0c36087'
      }
    );
    console.log(url);
    console.log(datos);
    return this.http.post(url, datos, { headers });
  }


}
