import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

import {LibroService} from "../../services/libro.service";
import {Libro} from "../../model/libro";

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
	public filesToUpload: Array<File>;

	constructor(
		private _libroService: LibroService,
		private _route: ActivatedRoute,
		private _router: Router
	){}


	onSubmit(){
		this._route.params.forEach((params: Params) => {

			 let id = params["id"];

			 this._libroService.editLibro(id, this.libro)
			 .subscribe(
					response => {
						this.status = response.status;
						if(this.status !== "OK"){
							alert("Error en el servidor");
						}
						this.goToHome();
					},
					error => {
						this.errorMessage = <any>error;
						if(this.errorMessage !== null){
							console.log(this.errorMessage);
							alert("Error en la petición (Edicion)");
						}
						this.goToHome();
					}
				);

		 });

	}

	private goToHome(){
			// redirecciona a la pagina principal
		 	this._router.navigate(["/"]);
	}

	ngOnInit(){
		this.libro = new Libro(0,"","","",0,1,"");
		this.getLibro();
	}

	getLibro(){
		this._route.params.forEach((params: Params) => {

			let id = params["id"];
			this._libroService.getLibro(id)
			.subscribe(
				response => {
						this.libro = response.data;
						this.status = response.status;

						if(this.status !== "OK"){
							this._router.navigate(["/"]);
						}
				},
				error => {
					this.errorMessage = <any>error;

					if(this.errorMessage !== null){
						console.log(this.errorMessage);
						alert("Error en la peticion");
					}
				});
		});
	}

	returnGenero(value){
		this.libro.precio = value;
	}

	public resultUpload;

	fileChangeEvent(fileInput: any){
		this.filesToUpload = <Array<File>>fileInput.target.files;

		this.makeFileRequest("http://cmdvdev.com:8090/multiUpload", [], this.filesToUpload).then((result) => {
				this.resultUpload = result;
				//this.libro.imagen = this.resultUpload.filename;
		}, (error) =>{
			console.log(error);
		});
	}

	makeFileRequest(url: string, params: Array<string>, files: Array<File>){
		return new Promise((resolve, reject) => {
				var formData: any = new FormData();
				var xhr = new XMLHttpRequest();

				for(var i = 0; i < files.length; i++){
					formData.append("file", files[i], files[i].name);
				}

				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4){
						if(xhr.status == 200){
							resolve(JSON.parse(xhr.response));
						}else{
							reject(xhr.response);
						}
					}
				}
				xhr.open("POST", url, true);
				xhr.send(formData);
			});
	}
}
