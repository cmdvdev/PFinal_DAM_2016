import {Injectable} from "@angular/core";
import {Http, Response, Headers} from "@angular/http";
import "rxjs/add/operator/map";
import {Observable} from "rxjs/Observable";
import {Libro} from "../model/libro";

@Injectable()
export class LibroService{
	constructor(private _http: Http){}

	getLibros(){
		return this._http.get("http://cmdvdev.com:8090/lista")
							.map(res => res.json());
	}

  createAuthorizationHeader() {
    var headers = new Headers();
    headers.append('X-Requested-With', 'XMLHttpRequest');
    headers.append('Authorization', 'Basic ' + btoa('user:pass'));
    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');
    console.log(headers);
    return headers
  }

	getLibro(id: string, random = null){


		if(random == null){
			console.log('Peticon de libro por getLibro');
		//	return this._http.get("http://cmdvdev.com:8090/book/retrieve/"+id, {headers: headers})
		//					.map(res => res.json());

  return  this._http.get("http://cmdvdev.com:8090/book/retrieve/1",
    {headers: this.createAuthorizationHeader()}).map(res => res.json());


    console.log('Peticon de libro por getLibro');
		}else{
			return this._http.get("http://cmdvdev.com:8090/book/random")
							.map(res => res.json());
		}

	}

	addLibro(libro: Libro) {
		let json = JSON.stringify(libro);
		let params = "json="+json;
		let headers = new Headers({'Content-Type':'application/x-www-form-urlencoded'});

		return this._http.post("http://cmdvdev.com:8090/book/add",
				params, {headers: headers}).map(res => res.json());
	}

	editLibro(id: string, libro: Libro) {
		let json = JSON.stringify(libro);
		let params = "json="+json;
		let headers = new Headers({'Content-Type':'application/x-www-form-urlencoded'});

		return this._http.post("http://cmdvdev.com:8090/update/"+id,
				params, {headers: headers}).map(res => res.json());
	}

	deleteLibro(id: string){
		return this._http.get("http://cmdvdev.com:8090/delete/"+id)
							.map(res => res.json());
	}
}
