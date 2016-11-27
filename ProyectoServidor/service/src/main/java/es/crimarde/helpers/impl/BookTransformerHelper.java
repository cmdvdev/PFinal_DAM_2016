package es.crimarde.helpers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.crimarde.helpers.BookTransformerHelp;
import es.crimarde.helpers.OrikaMapper;
import es.crimarde.model.Book;
import es.crimarde.negocio.BookDTO;
import ma.glasnost.orika.MapperFacade;



@Component
public class BookTransformerHelper implements BookTransformerHelp {

	
	public BookDTO toDTO(Book book){
		MapperFacade mapper = OrikaMapper.getMapperFacade();
		BookDTO dto = mapper.map(book, BookDTO.class);
		
		return dto;
	}
	
	
	public Book toEntity (BookDTO bookDTO){	//Por hacer
		MapperFacade mapper = OrikaMapper.getMapperFacade();
		BookDTO dto = mapper.map(book, BookDTO.class);
		
		return dto;
	}
	
	/**
	 * comentario
	 */
	public List<Book> dtoToEntityList(List<BookDTO> bookDtoList){
		List<Book> bookList = new ArrayList<>();
		
		for (BookDTO bookDTO : bookDtoList) {
			bookList.add(dtoToEntity(bookDTO));
		}
		
		return bookList;
	}
	
	public List<BookDTO> EntityToDtoList(List<Book> bookList){
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for (Book Book : bookList) {
			bookDTOList.add(entityToDto(Book));
		}
		
		return bookDTOList;
	}
	
	public Book dtoToEntity(BookDTO bookDTO){
		Book Book = null;
		if(bookDTO != null){
			Book = new Book();
			if(bookDTO.getEmail() != null){
				Book.setEmail(bookDTO.getEmail());
			}
			if(bookDTO.getFirstName() != null){
				Book.setFirstName(bookDTO.getFirstName());
			}
			Book.setId(new Long(bookDTO.getId()));
			if(bookDTO.getLastName() != null){
				Book.setLastName(bookDTO.getLastName());
			}
			if(bookDTO.getPhone() != null){
				Book.setPhone(bookDTO.getPhone());
			}
			if(bookDTO.getEmail() != null){
				Book.setEmail(bookDTO.getEmail());
			}
		}
		return Book;
	}
	
	public BookDTO entityToDto(Book Book){
		BookDTO employeeDTO = null;
		if(Book != null){
			employeeDTO = new BookDTO();
			if(Book.getEmail() != null){
				employeeDTO.setEmail(Book.getEmail());
			}
			if(Book.getFirstName() != null){
				employeeDTO.setFirstName(Book.getFirstName());
			}
			employeeDTO.setId(new Long(Book.getId()));
			if(Book.getLastName() != null){
				employeeDTO.setLastName(Book.getLastName());
			}
			if(Book.getPhone() != null){
				employeeDTO.setPhone(Book.getPhone());
			}
			if(Book.getEmail() != null){
				employeeDTO.setEmail(Book.getEmail());
			}
		}
		return employeeDTO;
	}
}