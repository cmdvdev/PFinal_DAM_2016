package es.crimarde.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")

public class Book {

	
	@GeneratedValue
	@Id 						private int id;
	@Column(name="titulo") 		private String titulo;
	@Column(name="autor")  		private String autor;
	@Column(name="sinopsis")	private String sinopsis;
	@Column(name="imagen")		private Byte[] imagen;
	@Column(name="precio")		private double precio;

	public Book() {
	}
		
	public Book(int id, String titulo, String autor, String sinopsis, Byte[] imagen, double precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.sinopsis = sinopsis;
		this.imagen = imagen;
		this.precio = precio;
	}
	
	public Book(Builder builder) {
		super();
		this.id = builder.getId();
		this.titulo = builder.getTitulo();
		this.autor = builder.getAutor();
		this.sinopsis = builder.getSinopsis();
		this.imagen = builder.getImagen();
		this.precio = builder.getPrecio();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Byte[] getImagen() {
		return imagen;
	}

	public void setImagen(Byte[] imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}

class Builder {
	
	private int id;
	private String titulo;
	private String sinopsis;
	private String autor;
	private Byte[] imagen;
	private double precio;

	public Builder() {
	}

	public void whithId(int id) {
		this.id = id;
	}

	public void whithTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void whithSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public void whithAutor(String autor) {
		this.autor = autor;
	}

	public void whithImagen(Byte[] imagen) {
		this.imagen = imagen;
	}

	public void whithPrecio(double precio) {
		this.precio = precio;
	}
	
	public Book build(){
		return new Book(this);
	}

	public int getId() {
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

	public Byte[] getImagen() {
		return imagen;
	}

	public double getPrecio() {
		return precio;
	}
	
}