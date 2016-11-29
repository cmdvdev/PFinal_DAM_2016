package es.crimarde.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.crimarde.dao.EmployeeRepository;
import es.crimarde.model.Book;

@Service
@Transactional
public class ServiceImpl implements es.crimarde.service.Service {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Book retrieve(Integer id) {
		Book emp = repository.findOne(id);
		return emp;
	}
	
	public void add(Book b){
		repository.save(b);
	}


}
