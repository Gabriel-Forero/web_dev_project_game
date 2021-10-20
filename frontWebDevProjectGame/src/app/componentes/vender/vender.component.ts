import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { AuthService } from 'src/app/servicios/auth.service';
import { GameServiceService } from 'src/app/servicios/game-service.service';
import { TripulacionService } from 'src/app/servicios/tripulacion.service';

@Component({
  selector: 'app-vender',
  templateUrl: './vender.component.html',
  styleUrls: ['./vender.component.css']
})
export class VenderComponent implements OnInit {

  create: FormGroup;
  submitte: boolean = false;
  loading:boolean = false;
  items:any [] = [];
  itemsP:any [] = [];
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
    this.obtenerAssetPlaneta();
    
  }

  getTeam(id:string)
  { 
    
    this.serviceT.getTeam(id).subscribe(data =>{
      console.log(data);
      this.team = data;
      this.teamId = data.teamId;
      this.teamMoney = data.teamCurrentMoney;
      this.obtenerAsset();
    });
  }

  obtenerAsset()
  {
    console.log('Team id ' +this.teamId);
    this.service.getRecursosDelTeam(this.teamId).subscribe(data =>{
      this.items = [];
      data.forEach((element:any) => {
        this.items.push({
          ...element
        });
      });
    });
  }

  obtenerAssetPlaneta()
  {
    this.service.getRecursosPlanetas(this.data.planetId).subscribe(data =>{
      this.itemsP = [];
      data.forEach((element:any) => {
        this.itemsP.push({
          ...element
        });
      });
    });
  }

  vender()
  {
    let pv:number = 2;
    let inventario:number = 0;
    let data:any = {};

    for(let i=0; i<this.items.length; i++)
    {
      
      console.log(this.items[i]);
      if(this.create.value.asset == this.items[i].asset.assetName)
      {
        this.priceId = this.items[i].assetsByTeamId;
        this.assetId = this.items[i].asset.assetId;
        inventario = this.items[i].assetAmount;
      }
    }

    for(let i=0; i<this.itemsP.length; i++)
    {
      
      console.log(this.itemsP[i]);
      if(this.create.value.asset == this.itemsP[i].asset.assetName)
      {
        pv = this.itemsP[i].pv;
      }
    
    }

    console.log(inventario);

    if(this.create.value.amount > inventario)
    {
      this.toastr.error('La cantidad excede el inventario!', 'Venta NO Exitosa!', {
        positionClass: 'toast-bottom-right'
      });
    }
    else
    {
      data = {
        priceId: this.priceId,
        amount: this.create.value.amount,
        assetId: this.assetId,
        planetId:this.data.planetId,
        teamId:this.teamId,
        totalPC: pv*this.create.value.amount
      } 
      this.service.postVender(data).subscribe(
        ()=>{
          this.toastr.success('Venta realizada con exito!', 'Venta Exitosa!', {
            positionClass: 'toast-bottom-right'
          });
        
        }
      );
    }

  }
}
