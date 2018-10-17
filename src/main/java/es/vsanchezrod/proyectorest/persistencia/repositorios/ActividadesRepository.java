package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;

public interface ActividadesRepository extends MongoRepository<Actividad, String> {

	void deleteById(String id);
	
	List<Actividad> findByIdUsuarioCreacion(String id); 
	
}
