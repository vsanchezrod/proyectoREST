package es.vsanchezrod.proyectorest.servicios.vo;

public class ProvinciaVO {

	public int codigo;
	public String nombre;
	
	public ProvinciaVO (int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "ProvinciaVO [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
}
