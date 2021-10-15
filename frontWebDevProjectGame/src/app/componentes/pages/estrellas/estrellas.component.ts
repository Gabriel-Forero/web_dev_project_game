import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { StarService } from 'src/app/servicios/star.service';
import { AgregarEstrellaComponent } from '../../agregar/agregar-estrella/agregar-estrella.component';
import { EditarEstrellaComponent } from '../../editar/editar-estrella/editar-estrella.component';

@Component({
  selector: 'app-estrellas',
  templateUrl: './estrellas.component.html',
  styleUrls: ['./estrellas.component.css']
})
export class EstrellasComponent implements OnInit {

  items:any[] = [];
  constructor(private starService: StarService,  private dialog: MatDialog) { }

  ngOnInit(): void {
    this.obtener();
  }

  obtener()
  {
    this.starService.getAll().subscribe(data =>{
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
    let dialogRef = this.dialog.open(EditarEstrellaComponent, {
      data: { id: idP },
    });
  }

  eliminar(id:string)
  {}

  agregar()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "60%";
    this.dialog.open(AgregarEstrellaComponent,dialogConfig);
  }

}
