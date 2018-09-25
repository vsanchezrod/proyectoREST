package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;

public class Viaje extends Actividad {

	private Date fechaFin;
	private int precio;
	
	public Viaje(Date fechaFin, int precio) {
		super();
		this.fechaFin = fechaFin;
		this.precio = precio;
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

	@Override
	public String toString() {
		return "Viaje [fechaFin=" + fechaFin + ", precio=" + precio + "]";
	}
		
}
