DROP TABLE Book IF exists;
DROP TABLE Imagenes IF exists;

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `autor` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `precio` decimal(5,2) DEFAULT NULL,
  `sinopsis` varchar(2000) COLLATE utf8_spanish_ci DEFAULT NULL,
  `titulo` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `isbn` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `genero` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `paginas` int(11) DEFAULT NULL,
  `imagen_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

CREATE TABLE IF NOT EXISTS Imagenes (
	idImagen int not null auto_increment,
	imagen blob not null, 
	nombre varchar(30),
	
	key(idImagen)
)engine=Innodb;
 
