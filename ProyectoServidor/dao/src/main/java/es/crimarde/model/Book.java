package es.crimarde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")

public class Book {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id 						private Long id;
	@Column(name="titulo") 		private String titulo;
	@Column(name="autor")  		private String autor;
	@Column(name="sinopsis")	private String sinopsis;
	//@Column(name="imagen")		private Byte[] imagen;
	@Column(name="precio")		private double precio;

	public Book() {
	}
		
	public Book(Long id, String titulo, String autor, String sinopsis, double precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.sinopsis = sinopsis;
		//this.imagen = imagen;
		this.precio = precio;
	}
	
	public Book(Builder builder) {
		super();
		this.id = builder.getId();
		this.titulo = builder.getTitulo();
		this.autor = builder.getAutor();
		this.sinopsis = builder.getSinopsis();
		//this.imagen = builder.getImagen();
		this.precio = builder.getPrecio();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

//	public Byte[] getImagen() {
//		return imagen;
//	}
//
//	public void setImagen(Byte[] imagen) {
//		this.imagen = imagen;
//	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Builder builder(){
		return new Builder();
	}
	
	public class Builder {
		
		private Long id;
		private String titulo;
		private String sinopsis;
		private String autor;
		private double precio;

		public Builder() {
		}

		public Builder whithId(Long id) {
			this.id = id;
			return this;
		}

		public Builder whithTitulo(String titulo) {
			this.titulo = titulo;
			return this;
		}

		public Builder whithSinopsis(String sinopsis) {
			this.sinopsis = sinopsis;
			return this;
		}

		public Builder whithAutor(String autor) {
			this.autor = autor;
			return this;
		}

		public Builder whithPrecio(double precio) {
			this.precio = precio;
			return this;
		}
		
		public Book build(){
			return new Book(this);
		}

		public Long getId() {
			return id;
		}

		public String getTitulo() {
			return titulo;
		}

		public String getSinopsis() {
			return sinopsis;
		}

		public String getAutor() {
			return autor;
		}

		public double getPrecio() {
			return precio;
		}
	}

}