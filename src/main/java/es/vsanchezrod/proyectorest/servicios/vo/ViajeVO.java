package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Categoria;

public class ViajeVO extends ActividadVO {

	private Date fechaFin;
	private int precio;
	private int plazas;
	
	public ViajeVO() {}
	
	public ViajeVO(String id, String nombre, List<Categoria> categorias, String descripcion, 
			int nivel, int distancia, Date fechaInicio, String imagen,
			List<String> coordenadas, String idUsuarioCreacion, Date fechaFin, int precio, int plazas) {
		
		super(id, nombre, categorias, descripcion, nivel, distancia, fechaInicio, imagen, coordenadas, idUsuarioCreacion);
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
		return "ViajeVO [fechaFin=" + fechaFin + ", precio=" + precio + ", plazas=" + plazas + "]";
	}
	
		
}
