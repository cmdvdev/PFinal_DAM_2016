import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import {LibroService} from "../../services/libro.service";
import {Libro} from "../../model/libro";

@Component({
	selector: "libros-detail",
	templateUrl: "app/view/libro-detail.html",
	providers: [LibroService]
})

export class LibrosDetailComponent implements OnInit {
	public libro: Libro;
	public errorMessage: string;
	public status: string;

	constructor(
		private _libroService: LibroService,
		private _route: ActivatedRoute,
		private _router: Router
	){}

	ngOnInit(){
		this.getLibro();
	}

	getLibro(){
		this._route.params.forEach((params: Params) => {

			let id = params["id"];
			let random = params["random"];

			this._libroService.getLibro(id, random)
			.subscribe(
				response => {
						this.libro = response.data;
						this.status = response.status;

						if(this.status !== "OK"){
							// alert("Error en el servidor");
							this._router.navigate(["Home"]);
						}

				},
				error => {
					this.errorMessage = <any>error;

					if(this.errorMessage !== null){
						console.log(this.errorMessage);
						alert("Error en la petición. Directamente error. " + error.errorMessage);
					}
			});
		});
	}

}
