import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule, JsonpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent }  from './app.component';
import { routing, appRoutingProviders } from './app.routing';

import {LibrosListComponent} from "./components/libros-list.component";
import {LibrosDetailComponent} from "./components/libros-detail.component";
import {LibroAddComponent} from "./components/libro-add.component";
import {LibroEditComponent} from "./components/libro-edit.component";

@NgModule({
  imports:      [ BrowserModule, HttpModule, FormsModule, routing ],
  declarations: [
  				  AppComponent,
  				  LibrosListComponent,
  				  LibrosDetailComponent,
  				  LibroEditComponent,
  				  LibroAddComponent
  				],
  providers:    [ appRoutingProviders ],
  bootstrap:    [ AppComponent ]
})

export class AppModule { }
