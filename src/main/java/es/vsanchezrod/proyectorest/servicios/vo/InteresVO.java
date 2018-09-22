package es.vsanchezrod.proyectorest.servicios.vo;

public class InteresVO {

	private String id;
	private String nombre;
	private String descripcion;
	
	public InteresVO(String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public InteresVO() {}
	
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
	
	@Override
	public String toString() {
		return "InteresVO [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
