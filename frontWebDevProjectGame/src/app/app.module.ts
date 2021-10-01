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
    TarjetaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
