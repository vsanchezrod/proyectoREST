package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;
import java.util.List;

public class Salida extends Actividad {
	
	public Salida(String nombre, List<Categoria> categorias, String descripcion, 
			String nivel, String distancia, Date fechaInicio, String imagen,
			List<String> coordenadas, String idUsuarioCreacion) {
		
		super(nombre, categorias, descripcion,nivel, distancia, fechaInicio, imagen, coordenadas, idUsuarioCreacion);
	}
}
