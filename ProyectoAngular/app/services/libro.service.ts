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

	getLibro(id: string, random = null){
		if(random == null){
			console.log('Peticon de libro por getLibro');
			return this._http.get("http://cmdvdev.com:8090/retrieve/"+id)
							.map(res => res.json());

		}else{
			return this._http.get("http://cmdvdev.com:8090/random")
							.map(res => res.json());
		}

	}

	addLibro(libro: Libro) {
		let json = JSON.stringify(libro);
		let params = "json="+json;
		let headers = new Headers({'Content-Type':'application/x-www-form-urlencoded'});

		return this._http.post("http://cmdvdev.com:8090/add",
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
