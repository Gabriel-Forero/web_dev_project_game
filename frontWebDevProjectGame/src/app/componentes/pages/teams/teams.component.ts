import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { TeamService } from 'src/app/servicios/team.service';
import { AgregarEquipoComponent } from '../../agregar/agregar-equipo/agregar-equipo.component';
import { EditarEquipoComponent } from '../../editar/editar-equipo/editar-equipo.component';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

 
  items:any[] = [];
  constructor(private service: TeamService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.obtener();
  }

  obtener()
  {
    this.service.getAll().subscribe(data =>{
      this.items = [];
      data.forEach((element:any) => {
        this.items.push({
          ...element
        });
      });
    });
  }

  editar(idP:string)
  {
    let dialogRef = this.dialog.open(EditarEquipoComponent, {
      data: { id: idP },
    });
  }

  eliminar(id:string)
  {}

  agregar()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "60%";
    this.dialog.open(AgregarEquipoComponent,dialogConfig);
  }
}
