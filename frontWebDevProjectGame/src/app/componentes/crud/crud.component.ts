import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crud',
  templateUrl: './crud.component.html',
  styleUrls: ['./crud.component.css']
})
export class CrudComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  verPlaneta()
  {
    this.router.navigate(['/crud/planetas']);
  }

  verUsuarios()
  {

    this.router.navigate(['/crud/usuario']);
  }

  verEstrellas()
  {
    this.router.navigate(['/crud/estrellas']);
  }

  verNaves()
  {
    this.router.navigate(['/crud/nave']);
  }

  verRecursos()
  {
    this.router.navigate(['/crud/recursos']);
  }

  verEquipos()
  {
    this.router.navigate(['/crud/equipo']);
  }

}
