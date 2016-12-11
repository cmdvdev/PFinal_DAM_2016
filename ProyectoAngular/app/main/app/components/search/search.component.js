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
var libro_service_1 = require("../../services/libro.service");
var SearchComponent = (function () {
    function SearchComponent(_libroService) {
        this._libroService = _libroService;
        this.PasameLosLibros = new core_1.EventEmitter();
    }
    SearchComponent.prototype.getLibrosByWord = function () {
        var _this = this;
        var box_libros = document.querySelector("#libros-list .loading");
        box_libros.style.visibility = "visible";
        var word = document.querySelector('#search').value;
        if (word !== '') {
            this._libroService.getLibrosByWord(word)
                .subscribe(function (result) {
                _this.libros = result.data;
                _this.status = result.status;
                _this.PasameLosLibros.emit({ libros: _this.libros });
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
        }
        else {
            this._libroService.getLibros(1).subscribe(function (result) {
                _this.libros = result.data;
                _this.status = result.status;
                _this.PasameLosLibros.emit({ libros: _this.libros });
            });
        }
    };
    return SearchComponent;
}());
__decorate([
    core_1.Output(),
    __metadata("design:type", Object)
], SearchComponent.prototype, "PasameLosLibros", void 0);
SearchComponent = __decorate([
    core_1.Component({
        selector: 'search-book',
        templateUrl: "app/view/libros-search.html",
        providers: [libro_service_1.LibroService],
    }),
    __metadata("design:paramtypes", [libro_service_1.LibroService])
], SearchComponent);
exports.SearchComponent = SearchComponent;
//# sourceMappingURL=search.component.js.map