package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;

public interface UsuariosRepository extends MongoRepository<Usuario, String>{

	// Query para buscar usuarios por email (finy + Nombre de la propiedad)
	Usuario findByEmail(String email);
}
