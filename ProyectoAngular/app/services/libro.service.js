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
    LibroService.prototype.getLibros = function () {
        return this._http.get("http://cmdvdev.com:8090/lista")
            .map(function (res) { return res.json(); });
    };
    LibroService.prototype.getLibro = function (id, random) {
        if (random === void 0) { random = null; }
        if (random == null) {
            console.log('Peticon de libro por getLibro');
            return this._http.get("http://cmdvdev.com:8090/retrieve/" + id)
                .map(function (res) { return res.json(); });
        }
        else {
            return this._http.get("http://cmdvdev.com:8090/random")
                .map(function (res) { return res.json(); });
        }
    };
    LibroService.prototype.addLibro = function (libro) {
        var json = JSON.stringify(libro);
        var params = "json=" + json;
        var headers = new http_1.Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
        return this._http.post("http://cmdvdev.com:8090/add", params, { headers: headers }).map(function (res) { return res.json(); });
    };
    LibroService.prototype.editLibro = function (id, libro) {
        var json = JSON.stringify(libro);
        var params = "json=" + json;
        var headers = new http_1.Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
        return this._http.post("http://cmdvdev.com:8090/update/" + id, params, { headers: headers }).map(function (res) { return res.json(); });
    };
    LibroService.prototype.deleteLibro = function (id) {
        return this._http.get("http://cmdvdev.com:8090/delete/" + id)
            .map(function (res) { return res.json(); });
    };
    LibroService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], LibroService);
    return LibroService;
}());
exports.LibroService = LibroService;
//# sourceMappingURL=libro.service.js.map