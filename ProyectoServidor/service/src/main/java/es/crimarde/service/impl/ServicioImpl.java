package es.crimarde.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.crimarde.dao.RepositorioTest;
import es.crimarde.service.Servicio;

@Service
public class ServicioImpl implements Servicio {

	@Autowired RepositorioTest repositorio;
	
	@Override
	public String metodoPrueba() {
		return repositorio.find();
	}

}
