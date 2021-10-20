import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AuthService } from 'src/app/servicios/auth.service';
import { GameServiceService } from 'src/app/servicios/game-service.service';
import { TripulacionService } from 'src/app/servicios/tripulacion.service';
import { ComprarComponent } from '../comprar/comprar.component';
import { VenderComponent } from '../vender/vender.component';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})
export class JuegoComponent implements OnInit {
  
  planetas:any[] = [];
  estrellas:any[] = [];
  estrellaActual:number = 0;
  teamId:string = '1';
  team:any = {};

  constructor(
    private service: GameServiceService,
    private authService:AuthService, 
    private serviceT:TripulacionService,
    private dialog: MatDialog)
  { }

  ngOnInit(): void {
    this.teamId = this.authService.getUserDoc();
    this.getTeam(this.teamId);
    this.estrellaActual = this.service.getEstrellaActual();
    this.obtenerPlanetas(this.estrellaActual.toString());
    this.obtenerEstrellas(this.estrellaActual.toString());
  }
  
  juego:boolean = this.service.estadoJuego();

  getTeam(id:string)
  { 
    console.log(id);
    this.serviceT.getTeam(id).subscribe(data =>{
      console.log(data);
      this.team = data;
      this.teamId = data.teamId;

    });
  }
  iniciarJuego()
  {
    this.service.inicialJuego();
    this.juego = this.service.estadoJuego();
    this.service.estrellaAleatoria();
    this.estrellaActual = this.service.getEstrellaActual();
    this.obtenerPlanetas(this.estrellaActual.toString());
    this.obtenerEstrellas(this.estrellaActual.toString());
  }

  finalizarJuego()
  {
    this.service.finalizarJuego();
    this.juego = this.service.estadoJuego();
  }

  irAOtraEstrella(idS:string)
  {
    this.service.irAEstrellaSeleccionada(this.teamId,idS).subscribe(data =>{
      console.log('Nos fuimos a la estrella: ' + idS);
      this.estrellaActual = this.service.getEstrellaActual();
      this.obtenerPlanetas(this.estrellaActual.toString());
      this.obtenerEstrellas(this.estrellaActual.toString());
  
    });
  }

  obtenerPlanetas(idS:string)
  {
    this.service.getPlanetasEstrellaActual(idS).subscribe(data =>{
      this.planetas = [];
      data.forEach((element:any) => {
        this.planetas.push({
          id:element.planetId,
          ...element
        });
      });
    });
  }

  obtenerEstrellas(idS:string)
  {
    this.service.getEstrellasCercanas(idS).subscribe(data =>{
      this.estrellas = [];
      data.forEach((element:any) => {
        this.estrellas.push({
          id:element.userId,
          ...element
        });
      });
    });
  }

  comprar(idP:string)
  {
    let dialogRef = this.dialog.open(ComprarComponent, {
      data: { planetId:idP},
    });
  }

  vender()
  {
    let dialogRef = this.dialog.open(VenderComponent);
  }

}
