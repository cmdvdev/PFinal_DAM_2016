"use strict";
var Libro = (function () {
    function Libro(id, titulo, autor, sinopsis, precio, idImagen, isbn, genero, paginas, imagen) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.precio = precio;
        this.idImagen = idImagen;
        this.isbn = isbn;
        this.genero = genero;
        this.paginas = paginas;
        this.imagen = imagen;
    }
    return Libro;
}());
exports.Libro = Libro;
//# sourceMappingURL=libro.js.map