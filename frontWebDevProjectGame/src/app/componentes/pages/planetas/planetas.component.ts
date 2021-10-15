import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { PlanetService } from 'src/app/servicios/planet.service';
import { AgregarPlanetaComponent } from '../../agregar/agregar-planeta/agregar-planeta.component';
import { EditarPlanetaComponent } from '../../editar/editar-planeta/editar-planeta.component';

@Component({
  selector: 'app-planetas',
  templateUrl: './planetas.component.html',
  styleUrls: ['./planetas.component.css']
})
export class PlanetasComponent implements OnInit {

  items:any[] = [];
  constructor(private service: PlanetService,private dialog: MatDialog) { }

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
    let dialogRef = this.dialog.open(EditarPlanetaComponent, {
      data: { id: idP },
    });
  }

  eliminar(id:string)
  {}

  agregar()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "60%";
    this.dialog.open(AgregarPlanetaComponent,dialogConfig);
  }
}
