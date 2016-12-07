package es.crimarde.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.crimarde.model.Imagen;

@Repository
public interface ImageRepository extends CrudRepository<Imagen, Long> {
	
}