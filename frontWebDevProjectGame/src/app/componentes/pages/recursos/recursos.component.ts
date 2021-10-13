import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recursos',
  templateUrl: './recursos.component.html',
  styleUrls: ['./recursos.component.css']
})
export class RecursosComponent implements OnInit {

 
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
