package es.vsanchezrod.proyectorest.persistencia.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Provincia;

public interface ProvinciasRepository extends MongoRepository<Provincia, String>{}
