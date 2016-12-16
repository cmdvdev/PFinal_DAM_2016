import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {Home} from "./home.component"

import {LibrosListComponent} from "./main/app/components/list/libros-list.component";
import {LibrosDetailComponent} from "./main/app/components/detail/libros-detail.component";
import {LibroAddComponent} from "./main/app/components/add/libro-add.component";
import {LibroEditComponent} from "./main/app/components/edit/libro-edit.component";

const appRoutes: Routes = [
	{
		path: '',
		redirectTo: '/',
		pathMatch: 'full'
	},
  {path: "home", component: Home},
	{path: "", component: LibrosListComponent},
	{path: "libro/:id", component: LibrosDetailComponent},
	{path: "crear-libro", component: LibroAddComponent},
	{path: "editar-libro/:id", component: LibroEditComponent},
	{path: "que-leo-hoy/:random", component: LibrosDetailComponent},
];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
