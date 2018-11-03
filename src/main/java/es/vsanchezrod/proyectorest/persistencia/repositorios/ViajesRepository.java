package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;

public interface ViajesRepository extends MongoRepository<Viaje, String> {
	
	List<Viaje> findByFechaInicioGreaterThanOrderByFechaInicioAsc(Date fecha);
	
	List<Viaje> findByFechaInicioLessThanOrderByFechaInicioDesc(Date fecha);

}
