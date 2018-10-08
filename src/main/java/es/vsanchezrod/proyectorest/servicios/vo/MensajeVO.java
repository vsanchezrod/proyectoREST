package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MensajeVO {

	private String id;
	private String idUsuarioEmisor;
	private String idUsuarioReceptor;
	private Date fecha;
	private String asunto;
	private String mensaje;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdUsuarioEmisor() {
		return idUsuarioEmisor;
	}
	
	public void setIdUsuarioEmisor(String idUsuarioEmisor) {
		this.idUsuarioEmisor = idUsuarioEmisor;
	}
	
	public String getIdUsuarioReceptor() {
		return idUsuarioReceptor;
	}
	
	public void setIdUsuarioReceptor(String idUsuarioReceptor) {
		this.idUsuarioReceptor = idUsuarioReceptor;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getAsunto() {
		return asunto;
	}
	
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
