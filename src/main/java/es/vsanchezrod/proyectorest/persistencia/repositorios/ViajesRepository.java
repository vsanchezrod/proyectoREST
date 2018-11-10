package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;
import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;

public interface ViajesRepository extends MongoRepository<Viaje, String> {
	
	void deleteById(String id);
	
	List<Viaje> findByFechaInicioGreaterThanOrderByFechaInicioAsc(Date fecha);
	
	List<Viaje> findByFechaInicioLessThanOrderByFechaInicioDesc(Date fecha);
	
	List<Viaje> findByCategoriasCategoriaIdAndFechaInicioGreaterThanOrderByFechaInicioAsc(String idCategoria, Date fecha);
	
	List<Viaje> findByListaParticipantesAndFechaInicioLessThanOrderByFechaInicioDesc(String idParticipante, Date fecha);
	
	List<Viaje> findByListaParticipantesAndFechaInicioGreaterThanOrderByFechaInicioAsc(String idParticipante, Date fecha);

	List<Viaje> findByListaParticipantes(String idParticipante);

	Viaje findById(String id);
		
}
