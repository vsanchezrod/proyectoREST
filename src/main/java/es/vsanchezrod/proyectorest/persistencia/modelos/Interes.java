package es.vsanchezrod.proyectorest.persistencia.modelos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Etiqueta de Spring que modifica el nombre de la colección de Mongodb
@Document(collection = "Intereses")
public class Interes {

	@Id
	private String id;
	private String nombre;
	private String descripcion;
	
	public Interes (String id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	
	@Override
	public String toString() {
		return "Interes [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
