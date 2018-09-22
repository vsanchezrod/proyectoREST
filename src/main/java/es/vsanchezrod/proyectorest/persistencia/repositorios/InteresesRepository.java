package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Interes;

public interface InteresesRepository extends MongoRepository<Interes, String> {
	
}
