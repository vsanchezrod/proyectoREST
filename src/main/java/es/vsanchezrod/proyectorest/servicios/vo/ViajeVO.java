package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Coordenada;

public class ViajeVO extends ActividadVO {

	private Date fechaFin;
	private int precio;
	private int plazas;
	private int plazasLibres;
	
	public ViajeVO() {}
	
	
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
		
	public int getPlazasLibres() {
		return plazasLibres;
	}

	public void setPlazasLibres(int plazasLibres) {
		this.plazasLibres = plazasLibres;
	}

	@Override
	public String toString() {
		return "ViajeVO [fechaFin=" + fechaFin + ", precio=" + precio + ", plazas=" + plazas + ", plazasLibres="
				+ plazasLibres + "]";
	}

}
