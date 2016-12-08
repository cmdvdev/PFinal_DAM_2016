import { Component, ElementRef } from '@angular/core';
import { Http } from "@angular/http";

@Component({
    selector: "file-upload",
    template: '<input type="file">'
})
export class FileUploadComponent {
    constructor(
      private _http: Http,
      private el: ElementRef
    ) {}

    upload() {
      //Observables are lazy so you need to subscribe them to actually execute corresponding processing
      let inputEl = this.el.nativeElement.firstElementChild;
        if (inputEl.files.length > 0) { // a file was selected
            let file:FileList = inputEl.files[0];
            this._http
                .post('http://cmdvdev.com:8090/upload2', file)
                .subscribe((res) => { // <-------------
                 // handle result
               });
                // do whatever you do...
                // subscribe to observable to listen for response
        }



      console.log("Despues");
    }
}
