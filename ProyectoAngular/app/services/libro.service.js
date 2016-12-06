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
require("rxjs/add/operator/map");
var LibroService = (function () {
    function LibroService(_http) {
        this._http = _http;
    }
    LibroService.prototype.createAuthorizationHeader = function () {
        var headers = new http_1.Headers();
        headers.append('X-Requested-With', 'XMLHttpRequest');
        headers.append('Authorization', 'Basic ' + btoa('admin:pass'));
        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');
        //headers.append('Content-Type', 'application/x-www-form-urlencoded');
        console.log(headers);
        return headers;
    };
    /**
     * Metodo que obtiene un listado completo de libros
     */
    LibroService.prototype.getLibros = function () {
        return this._http.get("http://cmdvdev.com:8090/lista")
            .map(function (res) { return res.json(); });
    };
    /**
     * Metodo que obtiene un libro por su id
     * o un libro aleatorio si se le pasa el parametro random
     */
    LibroService.prototype.getLibro = function (id, random) {
        if (random === void 0) { random = null; }
        if (random == null) {
            console.log('Peticion de libro por getLibro con id: ' + id);
            return this._http.get("http://cmdvdev.com:8090/book/retrieve/" + id, { headers: this.createAuthorizationHeader() }).map(function (res) { return res.json(); });
        }
        else {
            console.log('Peticion de libro aleatorio');
            return this._http.get("http://cmdvdev.com:8090/book/random", { headers: this.createAuthorizationHeader() }).map(function (res) { return res.json(); });
        }
    };
    /**
     * Añade un nuevo libro a la base de datos
     */
    LibroService.prototype.addLibro = function (libro) {
        return this._http.post("http://cmdvdev.com:8090/book/add", this.construyeJson(libro), { headers: this.createAuthorizationHeader() }).map(function (res) { return res.json(); });
    };
    /**
     * Edita un libro de la base de datos
     */
    LibroService.prototype.editLibro = function (id, libro) {
        return this._http.put("http://cmdvdev.com:8090/update/" + id, this.construyeJson(libro), { headers: this.createAuthorizationHeader() }).map(function (res) { return res.json(); });
    };
    /**
    * Elimina un libro de la base de datos
    */
    LibroService.prototype.deleteLibro = function (id) {
        return this._http.delete("http://cmdvdev.com:8090/delete/" + id, { headers: this.createAuthorizationHeader() }).map(function (res) { return res.json(); });
    };
    LibroService.prototype.construyeJson = function (libro) {
        console.log('Servicio : AddLibro');
        var json = JSON.stringify(libro);
        var params = json;
        console.log('JSON: \n :', json);
        return params;
    };
    LibroService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], LibroService);
    return LibroService;
}());
exports.LibroService = LibroService;
//# sourceMappingURL=libro.service.js.map