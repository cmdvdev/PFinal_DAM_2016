package es.crimarde.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.crimarde.model.Registro;

@Repository
public interface RegistroRepository extends CrudRepository<Registro, Integer> {
	
}