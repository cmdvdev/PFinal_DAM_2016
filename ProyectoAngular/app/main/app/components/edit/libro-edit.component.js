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
var router_1 = require("@angular/router");
var libro_service_1 = require("../../services/libro.service");
var libro_1 = require("../../model/libro");
var LibroEditComponent = (function () {
    function LibroEditComponent(_libroService, _route, _router) {
        this._libroService = _libroService;
        this._route = _route;
        this._router = _router;
        this.tituloPag = "Editar libro";
    }
    LibroEditComponent.prototype.onSubmit = function () {
        var _this = this;
        this._route.params.forEach(function (params) {
            var id = params["id"];
            _this._libroService.editLibro(id, _this.libro)
                .subscribe(function (response) {
                _this.status = response.status;
                if (_this.status !== "OK") {
                    alert("Error en el servidor");
                }
                _this.goToHome();
            }, function (error) {
                _this.errorMessage = error;
                if (_this.errorMessage !== null) {
                    console.log(_this.errorMessage);
                    alert("Error en la petición (Edicion)");
                }
                _this.goToHome();
            });
        });
    };
    LibroEditComponent.prototype.goToHome = function () {
        // redirecciona a la pagina principal
        this._router.navigate(["/"]);
    };
    LibroEditComponent.prototype.ngOnInit = function () {
        this.libro = new libro_1.Libro(0, "", "", "", 0);
        this.getLibro();
    };
    LibroEditComponent.prototype.getLibro = function () {
        var _this = this;
        this._route.params.forEach(function (params) {
            var id = params["id"];
            _this._libroService.getLibro(id)
                .subscribe(function (response) {
                _this.libro = response.data;
                _this.status = response.status;
                if (_this.status !== "OK") {
                    _this._router.navigate(["/"]);
                }
            }, function (error) {
                _this.errorMessage = error;
                if (_this.errorMessage !== null) {
                    console.log(_this.errorMessage);
                    alert("Error en la peticion");
                }
            });
        });
    };
    LibroEditComponent.prototype.returnGenero = function (value) {
        this.libro.precio = value;
    };
    LibroEditComponent.prototype.fileChangeEvent = function (fileInput) {
        var _this = this;
        this.filesToUpload = fileInput.target.files;
        this.makeFileRequest("http://cmdvdev.com:8090/multiUpload", [], this.filesToUpload).then(function (result) {
            _this.resultUpload = result;
            //this.libro.imagen = this.resultUpload.filename;
        }, function (error) {
            console.log(error);
        });
    };
    LibroEditComponent.prototype.makeFileRequest = function (url, params, files) {
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
    return LibroEditComponent;
}());
LibroEditComponent = __decorate([
    core_1.Component({
        selector: "libro-edit",
        templateUrl: "app/view/libro-add.html",
        providers: [libro_service_1.LibroService]
    }),
    __metadata("design:paramtypes", [libro_service_1.LibroService,
        router_1.ActivatedRoute,
        router_1.Router])
], LibroEditComponent);
exports.LibroEditComponent = LibroEditComponent;
//# sourceMappingURL=libro-edit.component.js.map