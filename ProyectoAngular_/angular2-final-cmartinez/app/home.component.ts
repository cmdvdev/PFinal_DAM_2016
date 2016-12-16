import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: "home",
  templateUrl: "app/view/home.html"
})

export class Home {
  public titulo: string = "Mi biblioteca de cuentos";
  public isLogged: boolean;


  constructor(
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.isLogged = false;
    
  }

  
  login(username, password) {
    if (username.value == "" && password.value == "") {
      this.isLogged = true; 
    }
  }

  logout() {
    this.isLogged = false;
  }
}