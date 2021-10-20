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

import { PlanetasComponent } from './componentes/pages/planetas/planetas.component';
import { UsuariosComponent } from './componentes/pages/usuarios/usuarios.component';
import { TeamsComponent } from './componentes/pages/teams/teams.component';
import { NavesComponent } from './componentes/pages/naves/naves.component';
import { EstrellasComponent } from './componentes/pages/estrellas/estrellas.component';
import { RecursosComponent } from './componentes/pages/recursos/recursos.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AgregarUsuarioComponent } from './componentes/agregar/agregar-usuario/agregar-usuario.component';
import { AgregarNaveComponent } from './componentes/agregar/agregar-nave/agregar-nave.component';
import { AgregarEquipoComponent } from './componentes/agregar/agregar-equipo/agregar-equipo.component';
import { AgregarPlanetaComponent } from './componentes/agregar/agregar-planeta/agregar-planeta.component';
import { AgregarEstrellaComponent } from './componentes/agregar/agregar-estrella/agregar-estrella.component';
import { AgregarRecursoComponent } from './componentes/agregar/agregar-recurso/agregar-recurso.component';
import { EditarUsuarioComponent } from './componentes/editar/editar-usuario/editar-usuario.component';
import { EditarEquipoComponent } from './componentes/editar/editar-equipo/editar-equipo.component';
import { EditarPlanetaComponent } from './componentes/editar/editar-planeta/editar-planeta.component';
import { EditarEstrellaComponent } from './componentes/editar/editar-estrella/editar-estrella.component';
import { EditarRecursoComponent } from './componentes/editar/editar-recurso/editar-recurso.component';
import { EditarNaveComponent } from './componentes/editar/editar-nave/editar-nave.component';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { VenderComponent } from './componentes/vender/vender.component';
import { ComprarComponent } from './componentes/comprar/comprar.component';



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
    PlanetasComponent,
    UsuariosComponent,
    TeamsComponent,
    NavesComponent,
    EstrellasComponent,
    RecursosComponent,
    AgregarUsuarioComponent,
    AgregarNaveComponent,
    AgregarEquipoComponent,
    AgregarPlanetaComponent,
    AgregarEstrellaComponent,
    AgregarRecursoComponent,
    EditarUsuarioComponent,
    EditarEquipoComponent,
    EditarPlanetaComponent,
    EditarEstrellaComponent,
    EditarRecursoComponent,
    EditarNaveComponent,
    VenderComponent,
    ComprarComponent,
    
    
  ],
  entryComponents: [
    AgregarUsuarioComponent,
    AgregarNaveComponent,
    AgregarEquipoComponent,
    AgregarPlanetaComponent,
    AgregarEstrellaComponent,
    AgregarRecursoComponent,
    EditarUsuarioComponent,
    EditarEquipoComponent,
    EditarPlanetaComponent,
    EditarEstrellaComponent,
    EditarRecursoComponent,
    EditarNaveComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
