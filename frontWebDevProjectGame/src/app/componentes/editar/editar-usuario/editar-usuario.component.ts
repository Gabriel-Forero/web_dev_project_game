import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/servicios/user.service';
import { ToastrService } from 'ngx-toastr';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TeamService } from 'src/app/servicios/team.service';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.css']
})
export class EditarUsuarioComponent implements OnInit {

  create: FormGroup;
  submitte: boolean = false;
  loading:boolean = false;
  items:any [] = [];
  constructor(
    private fb: FormBuilder,
    private service: UserService,
    private router:Router,
    private serviceTeam: TeamService,
    private toastr: ToastrService,
    @Inject(MAT_DIALOG_DATA) public data: { id: string }
  ) { 

    this.create = this.fb.group({
    
      userName: ['', Validators.required],
      userDocument: ['', Validators.required],
      userPassword: ['', Validators.required],
      userRole: ['', Validators.required],
        
    });

    this.initData();
  }

  ngOnInit(): void {
    this.obtenerTeams();
  }

  editar()
  {
    this.submitte = true;

    if(this.create.invalid)
    {
      return;
    }

    this.loading = true;
    let admin:boolean = false;
    if(this.create.value.userRole == 'Administrador')
    {
      admin = true;
    }
    let entidad: any = 
     {
      userId:this.data.id,
      userName: this.create.value.userName,
      userDocument:this.create.value.userDocument,
      userPassword: this.create.value.userPassword,
      userRole: this.create.value.userRole,
      userAdmin: admin,
    }
    console.log(typeof(entidad.userId))
    this.service.update(this.data.id,entidad).subscribe(()=>
    {
      this.toastr.success('Usuario editado con exito!', 'Usuario editado!', {
        positionClass: 'toast-bottom-right'
      });
      this.loading = false;
      
    },
    error => {
      console.log(error);
    }
    );    
   
  }

  obtenerTeams()
  {
    this.serviceTeam.getAll().subscribe(data =>{
      this.items = [];
      data.forEach((element:any) => {
        this.items.push({
          ...element
        });
      });
    });
  }

  initData()
  {
    this.loading = true;
    this.service.get(this.data.id).subscribe(data => {
  
      this.create.setValue({
        userName: data.userName,
        userDocument:data.userDocument,
        userPassword: data.userPassword,
        userRole: data.userRole,
      });
  });
  
  this.loading = false;
  }

}
