package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Coordenada;

public class SalidaVO extends ActividadVO {
	
	public SalidaVO() {
		super();
	}
		
	public SalidaVO(String id, String nombre, List<CategoriaVO> categorias, String descripcion, 
			int nivel, int distancia, Date fechaInicio, String imagen,
			Coordenada coordenadas, String idUsuarioCreacion) {
		
		super(id, nombre, categorias, descripcion, nivel, distancia, fechaInicio, imagen, coordenadas, idUsuarioCreacion);
	}

}
