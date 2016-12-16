INSERT INTO `book` (`id`, `autor`, `precio`, `sinopsis`, `titulo`, `isbn`, `genero`, `paginas`, `imagen_id`) VALUES
(1, 'Autor1', '55.00', 'Los tres cerditos', 'Los tres cerditos', '', '', 0, 1),
(2, 'Autor2', '19.99', 'Caperucita roja', 'Caperucita roja 3', '', '', 0, 2),
(3, 'Autor3', '19.99', 'San Jordi', 'San Jordi', '', '', 0, 3),
(4, 'Autor4', '19.99', 'Pepa Pig', 'Pepa Pig', '', '', 0, 4),
(5, 'Autor5', '19.99', 'Cayou', 'Cayou', '', '', 0, 5),
(6, 'Prueba', '1.00', 'prueba', 'Prueba', '', '', 0, 0);

insert into Prueba values (1);
insert into Prueba values (2);
insert into Prueba values (3);
insert into Prueba values (4);
insert into Prueba values (5);

-- Extraido de la documentacion
/*You can set spring.jpa.hibernate.ddl-auto explicitly and the standard Hibernate property 
values are none, validate, update, create, create-drop. 
Spring Boot chooses a default value for you based on whether it thinks your database is embedded (default create-drop) or not (default none). 
An embedded database is detected by looking at the Connection type: hsqldb, h2 and derby are embedded, the rest are not. 
Be careful when switching from in-memory to a ‘real’ database that you don’t make assumptions about 
the existence of the tables and data in the new platform. 
You either have to set ddl-auto explicitly, or use one of the other mechanisms to initialize the database.

[Note]
You can output the schema creation by enabling the org.hibernate.SQL logger. This is done for you automatically if you enable the debug mode.
In addition, a file named import.sql in the root of the classpath will be executed on startup if Hibernate creates the schema from scratch 
(that is if the ddl-auto property is set to create or create-drop). 
This can be useful for demos and for testing if you are careful, but probably not something you want to be on the classpath in production. 
It is a Hibernate feature (nothing to do with Spring).
*/