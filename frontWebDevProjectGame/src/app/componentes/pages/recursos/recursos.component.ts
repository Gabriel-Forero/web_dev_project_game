import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AgregarRecursoComponent } from '../../agregar/agregar-recurso/agregar-recurso.component';
import { EditarRecursoComponent } from '../../editar/editar-recurso/editar-recurso.component';

@Component({
  selector: 'app-recursos',
  templateUrl: './recursos.component.html',
  styleUrls: ['./recursos.component.css']
})
export class RecursosComponent implements OnInit {

 
  items:any[] = [];
  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  editar(idP:string)
  {
    let dialogRef = this.dialog.open(EditarRecursoComponent, {
      data: { id: idP },
    });
  }

  eliminar(id:string)
  {}

  agregar()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "60%";
    this.dialog.open(AgregarRecursoComponent,dialogConfig);
  }
}
