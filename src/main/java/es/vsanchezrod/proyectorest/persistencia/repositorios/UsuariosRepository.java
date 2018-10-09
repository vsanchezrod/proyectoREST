package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;

public interface UsuariosRepository extends MongoRepository<Usuario, String>{

	// Query para buscar usuarios por email (finBy + Nombre de la propiedad)
	Usuario findByEmail(String email);
	
	// Query para buscar usuarios por nombre (finBy + Nombre de la propiedad)
	Usuario findByNombre(String nombre);
	
	// Query para buscar usuario por id (finBy + Nombre de la propiedad)
	Usuario findById(String id);
	
}
