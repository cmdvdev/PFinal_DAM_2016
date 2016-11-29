import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LibrosListComponent} from "./components/libros-list.component";
import {LibrosDetailComponent} from "./components/libros-detail.component";
import {LibroAddComponent} from "./components/libro-add.component";
import {LibroEditComponent} from "./components/libro-edit.component";

const appRoutes: Routes = [
	{
		path: '',
		redirectTo: '/',
		pathMatch: 'full'
	},
	{path: "", component: LibrosListComponent},
	{path: "libro/:id", component: LibrosDetailComponent},
	{path: "crear-libro", component: LibroAddComponent},
	{path: "editar-libro/:id", component: LibroEditComponent},
	{path: "que-leo-hoy/:random", component: LibrosDetailComponent},
];

export const appRoutingProviders: any[] = [];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
