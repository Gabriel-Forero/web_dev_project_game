import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-estrellas',
  templateUrl: './estrellas.component.html',
  styleUrls: ['./estrellas.component.css']
})
export class EstrellasComponent implements OnInit {

  items:any[] = [];
  constructor() { }

  ngOnInit(): void {
  }

  editar(id:string)
  {

  }

  eliminar(id:string)
  {}

  agregar()
  {
    
  }

}
