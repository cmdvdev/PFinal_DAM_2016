import { Component, EventEmitter, Output } from '@angular/core';

import {LibroService} from "../../services/libro.service";
import {Libro} from "../../model/libro";

@Component({
  selector: 'search-book',
  templateUrl: "app/view/libros-search.html",
  providers: [LibroService],
})
export class SearchComponent {
  public libros: Libro[];
  public errorMessage: string;
  public status: string;

  @Output() PasameLosLibros = new EventEmitter();

  constructor(
    private _libroService: LibroService
  ){}

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

                  this.PasameLosLibros.emit({libros : this.libros});

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
  			this._libroService.getLibros(1).subscribe(
          result => {
              this.libros = result.data;
              this.status = result.status;

              this.PasameLosLibros.emit({libros : this.libros});
            });
  		}

    }

}