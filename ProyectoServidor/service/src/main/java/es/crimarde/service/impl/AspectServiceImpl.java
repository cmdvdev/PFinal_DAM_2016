package es.crimarde.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.crimarde.dao.RegistroRepository;
import es.crimarde.model.Registro;
import es.crimarde.service.AspectService;

@Service
@Transactional
public class AspectServiceImpl implements AspectService {

	@Autowired private RegistroRepository repositorio;
	
	@Override
	public void add(Registro registro) {
		repositorio.save(registro);
	}

}
