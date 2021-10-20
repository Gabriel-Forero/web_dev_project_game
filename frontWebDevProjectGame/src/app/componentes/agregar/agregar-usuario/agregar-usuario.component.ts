import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from 'src/app/servicios/user.service';
import { ToastrService } from 'ngx-toastr';
import { TeamService } from 'src/app/servicios/team.service';

@Component({
  selector: 'app-agregar-usuario',
  templateUrl: './agregar-usuario.component.html',
  styleUrls: ['./agregar-usuario.component.css']
})
export class AgregarUsuarioComponent implements OnInit {
  
  create: FormGroup;
  submitte: boolean = false;
  loading:boolean = false;
  items:any [] = [];
  constructor(
    private fb: FormBuilder,
    private service: UserService,
    private serviceTeam: TeamService,
    private router:Router,
    private toastr: ToastrService
  ) { 

    this.create = this.fb.group({
    
      userName: ['', Validators.required],
      userDocument: ['', Validators.required],
      userPassword: ['', Validators.required],
      userRole: ['', Validators.required],
      teamId:['', Validators.required],
    
    });
  }

  ngOnInit(): void {
    this.obtenerTeams();
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

  agregar()
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
      this.items.push(entidad);
      this.loading = false;
      
    });    
   
  }

}
