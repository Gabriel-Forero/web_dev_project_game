import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrudComponent } from './componentes/crud/crud.component';
import { HomeComponent } from './componentes/home/home.component';
import { JuegoComponent } from './componentes/juego/juego.component';
import { LogInComponent } from './componentes/log-in/log-in.component';
import { EstrellasComponent } from './componentes/pages/estrellas/estrellas.component';
import { NavesComponent } from './componentes/pages/naves/naves.component';
import { PlanetasComponent } from './componentes/pages/planetas/planetas.component';
import { RecursosComponent } from './componentes/pages/recursos/recursos.component';
import { TeamsComponent } from './componentes/pages/teams/teams.component';
import { UsuariosComponent } from './componentes/pages/usuarios/usuarios.component';
import { TripulacionComponent } from './componentes/tripulacion/tripulacion.component';
import { AuthGuard } from './guards/auth.guard';
import { CaptainGuard } from './guards/captain.guard';
import { OtherGuard } from './guards/other.guard';
import { AdminGuard } from './guards/admin.guard';

const routes: Routes = [
  {path: 'home', component: HomeComponent, canActivate: [ AuthGuard && CaptainGuard]},
  {path: 'login', component: LogInComponent},
  {path: 'crud', component: CrudComponent,canActivate: [ AuthGuard && AdminGuard]},
  {path: 'crud/usuario', component: UsuariosComponent,canActivate: [ AuthGuard]},
  {path: 'crud/equipo', component: TeamsComponent,canActivate: [ AuthGuard]},
  {path: 'crud/recursos', component: RecursosComponent,canActivate: [ AuthGuard]},
  {path: 'crud/estrellas', component: EstrellasComponent,canActivate: [ AuthGuard]},
  {path: 'crud/planetas', component: PlanetasComponent,canActivate: [ AuthGuard]},
  {path: 'crud/nave', component: NavesComponent,canActivate: [ AuthGuard]},
  {path: 'juego', component: JuegoComponent,canActivate: [ AuthGuard]},
  {path: 'tripulacion', component: TripulacionComponent,canActivate: [ AuthGuard && (CaptainGuard || AdminGuard) ]},
  {path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: '**', pathMatch: 'full', redirectTo: 'login'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
