import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import {LibroService} from "../../services/libro.service";
import {Libro} from "../../model/libro";

@Component({
	selector: "libros-list",
	templateUrl: "app/view/libros-list.html",
	providers: [LibroService]
})

export class LibrosListComponent implements OnInit {
	public tituloPag:string = "Mis cuentos favoritos";
	public libros: Libro[];
	public status: string;
	public errorMessage;
	public confirmado;
	public indice : number;


	constructor(
		private _route: ActivatedRoute,
		private _router: Router,
		private _libroService: LibroService
	){}

 	ngOnInit() {
 		this.getLibros();
		this.indice = 1;
		console.log("libros-list component cargado");
	}

	getLibros(){
		let box_libros = <HTMLElement>document.querySelector("#libros-list .loading");
		box_libros.style.visibility = "visible";

		this._libroService.getLibros(this.indice)
				.subscribe(
					result => {
							this.libros = result.data;
							this.status = result.status;

							if(this.status !== "OK"){
								alert("Error en el servidor");
							}

							box_libros.style.display = "none";
					},
					error => {
						this.errorMessage = <any>error;

						if(this.errorMessage !== null){
							console.log(this.errorMessage);
							alert("Error en la petición (al obtener la lista de libros)");
						}
					}
				);
	}

	showLibros(event):void{
      this.libros = event.libros;
  }

	getLibrosByWord(){
		let box_libros = <HTMLElement>document.querySelector("#libros-list .loading");
		box_libros.style.visibility = "visible";
		let word = (<HTMLInputElement>document.querySelector('#search')).value;

		if(word !== ''){
			this._libroService.getLibrosByWord(word)
					.subscribe(
						result => {
								this.libros = result.data;
								this.status = result.status;

								if(this.status !== "OK"){
									alert("Error en el servidor");
								}

								box_libros.style.display = "none";
						},
						error => {
							this.errorMessage = <any>error;

							if(this.errorMessage !== null){
								console.log(this.errorMessage);
								alert("Error en la petición (al obtener la lista de libros)");
							}
						}
					);
		} else{
			this.getLibros();
		}


	}

	onBorrarConfirm(id){
			this.confirmado = id;
	}

	onCancelarConfirm(id){
			this.confirmado = null;
	}

	onBorrarLibro(id){
			this._libroService.deleteLibro(id)
				.subscribe(
					result => {
							this.status = result.status;

							if(this.status !== "OK"){
								alert("Error en el servidor");
							}
							this.getLibros();
					},
					error => {
						this.errorMessage = <any>error;

						if(this.errorMessage !== null){
							console.log(this.errorMessage);
							alert("Error en la petición");
						}
					}
				);
	}

	paginadorAvanza(){
		this.indice += 1;
		this.getLibros();
	}

	paginadorRetrocede(){
		if(this.indice > 1){
			this.indice -= 1;
			this.getLibros();
		} else{
			let btnRetrocede = <HTMLElement>document.querySelector("#retrocede");
		}
	}
}
