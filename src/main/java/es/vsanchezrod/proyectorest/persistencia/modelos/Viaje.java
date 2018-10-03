package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Viajes")
public class Viaje extends Actividad {

	private Date fechaFin;
	private int precio;
	private int plazas;
	
	public Viaje() {
		super();
	}
	
	public Viaje(String id, String nombre, List<Categoria> categorias, String descripcion, 
			int nivel, int distancia, Date fechaInicio, String imagen,
			Coordenada coordenadas, String idUsuarioCreacion, Date fechaFin, int precio, int plazas) {
		
		super(id, nombre, categorias, descripcion, nivel, distancia, fechaInicio, imagen,coordenadas, idUsuarioCreacion);
		
		this.fechaFin = fechaFin;
		this.precio = precio;
		this.plazas = plazas;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return "Viaje [fechaFin=" + fechaFin + ", precio=" + precio + ", plazas=" + plazas + "]";
	}
	
}
