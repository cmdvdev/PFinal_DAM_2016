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
    //public filesToUpload: Array<File>;
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
        this.libro = new libro_1.Libro(0, "", "", "", 0, 0, "", "", 0, null);
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
    LibroEditComponent.prototype.addImageToBook = function (event) {
        this.libro.idImagen = event.idImagen;
        document.getElementById("saveBookBtn").disabled = false;
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