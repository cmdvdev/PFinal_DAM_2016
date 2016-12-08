import { Component } from '@angular/core';

import {LibroService} from "../../services/libro.service";
import {Libro} from "../../model/libro";

@Component({
  selector: 'search-book',
  template: '<input #sb id="sb" type="text" (blur)="getLibrosByWord()" />',
  providers: [LibroService]
})
export class SearchComponent {
  public libros: Libro[];
  public errorMessage: string;
  public status: string;

  constructor(
    private _libroService: LibroService
  ){}

    getLibrosByWord(){
  		let box_libros = <HTMLElement>document.querySelector("#libros-list .loading");
  		box_libros.style.visibility = "visible";
  		let word = (<HTMLInputElement>document.querySelector('#sb')).value;

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
        }
}
