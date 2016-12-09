package es.crimarde.helpers;

import es.crimarde.model.Book;
import es.crimarde.model.Imagen;
import es.crimarde.negocio.BookDTO;
import es.crimarde.negocio.ImageDTO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaMapper {

	private static final MapperFactory mapperFactory;

	static {		
		mapperFactory = new DefaultMapperFactory.Builder().build();
		
		mapperFactory.classMap(Book.class, BookDTO.class)
			.exclude("id")
			.field("titulo", "titulo")
			.field("sinopsis", "sinopsis")
			.field("autor", "autor")
			//.field("imagen", "imagen")
			.field("precio", "precio")
			.field("isbn", "isbn")
			.field("genero", "genero")
			.field("paginas", "paginas")
			.byDefault()
			.register();

		mapperFactory.classMap(BookDTO.class, Book.class)
			.exclude("id")
			.field("titulo", "titulo")
			.field("sinopsis", "sinopsis")
			.field("autor", "autor")
			.field("imagen", "imagen")
			.field("precio", "precio")
			.field("isbn", "isbn")
			.field("genero", "genero")
			.field("paginas", "paginas")
			.byDefault()
			.register();
		
		mapperFactory.classMap(Imagen.class, ImageDTO.class)
		.byDefault()
		.register();
		
		mapperFactory.classMap(ImageDTO.class, Imagen.class)
		.byDefault()
		.register();
	}

	private OrikaMapper() {
	}

	public static MapperFacade getMapperFacade() {
		return mapperFactory.getMapperFacade();
	}
}
