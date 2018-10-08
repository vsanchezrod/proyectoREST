package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Mensaje;

public interface MensajesRepository extends MongoRepository<Mensaje, String> {

}
