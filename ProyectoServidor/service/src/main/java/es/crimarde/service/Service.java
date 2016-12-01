package es.crimarde.service;

import java.util.List;

import es.crimarde.negocio.BookDTO;

public interface Service {
	BookDTO retrieve(Integer id);

	List<BookDTO> retrieveAll();

	void add(BookDTO bookDTO);

	void updateByProperties(BookDTO bookDTO);

	void update(BookDTO bookDTO);

	void delete(Integer id);

	void delete(BookDTO bookDTO);
	
	boolean existsBook(BookDTO bookDTO);
	
	Long countBooks();
}
