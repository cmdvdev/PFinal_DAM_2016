package es.crimarde.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.crimarde.dao.BookRepository;
import es.crimarde.dao.ImageRepository;
import es.crimarde.helpers.impl.BookTransformerHelper;
import es.crimarde.helpers.impl.ImageTransformerHelper;
import es.crimarde.model.Book;
import es.crimarde.negocio.BookDTO;
import es.crimarde.negocio.ImageDTO;
import es.crimarde.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private static final int PAGE_SIZE = 5;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired ImageRepository imageRepository;
	
	@Autowired
	private BookTransformerHelper bookTransformer;
	
	@Autowired ImageTransformerHelper imageTransformer;

	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#retrieve(java.lang.Integer)
	 */
	@Override
	public BookDTO retrieve(Long id) {
		Book book = bookRepository.findOne(id);
		return bookTransformer.entityToDto(book);
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#retrieveAll()
	 */
	@Override
	public List<BookDTO> retrieveAll(){
		
		return bookTransformer.entityToDtoIterable(bookRepository.findAll());
	}
	
	/**
	 * 
	 */
	public Page<BookDTO> retrieveAllPaged(Integer pageNumber){
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");
		Page<Book> pagedResponse = bookRepository.findAll(request);
		
		Page<BookDTO> pageResponseDTO = pagedResponse.map(bookTransformer::entityToDto);

		return pageResponseDTO;
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#add(es.crimarde.negocio.BookDTO)
	 */
	@Override
	public void add(BookDTO bookDTO){
		if(null != bookDTO){
			try{
				Book b = bookRepository.save(bookTransformer.dtoToEntity(bookDTO));
				ImageDTO imageDTO = bookDTO.getImagen();
				//imageDTO.setIdImagen(b.getId());
				imageRepository.save(imageTransformer.dtoToEntity(imageDTO));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#updateByProperties(es.crimarde.negocio.BookDTO)
	 */
	@Override
	public void updateByProperties(BookDTO bookDTO){
		if(null != null){
			bookRepository.updateBook(bookDTO.getId(), bookDTO.getTitulo(), bookDTO.getAutor(), bookDTO.getSinopsis(), bookDTO.getPrecio());
		}
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#update(es.crimarde.negocio.BookDTO)
	 */
	@Override
	public void update(BookDTO bookDTO){
		if(null != bookDTO.getId()){
			BookDTO book = retrieve(bookDTO.getId());
			String[] ignoreProperties = {"id"};
			BeanUtils.copyProperties(bookDTO, book, ignoreProperties);
			bookRepository.save(bookTransformer.dtoToEntity(bookDTO));
		}
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id){
		if(null != id){
			bookRepository.delete(id);
		}
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#delete(es.crimarde.negocio.BookDTO)
	 */
	@Override
	public void delete(BookDTO bookDTO){
		if(null != bookDTO){
			bookRepository.delete(bookTransformer.dtoToEntity(bookDTO));
		}		
	}
	
	public boolean existsBook(BookDTO bookDTO) {
		return (null != bookRepository.existsByTitulo(bookDTO.getTitulo()) 
				&& bookRepository.existsByTitulo(bookDTO.getTitulo()) >= 1)? Boolean.TRUE : Boolean.FALSE;
	}
	
	public Long countBooks(){
		return bookRepository.count();
	}
	
	public List<BookDTO> searchBooks(String word){
		List<BookDTO> booksDTOList = new ArrayList<>();
		
		//List<Book> booksList = repository.findByTituloLikeIgnoreCase("%"+word+"%");
		//List<Book> booksList = repository.findByTituloParam(word);
		List<Book> booksList = bookRepository.findByTituloIgnoreCaseContaining(word);
		
		if(null != booksList && !booksList.isEmpty()){
			booksDTOList = bookTransformer.entityToDtoList(booksList);
		}
		
		return booksDTOList;
	}
	
	public Page<BookDTO> searchBooksPaged(Integer pageNumber, String word){
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "id");
		Page<Book> pagedResponse = bookRepository.findByTituloIgnoreCaseContaining(word, request);
		
		Page<BookDTO> pageResponseDTO = pagedResponse.map(bookTransformer::entityToDto);

		return pageResponseDTO;
	
	}

}
