package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Interes;

@Repository
public interface InteresesRepository extends MongoRepository<Interes, String> {
	
}
