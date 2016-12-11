package es.crimarde.negocio;

public class BookDTO {

	private Long id;
	private String titulo;
	private String autor;
	private String sinopsis;
	private Long idImagen;
	private ImageDTO imagen;
	private double precio;
	private String isbn;
	private String genero;
	private Integer paginas;


	public BookDTO() {
	}
		
	public BookDTO(Long id, String titulo, String autor, String sinopsis, ImageDTO imagen, double precio, String isbn,
			String genero, Integer paginas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.sinopsis = sinopsis;
		this.imagen = imagen;
		this.precio = precio;
		this.isbn = isbn;
		this.genero = genero;
		this.paginas = paginas;
	}

	public BookDTO(Builder builder) {
		super();
		this.id = builder.getId();
		this.titulo = builder.getTitulo();
		this.autor = builder.getAutor();
		this.sinopsis = builder.getSinopsis();
		this.imagen = builder.getImagen();
		this.precio = builder.getPrecio();
		this.isbn = builder.getIsbn();
		this.genero = builder.getGenero();
		this.paginas = builder.getPaginas();
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public ImageDTO getImagen() {
		return imagen;
	}
	
	public void setImagen(ImageDTO imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Long getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Long idImagen) {
		this.idImagen = idImagen;
	}

	public Builder builder(){
		return new Builder();
	}
	
	public class Builder {
		
		private Long id;
		private String titulo;
		private String sinopsis;
		private String autor;
		private ImageDTO imagen;
		private double precio;
		private String isbn;
		private String genero;
		private Integer paginas;

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
		
		public Builder whithISNn(String isbn) {
			this.isbn = isbn;
			return this;
		}
		
		public Builder whithIGenro(String genero) {
			this.genero = genero;
			return this;
		}
		
		public Builder whithPaginas(Integer paginas) {
			this.paginas = paginas;
			return this;
		}
		
		public Builder whithImagen(ImageDTO imagen) {
			this.imagen = imagen;
			return this;
		}
		
		public BookDTO build(){
			return new BookDTO(this);
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

		public ImageDTO getImagen() {
			return imagen;
		}

		public String getIsbn() {
			return isbn;
		}

		public String getGenero() {
			return genero;
		}

		public Integer getPaginas() {
			return paginas;
		}
	}

}