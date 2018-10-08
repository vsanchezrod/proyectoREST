package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Viajes")
public class Viaje extends Actividad {

	private Date fechaFin;
	private int precio;
	private int plazas;

	public Viaje() {
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
