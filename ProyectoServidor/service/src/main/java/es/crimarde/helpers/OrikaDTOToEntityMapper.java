package es.crimarde.helpers;

import es.crimarde.model.Book;
import es.crimarde.model.Imagen;
import es.crimarde.negocio.BookDTO;
import es.crimarde.negocio.ImageDTO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaDTOToEntityMapper {

	private static final MapperFactory entityToDTOmapperFactory;

	static {
		entityToDTOmapperFactory = new DefaultMapperFactory.Builder().build();

		entityToDTOmapperFactory.classMap(BookDTO.class, Book.class)
			//.exclude("id")
			.fieldAToB("id", "id")
			.fieldAToB("titulo", "titulo")
			.fieldAToB("autor", "autor")
			.fieldAToB("sinopsis", "sinopsis")
			.fieldAToB("imagen", "imagen")
			.fieldAToB("precio", "precio")
			.fieldAToB("isbn", "isbn")
			.fieldAToB("genero", "genero")
			.fieldAToB("paginas", "paginas")
			.byDefault()
			.register();

		entityToDTOmapperFactory.classMap(ImageDTO.class, Imagen.class).byDefault().register();

	}

	private OrikaDTOToEntityMapper() {
	}

	public static MapperFacade getMapperFacade() {
		return entityToDTOmapperFactory.getMapperFacade();
	}

}
