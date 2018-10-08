package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ViajeVO extends ActividadVO {

	private Date fechaFin;
	private int precio;
	private int plazas;
	
	public ViajeVO() {
		super();
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
		return ToStringBuilder.reflectionToString(this);
	}

}
