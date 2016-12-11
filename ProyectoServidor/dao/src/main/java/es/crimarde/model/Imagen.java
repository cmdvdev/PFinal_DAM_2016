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
	@Column(name="id")
	private Long id;
	
	@Lob
	@Column(name = "imagen")
	private byte[] imagen;
	
	@Column(name = "nombre")
	private String  nombre;

	public Imagen() {
		// TODO Auto-generated constructor stub
	}

	public Imagen(Long id, byte[] imagen, String nombre) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.nombre = nombre;
	}

	public Long getIdImagen() {
		return id;
	}

	public void setIdImagen(Long idImagen) {
		this.id = idImagen;
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