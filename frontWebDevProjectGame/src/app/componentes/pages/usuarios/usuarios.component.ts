import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/servicios/user.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AgregarUsuarioComponent } from '../../agregar/agregar-usuario/agregar-usuario.component';
import { EditarUsuarioComponent } from '../../editar/editar-usuario/editar-usuario.component';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {
  items:any[] = [];
  constructor(private service: UserService,  private toastr: ToastrService,
    private dialog: MatDialog) { }

  ngOnInit(): void {
    this.obtener();
  }

  obtener()
  {
    this.service.getAll().subscribe(data =>{
      this.items = [];
      data.forEach((element:any) => {
        this.items.push({
          id:element.userId,
          ...element
        });
      });
    });
  }

  editar(idP:string)
  {
    let dialogRef = this.dialog.open(EditarUsuarioComponent, {
      data: { id: idP },
    });
  }

  eliminar(idP:string, index:number)
  {
    this.service.delete(idP).subscribe(()=>
    {
      this.toastr.error('Usuario eliminado con exito!', 'Usuario eliminado!', {
        positionClass: 'toast-bottom-right'
      });
    
      this.items.splice(index, 1);
   
      
    },
    error => {
      console.log(error);
    }
    );
  }

  agregar()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "60%";
    this.dialog.open(AgregarUsuarioComponent,dialogConfig);
  }

}
