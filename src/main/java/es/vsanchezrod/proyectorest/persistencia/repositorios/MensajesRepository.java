package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Mensaje;

public interface MensajesRepository extends MongoRepository<Mensaje, String> {

	List<Mensaje> findByidUsuarioReceptorOrderByFechaDesc(String id);
	
	void deleteById(String id);
	
	Mensaje findById(String id);
	
	long countByidUsuarioReceptorAndLeido(String id, Boolean estado);
}
