package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

public class OpinionVO {

	private String id;
	
	@NotNull(message = "La actividad no puede estar vacía")
	private OpinionActividadVO actividad; // id, nombre act y lista categorias
	@NotBlank(message = "El título no puede estar vacío")
	private String titulo;
	@NotBlank(message = "El detalle no puede estar vacío")
	private String detalle;
	@NotNull(message = "La fecha no puede estar vacía")
	private Date fecha;
	@NotNull(message = "La valoración no puede estar vacía")
	private int organizacionValoracion;
	@NotNull(message = "La valoración no puede estar vacía")
	private int ambienteValoracion;
	@NotNull(message = "La valoración no puede estar vacía")
	private int recorridoValoracion;
	private String usuarioOpinion; // id
	
	public OpinionVO() {
		this.actividad = new OpinionActividadVO();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OpinionActividadVO getActividad() {
		return actividad;
	}

	public void setActividad(OpinionActividadVO actividad) {
		this.actividad = actividad;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getOrganizacionValoracion() {
		return organizacionValoracion;
	}

	public void setOrganizacionValoracion(int organizacionValoracion) {
		this.organizacionValoracion = organizacionValoracion;
	}

	public int getAmbienteValoracion() {
		return ambienteValoracion;
	}

	public void setAmbienteValoracion(int ambienteValoracion) {
		this.ambienteValoracion = ambienteValoracion;
	}

	public int getRecorridoValoracion() {
		return recorridoValoracion;
	}

	public void setRecorridoValoracion(int recorridoValoracion) {
		this.recorridoValoracion = recorridoValoracion;
	}

	public String getUsuarioOpinion() {
		return usuarioOpinion;
	}

	public void setUsuarioOpinion(String usuarioOpinion) {
		this.usuarioOpinion = usuarioOpinion;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
