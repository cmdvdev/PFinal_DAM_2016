import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: "home",
  templateUrl: "app/view/home.html"
})

export class AppComponent {
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
      //this.eventFire(document.getElementById('initialClick'), 'click');
      //document.getElementById('initialClick').click();
      let link = (<HTMLButtonElement>document.querySelector('#initialClick')).click();
    }
  }

  logout() {
    this.isLogged = false;
  }

  eventFire(el, etype) {
    if (el.fireEvent) {
      el.fireEvent('on' + etype);
    } else {
      var evObj = document.createEvent('MouseEvents');
      evObj.initEvent(etype, true, false);
      var canceled = !el.dispatchEvent(evObj);
      if (canceled) {
        // A handler called preventDefault.
        console.log("automatic click canceled");
      } else {
        // None of the handlers called preventDefault.
      }
    }
  }

}
