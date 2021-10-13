import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.css']
})
export class JuegoComponent implements OnInit {
  
  juego:boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  iniciarJuego()
  {
    
    this.juego =true;
  }

  finalizarJuego()
  {
    this.juego = false;
  }

}
