package es.crimarde.service;

import java.util.List;

import es.crimarde.negocio.BookDTO;

public interface BookService {
	BookDTO retrieve(Long id);

	List<BookDTO> retrieveAll();

	void add(BookDTO bookDTO);

	void updateByProperties(BookDTO bookDTO);

	void update(BookDTO bookDTO);

	void delete(Long id);

	void delete(BookDTO bookDTO);
	
	boolean existsBook(BookDTO bookDTO);
	
	Long countBooks();
	
	List<BookDTO> searchBooks(String word);
}
