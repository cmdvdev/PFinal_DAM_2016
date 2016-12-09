"use strict";
var Libro = (function () {
    function Libro(id, titulo, autor, sinopsis, precio, idImagen, base64) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.precio = precio;
        this.idImagen = idImagen;
        this.base64 = base64;
    }
    return Libro;
}());
exports.Libro = Libro;
//# sourceMappingURL=libro.js.map