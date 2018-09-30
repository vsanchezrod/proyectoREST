package es.vsanchezrod.proyectorest.persistencia.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

//Etiqueta de Spring que modifica el nombre de la colección de Mongodb
@Document(collection = "Salidas")
public class Salida extends Actividad {

	public Salida() {
		super();
	}
	
	public Salida(String id, String nombre, List<Categoria> categorias, String descripcion, 
			int nivel, int distancia, Date fechaInicio, String imagen,
			Coordenada coordenadas, String idUsuarioCreacion) {
		
		super(id, nombre, categorias, descripcion, nivel, distancia, fechaInicio, imagen, coordenadas, idUsuarioCreacion);
	}
	
}
