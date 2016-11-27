package es.crimarde.negocio;

import com.mysql.jdbc.Blob;


public class BookDTO {
	
	private int id;
	private String titulo;
	private String autor;
	private String sinopsis;
	private Blob imagen;
	private double precio;

	public BookDTO() {
	}
		
	public BookDTO(int id, String titulo, String autor, String sinopsis, Blob imagen, double precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.sinopsis = sinopsis;
		this.imagen = imagen;
		this.precio = precio;
	}
	
	public BookDTO(Builder builder) {
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

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
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
	private Blob imagen;
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

	public void whithImagen(Blob imagen) {
		this.imagen = imagen;
	}

	public void whithPrecio(double precio) {
		this.precio = precio;
	}
	
	public BookDTO build(){
		return new BookDTO(this);
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

	public Blob getImagen() {
		return imagen;
	}

	public double getPrecio() {
		return precio;
	}
}