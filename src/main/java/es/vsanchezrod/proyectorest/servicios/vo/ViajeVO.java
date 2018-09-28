package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;

public class ViajeVO extends Actividad {

	private Date fechaFin;
	private int precio;
	private int plazas;
	
	public ViajeVO() {}
	
	public ViajeVO(Date fechaFin, int precio, int plazas) {
		super();
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
