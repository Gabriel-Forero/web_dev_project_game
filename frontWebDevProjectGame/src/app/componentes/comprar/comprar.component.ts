import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/servicios/auth.service';
import { GameServiceService } from 'src/app/servicios/game-service.service';
import { TripulacionService } from 'src/app/servicios/tripulacion.service';

@Component({
  selector: 'app-comprar',
  templateUrl: './comprar.component.html',
  styleUrls: ['./comprar.component.css']
})
export class ComprarComponent implements OnInit {
  
  create: FormGroup;
  submitte: boolean = false;
  loading:boolean = false;
  items:any [] = [];
  teamId:string = '0';
  teamMoney:number = 0;
  team:any = {};
  priceId:any;
  assetId:any;
  docUser:any = '';
  constructor(
    private fb: FormBuilder,
    private toastr: ToastrService,
    private service:GameServiceService,
    private serviceT:TripulacionService,
    private authService:AuthService,
    @Inject(MAT_DIALOG_DATA) public data: { planetId: string }
    ) { 

      this.create = this.fb.group({
        asset: ['', Validators.required],
        amount: ['', Validators.required]
      });
    }

  ngOnInit(): void {
    this.docUser = this.authService.getUserDoc();
    this.getTeam(this.docUser);
    this.obtenerAsset();
  }

  
  getTeam(id:string)
  { 
    console.log(id);
    this.serviceT.getTeam(id).subscribe(data =>{
      console.log(data);
      this.team = data;
      this.teamId = data.teamId;
      this.teamMoney = data.teamCurrentMoney;

    });
  }

  obtenerAsset()
  {
    this.service.getRecursosPlanetas(this.data.planetId).subscribe(data =>{
      this.items = [];
      data.forEach((element:any) => {
        this.items.push({
          ...element
        });
      });
    });
  }

  comprar()
  {
    let pc:number = 0;
    let inventario:number = 0;
    let data:any = {};
    for(let i=0; i<this.items.length; i++)
    {
      
      console.log(this.create.value.asset);
      if(this.create.value.asset == this.items[i].asset.assetName)
      {
        console.log(this.items[i]);
        this.priceId = this.items[i].priceId;
        this.assetId = this.items[i].asset.assetId;
        pc = this.items[i].pc;
        inventario = this.items[i].assetAmount;
      }
    }
    console.log(inventario);
    if(this.create.value.amount > inventario)
    {
      console.log('Error no hay inventario');
    }

    if(this.teamMoney < this.create.value.amount*pc)
    {
      console.log('Error no hay suficiente dinero');
    }
    
    console.log('Price ID:' + this.priceId);
    console.log('cantidad:' +this.create.value.amount);  
    console.log('asset ID:' + this.assetId);
    console.log('planet ID:' +this.data.planetId);
    console.log('team ID:' +this.teamId);
    console.log('valor ID:' +pc*this.create.value.amount);  

    data = {
      priceId: this.priceId,
      amount: this.create.value.amount,
      assetId: this.assetId,
      planetId:this.data.planetId,
      teamId:this.teamId,
      totalPC: pc*this.create.value.amount
    }

    this.service.postComprar(data).subscribe(
      ()=>{
        this.toastr.success('Compra realizada con exito!', 'Compra Exitosa!', {
          positionClass: 'toast-bottom-right'
        });
      
      }
    );
     
  
  }

}
