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
var LibroAddComponent = (function () {
    function LibroAddComponent(_libroService, _route, _router) {
        this._libroService = _libroService;
        this._route = _route;
        this._router = _router;
        this.tituloPag = "Crear nuevo libro";
    }
    LibroAddComponent.prototype.onSubmit = function () {
        var _this = this;
        this.libro.precio = 1;
        this._libroService.addLibro(this.libro)
            .subscribe(function (response) {
            _this.status = response.status;
            if (_this.status !== "Created") {
                alert("Error en el servidor");
            }
            _this._router.navigate(["/"]);
        }, function (error) {
            _this.errorMessage = error;
            if (error.status === 401) {
                alert("Accedo no autorizado");
            }
            if (_this.errorMessage !== null) {
                console.log(_this.errorMessage);
                alert("Error en la petición");
            }
        });
    };
    LibroAddComponent.prototype.ngOnInit = function () {
        this.libro = new libro_1.Libro(0, "", "", "", 0, 0, "", "", 0, null);
    };
    LibroAddComponent.prototype.returnGenero = function (value) {
        //	this.libro.precio = value;
        this.libro.precio = 10;
    };
    LibroAddComponent.prototype.addImageToBook = function (event) {
        this.libro.idImagen = event.idImagen;
        document.getElementById("saveBookBtn").disabled = false;
    };
    return LibroAddComponent;
}());
LibroAddComponent = __decorate([
    core_1.Component({
        selector: "libro-add",
        templateUrl: "app/view/libro-add.html",
        providers: [libro_service_1.LibroService]
    }),
    __metadata("design:paramtypes", [libro_service_1.LibroService,
        router_1.ActivatedRoute,
        router_1.Router])
], LibroAddComponent);
exports.LibroAddComponent = LibroAddComponent;
//# sourceMappingURL=libro-add.component.js.map