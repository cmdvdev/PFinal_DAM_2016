package es.crimarde.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.crimarde.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	
	@Modifying
	@Query("delete from Book where id = ?1")
    void delete(Integer entityId);

    @Modifying
    @Query("delete from Book")
    void deleteAll();
    
    @Modifying
    @Query("UPDATE Book b SET b.titulo = ?2, b.autor = ?3, sinopsis = ?4, precio = ?5 WHERE b.id = ?1")
    Integer updateBook(
    		@Param("id") Integer id, 
    		@Param("titulo") String titulo, 
    		@Param("autor") String autor,
    		@Param("sinopsis") String sinopsis,
    		@Param("precio") Double precio);  // Alternativa <Book extends Integer> S save(Book book)

	@Query("SELECT b FROM Book b where b.titulo = ?1")
    Integer existsByTitulo(String titulo);

}


/*
 * http://docs.spring.io/spring-data/jpa/docs/current/reference/html/
 * you can achieve the execution of modifying queries that actually only need parameter binding by annotating the query method with @Modifying
 * 
 * Using named queries to declare queries for entities is a valid approach and works fine for a small number of queries. 
 * As the queries themselves are tied to the Java method that executes them you actually can bind them directly using the Spring Data JPA @Query annotation rather than annotating them to the domain class. 
 * This will free the domain class from persistence specific information and co-locate the query to the repository interface.
*/