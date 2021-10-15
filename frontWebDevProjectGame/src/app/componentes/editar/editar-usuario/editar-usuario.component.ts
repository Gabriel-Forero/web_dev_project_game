import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/servicios/user.service';
import { ToastrService } from 'ngx-toastr';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.css']
})
export class EditarUsuarioComponent implements OnInit {

  create: FormGroup;
  submitte: boolean = false;
  loading:boolean = false;
  constructor(
    private fb: FormBuilder,
    private service: UserService,
    private router:Router,
    private toastr: ToastrService,
    @Inject(MAT_DIALOG_DATA) public data: { id: string }
  ) { 

    this.create = this.fb.group({
    
      userName: ['', Validators.required],
      userDocument: ['', Validators.required],
      userPassword: ['', Validators.required],
      userRole: [''],
      teamId:[''],
    
    });

    this.initData();
  }

  ngOnInit(): void {
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
      userName: this.create.value.userName,
      userDocument:this.create.value.userDocument,
      userPassword: this.create.value.userPassword,
      userRole: this.create.value.userRole,
      userAdmin: admin,
      teamId: this.create.value.teamId
    }

    this.service.create(entidad).subscribe(()=>
    {
      this.toastr.success('Conductor registrado con exito!', 'Conductor registrado!', {
        positionClass: 'toast-bottom-right'
      });
      this.loading = false;
      
    });    
   
  }

  initData()
  {
    this.loading = true;
    this.service.get(this.data.id).subscribe(data => {
      console.log(data);
      this.create.setValue({
        userName: data.userName,
        userDocument:data.userDocument,
        userPassword: data.userPassword,
        userRole: data.userRole,
        userAdmin: data.userAdmin,
        teamId: data.teamId
      });
  });
  this.loading = false;
  }

}
