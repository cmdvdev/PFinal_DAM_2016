package es.crimarde.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prueba {

	@Id
	private Integer id;

	public Prueba() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}