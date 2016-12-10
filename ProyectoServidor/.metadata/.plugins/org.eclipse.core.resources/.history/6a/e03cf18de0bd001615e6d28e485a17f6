package es.crimarde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Imagenes")
public class Imagen {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idImagen;
	
	@Lob
	@Column(name = "imagen")
	private byte[] imagen;
	
	@Column(name = "nombre")
	private String  nombre;

	public Imagen() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Long idImagen) {
		this.idImagen = idImagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}