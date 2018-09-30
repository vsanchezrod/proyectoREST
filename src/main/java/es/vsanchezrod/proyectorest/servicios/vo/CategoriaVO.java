package es.vsanchezrod.proyectorest.servicios.vo;

public class CategoriaVO {

	private String id;
	private String nombre;
	private String descripcion;
	private String imagen;
	
	public CategoriaVO() {}
	
	public CategoriaVO(String id, String nombre, String descripcion, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "CategoriaVO [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ "]";
	}
	
}
