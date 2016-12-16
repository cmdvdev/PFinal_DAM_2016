import { Component, ElementRef, EventEmitter, Output } from '@angular/core';
import { Http } from "@angular/http";

@Component({
  selector: "file-upload",
  template: '<input id="fileToUpload" type="file" accept="image/*" placeholder="Subir imagen..." >'
})

/** 
 '<div class="custom-input-file"> <input type="file" size="1" class="input-file" /> <p class="btn btn-ver-ancho" style="with:150px">Subir archivo</p> </div>'
 */
  
export class FileUploadComponent {

  @Output() PasameElIdImagen = new EventEmitter();
  constructor(
    private _http: Http,
    private el: ElementRef
  ) { }

  public resultUpload;
  public filesToUpload: Array<File>;

  /**
   * Solo se permiten archivos de imagen menores de 1mb
   */
  upload(fileInput: any) {
    
    let allowed = false;
    let ext = fileInput.target.files[0].name.match(/\.([^\.]+)$/)[1];
    
    var filesize = ((fileInput.target.files[0].size/1024)/1024); // MB
    switch(ext)
    {
        case 'jpg':
        case 'bmp':
        case 'png':
        case 'tif':
            allowed = true;
            break;
        default:
            alert('Contenido no permitido, debe ser de tipo imagen');
            fileInput.target.files[0] = null;
    }

    if(allowed && filesize <= 1){
      //Bloquear el boton de subida
      (<HTMLInputElement> document.getElementById("saveBookBtn")).disabled = true;
      
      this.filesToUpload = <Array<File>>fileInput.target.files;
  
      this.makeFileRequest("http://cmdvdev.com:8090/singleUpload", [], this.filesToUpload)
        .then((result) => {
          this.resultUpload = result;
          this.PasameElIdImagen.emit({idImagen : result});
  
          //this.libro.imagen = this.resultUpload.filename;
        }, (error) => {
          console.log(error);
        });
      }
    }

  makeFileRequest(url: string, params: Array<string>, files: Array<File>) {
    return new Promise((resolve, reject) => {
      var formData: any = new FormData();
      var xhr = new XMLHttpRequest();

      for (var i = 0; i < files.length; i++) {
        formData.append("file", files[i], files[i].name);
      }

      xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
          if (xhr.status == 200) {
            resolve(JSON.parse(xhr.response));
          } else {
            reject(xhr.response);
          }
        }
      }
      xhr.open("POST", url, true);
      xhr.send(formData);
    });
  }
}