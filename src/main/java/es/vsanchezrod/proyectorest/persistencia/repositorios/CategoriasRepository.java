package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Categoria;

public interface CategoriasRepository extends MongoRepository<Categoria, String>{

}
