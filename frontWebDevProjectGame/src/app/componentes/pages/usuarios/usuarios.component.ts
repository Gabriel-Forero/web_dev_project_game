import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {


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
