import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { NaveService } from 'src/app/servicios/nave.service';
import { AgregarNaveComponent } from '../../agregar/agregar-nave/agregar-nave.component';
import { EditarNaveComponent } from '../../editar/editar-nave/editar-nave.component';

@Component({
  selector: 'app-naves',
  templateUrl: './naves.component.html',
  styleUrls: ['./naves.component.css']
})
export class NavesComponent implements OnInit {

  
  items:any[] = [];
  constructor(private service: NaveService,private dialog: MatDialog) { }

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
    let dialogRef = this.dialog.open(EditarNaveComponent, {
      data: { id: idP },
    });
  }

  eliminar(id:string)
  {}

  agregar()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "60%";
    this.dialog.open(AgregarNaveComponent);
  }
}
