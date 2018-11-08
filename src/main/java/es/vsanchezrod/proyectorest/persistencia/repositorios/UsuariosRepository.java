package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;

public interface UsuariosRepository extends MongoRepository<Usuario, String>{

	// Query para buscar usuarios por email (findBy + Nombre de la propiedad)
	Usuario findByEmail(String email);
	
	List<Usuario> findByNombreIgnoreCase(String nombre);
	
	Usuario findById(String id);
	
	void deleteById(String id);

}
