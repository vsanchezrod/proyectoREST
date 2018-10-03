package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;

public interface ViajesRepository extends MongoRepository<Viaje, String> {

}
