package es.crimarde.helpers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.crimarde.helpers.TransformerHelp;
import es.crimarde.helpers.OrikaDTOToEntityMapper;
import es.crimarde.helpers.OrikaEntityToDTOMapper;
import es.crimarde.model.Book;
import es.crimarde.negocio.BookDTO;
import ma.glasnost.orika.MapperFacade;

@Component
public class BookTransformerHelper implements TransformerHelp<Book, BookDTO> {

	public BookDTO entityToDto(Book book){
		MapperFacade mapper = OrikaEntityToDTOMapper.getMapperFacade();
		if(null != book){
			return mapper.map(book, BookDTO.class);
		} else {
			return null;
		}		
	}
	
	public Book dtoToEntity (BookDTO bookDTO){	//Por hacer
		MapperFacade mapper = OrikaDTOToEntityMapper.getMapperFacade();
		if(null != bookDTO){
			return mapper.map(bookDTO, Book.class);
		} else {
			return null;
		}
	}
	
	public List<Book> dtoToEntityList(List<BookDTO> bookDtoList){
		List<Book> bookList = new ArrayList<>();
		
		for (BookDTO bookDTO : bookDtoList) {
			bookList.add(dtoToEntity(bookDTO));
		}
		
		return bookList;
	}
	
	public List<BookDTO> entityToDtoList(List<Book> bookList){
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for (Book Book : bookList) {
			bookDTOList.add(entityToDto(Book));
		}
		
		return bookDTOList;
	}
	
	public List<BookDTO> entityToDtoIterable(Iterable<Book> bookList){
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for (Book Book : bookList) {
			bookDTOList.add(entityToDto(Book));
		}
		
		return bookDTOList;
	}

}
