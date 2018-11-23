package es.vsanchezrod.proyectorest.servicios.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;

public class NuevoParticipanteVO {

	@NotBlank(message = "El nuevo participante no puede ser null")
	private String idParticipante;

	public String getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(String id) {
		this.idParticipante = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}
