package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Opiniones")
public class Opinion {

	@Id
	private String id;
	private OpinionActividad actividad; // id, nombre act y lista categorias
	private String titulo;
	private String detalle;
	private Date fecha;
	private int organizacionValoracion;
	private int ambienteValoracion;
	private int recorridoValoracion;	
	private OpinionUsuario usuario; // id, nombre y avatar
	
	public Opinion() {
		this.actividad = new OpinionActividad();
		this.usuario = new OpinionUsuario();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public OpinionActividad getActividad() {
		return actividad;
	}

	public void setActividad(OpinionActividad actividad) {
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

	public OpinionUsuario getOpinionUsuario() {
		return usuario;
	}

	public void setOpinionUsuario(OpinionUsuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}


