import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { LibroService } from "../../services/libro.service";
import { Libro } from "../../model/libro";

@Component({
  selector: "libro-add",
  templateUrl: "app/view/libro-add.html",
  providers: [LibroService]
})

export class LibroAddComponent implements OnInit {
  public tituloPag = "Crear nuevo libro";
  public libro: Libro;
  public errorMessage: string;
  public status: string;

  //public filesToUpload: Array<File>;

  constructor(
    private _libroService: LibroService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  onSubmit() {
    this.libro.precio = 1;
    this._libroService.addLibro(this.libro)
      .subscribe(
        response => {
          this.status = response.status;
          if (this.status !== "Created") {
            alert("Error en el servidor");
          }
          this._router.navigate(["/"]);
        },
        error => {
          this.errorMessage = <any>error;
  
          if (this.errorMessage !== null) {
            console.log(this.errorMessage);
            alert("Error en la petición");
          }
        }
      );
  }

  ngOnInit() {
    this.libro = new Libro(0, "", "", "", 0, 0, "", "", 0, null);
  }

  returnGenero(value) {
    //	this.libro.precio = value;
    this.libro.precio = 10;
  }

  addImageToBook(event) {
    this.libro.idImagen = event.idImagen;
    (<HTMLInputElement>document.getElementById("saveBookBtn")).disabled = false;
  }
}
