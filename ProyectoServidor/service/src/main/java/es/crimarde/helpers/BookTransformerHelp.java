package es.crimarde.helpers;

import java.util.List;

import es.crimarde.model.Book;
import es.crimarde.negocio.BookDTO;

public interface BookTransformerHelp {
	public BookDTO entityToDto(Book employee);
	public Book dtoToEntity(BookDTO bookDTO);	
	public List<BookDTO> EntityToDtoList(List<Book> bookList);
	public List<Book> dtoToEntityList(List<BookDTO> bookDtoList);
}