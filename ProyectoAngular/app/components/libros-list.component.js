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
var core_1 = require('@angular/core');
var router_1 = require('@angular/router');
var libro_service_1 = require("../services/libro.service");
var LibrosListComponent = (function () {
    function LibrosListComponent(_route, _router, _libroService) {
        this._route = _route;
        this._router = _router;
        this._libroService = _libroService;
        this.tituloPag = "Mis cuentos favoritos";
    }
    LibrosListComponent.prototype.ngOnInit = function () {
        this.getLibros();
        console.log("libros-list component cargado");
    };
    LibrosListComponent.prototype.getLibros = function () {
        var _this = this;
        var box_libros = document.querySelector("#libros-list .loading");
        box_libros.style.visibility = "visible";
        this._libroService.getLibros()
            .subscribe(function (result) {
            _this.libros = result.data;
            _this.status = result.status;
            if (_this.status !== "OK") {
                alert("Error en el servidor");
            }
            box_libros.style.display = "none";
        }, function (error) {
            _this.errorMessage = error;
            if (_this.errorMessage !== null) {
                console.log(_this.errorMessage);
                alert("Error en la petición (al obtener la lista de libros)");
            }
        });
    };
    LibrosListComponent.prototype.onBorrarConfirm = function (id) {
        this.confirmado = id;
    };
    LibrosListComponent.prototype.onCancelarConfirm = function (id) {
        this.confirmado = null;
    };
    LibrosListComponent.prototype.onBorrarLibro = function (id) {
        var _this = this;
        this._libroService.deleteLibro(id)
            .subscribe(function (result) {
            _this.status = result.status;
            if (_this.status !== "OK") {
                alert("Error en el servidor");
            }
            _this.getLibros();
        }, function (error) {
            _this.errorMessage = error;
            if (_this.errorMessage !== null) {
                console.log(_this.errorMessage);
                alert("Error en la petición");
            }
        });
    };
    LibrosListComponent = __decorate([
        core_1.Component({
            selector: "libros-list",
            templateUrl: "app/view/libros-list.html",
            providers: [libro_service_1.LibroService]
        }), 
        __metadata('design:paramtypes', [router_1.ActivatedRoute, router_1.Router, libro_service_1.LibroService])
    ], LibrosListComponent);
    return LibrosListComponent;
}());
exports.LibrosListComponent = LibrosListComponent;
//# sourceMappingURL=libros-list.component.js.map