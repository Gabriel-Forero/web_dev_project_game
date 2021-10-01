import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrudComponent } from './componentes/crud/crud.component';
import { HomeComponent } from './componentes/home/home.component';
import { JuegoComponent } from './componentes/juego/juego.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'crud', component: CrudComponent},
  {path: 'juego', component: JuegoComponent},
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: '**', pathMatch: 'full', redirectTo: 'home'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
