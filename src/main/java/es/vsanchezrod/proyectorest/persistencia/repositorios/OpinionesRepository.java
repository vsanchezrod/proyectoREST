package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Opinion;

public interface OpinionesRepository extends MongoRepository<Opinion, String>{

	List<Opinion> findTop5ByOrderByFechaDesc();
	
	void deleteById(String id);
}
