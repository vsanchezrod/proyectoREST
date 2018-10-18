package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Mensaje;

public interface MensajesRepository extends MongoRepository<Mensaje, String> {

	List<Mensaje> findByidUsuarioReceptor(String id);
	
	void deleteById(String id);
}
