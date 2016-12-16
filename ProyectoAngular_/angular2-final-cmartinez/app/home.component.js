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
var Home = (function () {
    function Home(_route, _router) {
        this._route = _route;
        this._router = _router;
        this.titulo = "Mi biblioteca de cuentos";
        this.isLogged = false;
    }
    Home.prototype.login = function (username, password) {
        if (username.value == "" && password.value == "") {
            this.isLogged = true;
        }
    };
    Home.prototype.logout = function () {
        this.isLogged = false;
    };
    return Home;
}());
Home = __decorate([
    core_1.Component({
        selector: "home",
        templateUrl: "app/view/home.html"
    }),
    __metadata("design:paramtypes", [router_1.ActivatedRoute,
        router_1.Router])
], Home);
exports.Home = Home;
//# sourceMappingURL=home.component.js.map