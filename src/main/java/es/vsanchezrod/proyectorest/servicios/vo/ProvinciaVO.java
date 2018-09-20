package es.vsanchezrod.proyectorest.servicios.vo;

public class ProvinciaVO {

	public int id;
	public String nombre;
	
	public ProvinciaVO (int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "ProvinciaVO [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
