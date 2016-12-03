package es.crimarde.negocio;

import com.mysql.jdbc.Blob;


public class BookDTO {
	
	private Integer id;
	private String titulo;
	private String autor;
	private String sinopsis;
	private Blob imagen;
	private double precio;

	public BookDTO() {
	}
		
	public BookDTO(Integer id, String titulo, String autor, String sinopsis, Blob imagen, double precio) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public Builder builder() {
		return new Builder();
	}
	
	public class Builder {
		
		private Integer id;
		private String titulo;
		private String sinopsis;
		private String autor;
		private Blob imagen;
		private double precio;

		public Builder() {
		}

		public Builder whithId(Integer id) {
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

		public Builder whithImagen(Blob imagen) {
			this.imagen = imagen;
			return this;
		}

		public Builder whithPrecio(double precio) {
			this.precio = precio;
			return this;
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
}

