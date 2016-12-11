import { Component, ElementRef } from '@angular/core';
import { Http } from "@angular/http";

@Component({
    selector: "file-upload",
    template: '<input  type="file" placeholder="Subir imagen..." >'
})
export class FileUploadComponent {
    constructor(
      private _http: Http,
      private el: ElementRef
    ) {}

/*
    upload() {
      //Observables are lazy so you need to subscribe them to actually execute corresponding processing
      let inputEl = this.el.nativeElement.firstElementChild;
        if (inputEl.files.length > 0) { // a file was selected
            let file:FileList = inputEl.files[0];
            this._http
                .post('http://cmdvdev.com:8090/singleUpload', file)
                .subscribe((res) => { // <-------------
                 // handle result
               });
                // do whatever you do...
                // subscribe to observable to listen for response
        }
    }
*/
    public resultUpload;
  	public filesToUpload: Array<File>;

  	upload(fileInput: any){
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