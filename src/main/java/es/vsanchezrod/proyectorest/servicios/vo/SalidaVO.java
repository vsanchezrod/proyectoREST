package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Coordenada;

public class SalidaVO extends ActividadVO {
	
	private int puntuacion;
	private int participantes;
	
	public SalidaVO() {
		super();
	}
		
	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	@Override
	public String toString() {
		return "SalidaVO [puntuacion=" + puntuacion + ", participantes=" + participantes + "]";
	}
		
}
