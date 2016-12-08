import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule, JsonpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { AppComponent }  from './app.component';
import { routing, appRoutingProviders } from './app.routing';

import {LibrosListComponent} from "./main/app/components/list/libros-list.component";
import {LibrosDetailComponent} from "./main/app/components/detail/libros-detail.component";
import {LibroAddComponent} from "./main/app/components/add/libro-add.component";
import {LibroEditComponent} from "./main/app/components/edit/libro-edit.component";
import {FileUploadComponent} from "./main/app/components/upload/fileUpload.component";
import {SearchComponent} from "./main/app/components/search/search.component";

@NgModule({
  imports:      [ BrowserModule, HttpModule, FormsModule, routing ],
  declarations: [
  				  AppComponent,
  				  LibrosListComponent,
  				  LibrosDetailComponent,
  				  LibroEditComponent,
  				  LibroAddComponent,
            FileUploadComponent,
            SearchComponent
  				],
  providers:    [ appRoutingProviders ],
  bootstrap:    [ AppComponent ]
})

export class AppModule { }
