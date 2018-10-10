package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;

public interface UsuariosRepository extends MongoRepository<Usuario, String>{

	// Query para buscar usuarios por email (findBy + Nombre de la propiedad)
	Usuario findByEmail(String email);
	
	Usuario findByNombre(String nombre);
	
	Usuario findById(String id);
	
}
