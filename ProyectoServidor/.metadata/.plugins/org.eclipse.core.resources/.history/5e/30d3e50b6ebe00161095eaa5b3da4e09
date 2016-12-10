package es.crimarde.helpers;

import org.springframework.util.Base64Utils;

import es.crimarde.model.Book;
import es.crimarde.negocio.BookDTO;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/*
 * Problemas encontrados:
 * constructorB() -> Fuerza a usar el constructor por defecto de la entidad de destino, 
 * 	si lo dejas elige él un constructor e instancia las porpiedades aunque estén excluidas
 * 
 * Declarar los conversores de un sentido y otro en archivos separados, en caso contrario 
 * Orika es capaz de inferir los constructores y mapea incluso los atributos excluidos
 */

public class OrikaEntityToDTOMapper {

	private static final MapperFactory DTOToEntitymapperFactory;

	static {
		DTOToEntitymapperFactory = new DefaultMapperFactory.Builder().build();

		DTOToEntitymapperFactory.classMap(Book.class, BookDTO.class)
			.constructorB()			
			.exclude("id")
			.exclude("imagen")
			.fieldAToB("titulo", "titulo")
			.fieldAToB("sinopsis", "sinopsis")
			.fieldAToB("autor", "autor")
			//.fieldAToB("imagen", "imagen")
			.fieldAToB("precio", "precio")
			.fieldAToB("isbn", "isbn")
			.fieldAToB("genero", "genero")
			.fieldAToB("paginas", "paginas")
			.customize(new CustomMapper<Book, BookDTO>() {
				@Override
			    public void mapAtoB(Book a, BookDTO b, MappingContext context) {
					if(null != a.getImagen()){
						System.out.println("Entro!!!!!");
						String con = Base64Utils.encodeToString(a.getImagen().getImagen());
						b.setBase64(con);
					}
				}
			})
			.byDefault()
			.register();

		//DTOToEntitymapperFactory.classMap(Imagen.class, ImageDTO.class).byDefault().register();

	}

	private OrikaEntityToDTOMapper() {
	}

	public static MapperFacade getMapperFacade() {
		return DTOToEntitymapperFactory.getMapperFacade();
	}

}
