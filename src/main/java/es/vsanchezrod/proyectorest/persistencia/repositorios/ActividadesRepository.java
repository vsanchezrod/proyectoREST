package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;

public interface ActividadesRepository extends MongoRepository<Actividad, String> {

}
