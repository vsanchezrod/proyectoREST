package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

public class OpinionActividadVO {

	private String id;
	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;
	private List<ActividadCategoriaVO> categorias;
	
	public OpinionActividadVO() {
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

	public List<ActividadCategoriaVO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<ActividadCategoriaVO> categorias) {
		this.categorias = categorias;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
