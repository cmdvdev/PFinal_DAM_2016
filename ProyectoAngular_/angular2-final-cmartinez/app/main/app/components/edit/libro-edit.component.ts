import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { LibroService } from "../../services/libro.service";
import { Libro } from "../../model/libro";

@Component({
  selector: "libro-edit",
  templateUrl: "app/view/libro-add.html",
  providers: [LibroService]
})

export class LibroEditComponent implements OnInit {
  public tituloPag = "Editar libro";
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
    this._route.params.forEach((params: Params) => {

      let id = params["id"];

      this._libroService.editLibro(id, this.libro)
        .subscribe(
        response => {
          this.status = response.status;
          if (this.status !== "OK") {
            alert("Error en el servidor");
          }
          this.goToHome();
        },
        error => {
          this.errorMessage = <any>error;
          if (error.status === 401){
            alert("Accedo no autorizado");
          }
          
          if (error.status === 401){
            alert("Accedo no autorizado");
          }
          
          if (this.errorMessage !== null) {
            console.log(this.errorMessage);
            alert("Error en la petici�n (Edicion)");
          }
          this.goToHome();
        }
        );

    });

  }

  private goToHome() {
    // redirecciona a la pagina principal
    this._router.navigate(["/"]);
  }

  ngOnInit() {
    this.libro = new Libro(0, "", "", "", 0, 0, "", "", 0, null);
    this.getLibro();
  }

  getLibro() {
    this._route.params.forEach((params: Params) => {

      let id = params["id"];
      this._libroService.getLibro(id)
        .subscribe(
        response => {
          this.libro = response.data;
          this.status = response.status;

          if (this.status !== "OK") {
            this._router.navigate(["/"]);
          }
        },
        error => {
          this.errorMessage = <any>error;

          if (error.status === 401){
            alert("Accedo no autorizado");
          }
          
          if (this.errorMessage !== null) {
            console.log(this.errorMessage);
            alert("Error en la peticion");
          }
          
        });
    });
  }

  returnGenero(value) {
    this.libro.precio = value;
  }

  addImageToBook(event) {
    this.libro.idImagen = event.idImagen;
    (<HTMLInputElement>document.getElementById("saveBookBtn")).disabled = false;
  }
  
}
