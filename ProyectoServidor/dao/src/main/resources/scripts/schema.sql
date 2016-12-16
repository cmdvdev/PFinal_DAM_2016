CREATE TABLE Book (
  id int(11) NOT NULL,
  autor varchar(30) DEFAULT NULL,
  precio decimal(5,2) DEFAULT NULL,
  sinopsis varchar(2000) DEFAULT NULL,
  titulo varchar(200) DEFAULT NULL,
  isbn varchar(30) DEFAULT NULL,
  genero varchar(200) DEFAULT NULL,
  paginas int(11) DEFAULT NULL,
  imagen_id int(11) DEFAULT NULL
);

create table Prueba ( id integer);