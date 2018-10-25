package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OpinionVO {

	private String id;
	private OpinionActividadVO actividad; // id, nombre act y lista categorias
	private String titulo;
	private String detalle;
	private Date fecha;
	private int organizacionValoracion;
	private int ambienteValoracion;
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
