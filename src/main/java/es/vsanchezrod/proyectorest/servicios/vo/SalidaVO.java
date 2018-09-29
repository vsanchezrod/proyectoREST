package es.vsanchezrod.proyectorest.servicios.vo;

import java.util.Date;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Categoria;

public class SalidaVO extends ActividadVO{
	
	public SalidaVO() {
		super();
	}
		
	public SalidaVO(String nombre, List<Categoria> categorias, String descripcion, 
			int nivel, int distancia, Date fechaInicio, String imagen,
			List<String> coordenadas, String idUsuarioCreacion) {
		
		super(nombre, categorias, descripcion, nivel, distancia, fechaInicio, imagen, coordenadas, idUsuarioCreacion);
	}

}