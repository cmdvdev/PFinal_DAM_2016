import {Imagen} from "./imagen";

export class Libro{
	constructor(
		public id:number,
		public titulo:string,
		public autor:string,
		public sinopsis:string,
		public precio:number,
    public idImagen:number,
    public isbn:string,
    public genero:string,
    public paginas:number,
    public imagen:Imagen
	){}
}
