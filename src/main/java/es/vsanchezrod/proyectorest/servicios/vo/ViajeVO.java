package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ViajeVO extends ActividadVO {

	@NotNull(message = "La fecha no puede estar vacía")
	@Future(message = "La fecha debe ser futura")
	private Date fechaFin;
	@NotNull(message = "El precio no puede estar vacio")
	private Integer precio;
	@NotNull(message = "Las plazas no pueden estar vacías")
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
