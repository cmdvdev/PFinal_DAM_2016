package es.crimarde.negocio;

public class ImageDTO {

	private Long idImagen;
	private byte[] imagen;
	private String  nombre;
	
	public ImageDTO() {
	}
	
	public ImageDTO(Long idImagen, byte[] imagen, String nombre) {
		super();
		this.idImagen = idImagen;
		this.imagen = imagen;
		this.nombre = nombre;
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

