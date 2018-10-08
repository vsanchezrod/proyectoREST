package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OpinionActividad {

	private String id;
	private String nombre;
	private List<ActividadCategoria> categorias;
	
	public OpinionActividad() {
		this.categorias = new ArrayList<>();
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
	
	public List<ActividadCategoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<ActividadCategoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	
	
}
