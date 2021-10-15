import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/servicios/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  items:any[] = [];
  constructor(private service: UserService) { }

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

  editar(id:string)
  {

  }

  eliminar(id:string)
  {}

  agregar()
  {
    
  }

}
