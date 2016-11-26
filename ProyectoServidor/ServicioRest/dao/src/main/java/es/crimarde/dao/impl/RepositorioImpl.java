package es.crimarde.dao.impl;

import org.springframework.stereotype.Repository;

import es.crimarde.dao.Repositorio;

@Repository
public class RepositorioImpl implements Repositorio{

	@Override
	public void save() {
	}

	@Override
	public String find() {
		return "Valor del repositorio";
	}

}
