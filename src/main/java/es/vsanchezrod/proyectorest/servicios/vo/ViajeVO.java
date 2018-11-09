package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ViajeVO extends ActividadVO {

	private Date fechaFin;
	private Integer precio;
	private Integer plazas;
	
	public ViajeVO() {
		super();
	}
		
	public Date getFechaFin() {
		return fechaFin;	
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
