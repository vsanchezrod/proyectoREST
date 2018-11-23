package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

public class MensajeVO {

	private String id;
	private String idUsuarioEmisor;
	@NotBlank(message = "El usuario receptor no puede estar vacío")
	private String idUsuarioReceptor;
	@NotNull(message = "La fecha no puede estar vacía")
	private Date fecha;
	
	@NotBlank(message = "El asunto no puede estar vacío")
	private String asunto;
	@NotBlank(message = "El mensaje no puede estar vacío")
	private String cuerpoMensaje;
	private boolean leido;
	
	public MensajeVO () {
		this.leido = false;
	}
	
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
	
	public String getCuerpoMensaje() {
		return cuerpoMensaje;
	}
	
	public void setCuerpoMensaje(String cuerpoMensaje) {
		this.cuerpoMensaje = cuerpoMensaje;
	}
	
	
	public boolean getLeido() {
		return leido;
	}

	public void setLeido(boolean leido) {
		this.leido = leido;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
