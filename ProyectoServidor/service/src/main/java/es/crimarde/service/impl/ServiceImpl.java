package es.crimarde.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.crimarde.dao.EmployeeRepository;
import es.crimarde.model.Book;
import es.crimarde.model.Employee;
import es.crimarde.model.Prueba;


@Service
@Transactional
public class ServiceImpl implements es.crimarde.service.Service {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public String retrieve() {
		Book emp = repository.findOne(1);
		return emp.getName();
	}
	
	public void add(Book b){
		repository.save(b);
	}


}