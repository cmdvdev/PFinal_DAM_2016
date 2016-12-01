package es.crimarde.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.crimarde.model.Book;

@Repository
public interface EmployeeRepository extends CrudRepository<Book, Integer> {
}