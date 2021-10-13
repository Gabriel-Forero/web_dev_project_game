import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

 
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
