package es.crimarde.helpers.impl;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import es.crimarde.helpers.impl.BookTransformerHelper;
import es.crimarde.model.Book;
import es.crimarde.negocio.BookDTO;

public class BookTransformerHelperTest {

	@Test
	public void toDTOTest(){
		
		BookTransformerHelper transformer = new BookTransformerHelper();
		
		Book book = new Book(1L, "titulo", "autor", "sinopsis", null, 5, "isbn", "genero", 10);
		
		BookDTO dto = transformer.entityToDto(book);
		
		Assert.assertThat(dto.getId(), Matchers.is(Matchers.equalTo(book.getId())));
		Assert.assertThat(dto.getTitulo(), Matchers.is(Matchers.equalTo(book.getTitulo())));
		Assert.assertThat(dto.getAutor(), Matchers.is(Matchers.equalTo(book.getAutor())));
		Assert.assertThat(dto.getSinopsis(), Matchers.is(Matchers.equalTo(book.getSinopsis())));
		Assert.assertThat(dto.getPrecio(), Matchers.is(Matchers.equalTo(book.getPrecio())));
	}
	
	@Test
	public void toEntityTest(){
		
		BookTransformerHelper transformer = new BookTransformerHelper();
		BookDTO bookDTO = new BookDTO(1L, "titulo", "autor", "sinopsis", null, 5, "isbn", "genero", 10);
		
		Book entity = transformer.dtoToEntity(bookDTO);
		
		Assert.assertThat(entity.getId(), Matchers.is(Matchers.equalTo(bookDTO.getId())));
		Assert.assertThat(entity.getTitulo(), Matchers.is(Matchers.equalTo(bookDTO.getTitulo())));
		Assert.assertThat(entity.getAutor(), Matchers.is(Matchers.equalTo(bookDTO.getAutor())));
		Assert.assertThat(entity.getSinopsis(), Matchers.is(Matchers.equalTo(bookDTO.getSinopsis())));
		Assert.assertThat(entity.getPrecio(), Matchers.is(Matchers.equalTo(bookDTO.getPrecio())));
	}
}
