package es.crimarde.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Registros")
public class Registro {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private int id;
	
	@NotNull(message="Valor no puede ser nulo")
	@Column(name="metodo") 		
	private String metodo;
	
	@Future
	@Column(name="fecha")
	private Timestamp fecha;
	
	public Registro() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}
