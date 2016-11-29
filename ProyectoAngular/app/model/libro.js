"use strict";
var Libro = (function () {
    function Libro(id, titulo, autor, sinopsis, imagen, precio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        this.precio = precio;
    }
    return Libro;
}());
exports.Libro = Libro;
//# sourceMappingURL=libro.js.map