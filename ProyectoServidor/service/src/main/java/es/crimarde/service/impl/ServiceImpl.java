package es.crimarde.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.crimarde.dao.BookRepository;
import es.crimarde.helpers.impl.BookTransformerHelper;
import es.crimarde.model.Book;
import es.crimarde.negocio.BookDTO;

@Service
@Transactional
public class ServiceImpl implements es.crimarde.service.Service {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private BookTransformerHelper transformer;

	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#retrieve(java.lang.Integer)
	 */
	@Override
	public BookDTO retrieve(Integer id) {
		Book book = repository.findOne(id);
		return transformer.entityToDto(book);
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#retrieveAll()
	 */
	@Override
	public List<BookDTO> retrieveAll(){
		return transformer.entityToDtoIterable(repository.findAll());
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#add(es.crimarde.negocio.BookDTO)
	 */
	@Override
	public void add(BookDTO bookDTO){
		if(null != bookDTO){
			repository.save(transformer.dtoToEntity(bookDTO));
		}
	}

	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#updateByProperties(es.crimarde.negocio.BookDTO)
	 */
	@Override
	public void updateByProperties(BookDTO bookDTO){
		if(null != null){
			repository.updateBook(bookDTO.getId(), bookDTO.getTitulo(), bookDTO.getAutor(), bookDTO.getSinopsis(), bookDTO.getPrecio());
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
			repository.save(transformer.dtoToEntity(bookDTO));
		}
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id){
		if(null != id){
			repository.delete(id);
		}
	}
	
	/* (non-Javadoc)
	 * @see es.crimarde.service.impl.adf#delete(es.crimarde.negocio.BookDTO)
	 */
	@Override
	public void delete(BookDTO bookDTO){
		if(null != bookDTO){
			repository.delete(transformer.dtoToEntity(bookDTO));
		}		
	}
	
	public boolean existsBook(BookDTO bookDTO) {
		boolean existe = Boolean.FALSE;
		if(null != repository.existsByTitulo(bookDTO.getTitulo())){
			existe = Boolean.TRUE;
		}
		return existe;
	}
	
	public Long countBooks(){
		return repository.count();
	}

}
