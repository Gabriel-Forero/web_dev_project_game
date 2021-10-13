import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarComponent } from './componentes/shared/navbar/navbar.component';
import { HomeComponent } from './componentes/home/home.component';
import { LogInComponent } from './componentes/log-in/log-in.component';
import { CrudComponent } from './componentes/crud/crud.component';
import { CardCrudComponent } from './componentes/card-crud/card-crud.component';
import { SidebarComponent } from './componentes/shared/sidebar/sidebar.component';
import { JuegoComponent } from './componentes/juego/juego.component';
import { TarjetaComponent } from './componentes/shared/tarjeta/tarjeta.component';
import { TripulacionComponent } from './componentes/tripulacion/tripulacion.component';
import { UserComponent } from './componentes/pages/user/user.component';
import { PlanetasComponent } from './componentes/pages/planetas/planetas.component';
import { UsuariosComponent } from './componentes/pages/usuarios/usuarios.component';
import { TeamsComponent } from './componentes/pages/teams/teams.component';
import { NavesComponent } from './componentes/pages/naves/naves.component';
import { EstrellasComponent } from './componentes/pages/estrellas/estrellas.component';
import { RecursosComponent } from './componentes/pages/recursos/recursos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LogInComponent,
    CrudComponent,
    CardCrudComponent,
    SidebarComponent,
    JuegoComponent,
    TarjetaComponent,
    TripulacionComponent,
    UserComponent,
    PlanetasComponent,
    UsuariosComponent,
    TeamsComponent,
    NavesComponent,
    EstrellasComponent,
    RecursosComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
