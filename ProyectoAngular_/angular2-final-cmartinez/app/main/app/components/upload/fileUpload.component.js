"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var FileUploadComponent = (function () {
    function FileUploadComponent(_http, el) {
        this._http = _http;
        this.el = el;
        this.PasameElIdImagen = new core_1.EventEmitter();
    }
    /**
     * Solo se permiten archivos de imagen menores de 1mb
     */
    FileUploadComponent.prototype.upload = function (fileInput) {
        var _this = this;
        var allowed = false;
        var ext = fileInput.target.files[0].name.match(/\.([^\.]+)$/)[1];
        var filesize = ((fileInput.target.files[0].size / 1024) / 1024); // MB
        switch (ext) {
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
        if (allowed && filesize <= 1) {
            //Bloquear el boton de subida
            document.getElementById("saveBookBtn").disabled = true;
            this.filesToUpload = fileInput.target.files;
            this.makeFileRequest("http://cmdvdev.com:8090/singleUpload", [], this.filesToUpload)
                .then(function (result) {
                _this.resultUpload = result;
                _this.PasameElIdImagen.emit({ idImagen: result });
                //this.libro.imagen = this.resultUpload.filename;
            }, function (error) {
                console.log(error);
            });
        }
    };
    FileUploadComponent.prototype.makeFileRequest = function (url, params, files) {
        return new Promise(function (resolve, reject) {
            var formData = new FormData();
            var xhr = new XMLHttpRequest();
            for (var i = 0; i < files.length; i++) {
                formData.append("file", files[i], files[i].name);
            }
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        resolve(JSON.parse(xhr.response));
                    }
                    else {
                        reject(xhr.response);
                    }
                }
            };
            xhr.open("POST", url, true);
            xhr.send(formData);
        });
    };
    return FileUploadComponent;
}());
__decorate([
    core_1.Output(),
    __metadata("design:type", Object)
], FileUploadComponent.prototype, "PasameElIdImagen", void 0);
FileUploadComponent = __decorate([
    core_1.Component({
        selector: "file-upload",
        template: '<input id="fileToUpload" type="file" accept="image/*" placeholder="Subir imagen..." >'
    }),
    __metadata("design:paramtypes", [http_1.Http,
        core_1.ElementRef])
], FileUploadComponent);
exports.FileUploadComponent = FileUploadComponent;
//# sourceMappingURL=fileUpload.component.js.map