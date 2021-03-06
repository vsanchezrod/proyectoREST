package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;

public interface ActividadesRepository extends MongoRepository<Actividad, String> {

	void deleteById(String id);
	
	List<Actividad> findByIdUsuarioCreacion(String id); 
	
	List<Actividad> findByFechaInicioGreaterThanOrderByFechaInicioAsc(Date fecha);
	
	List<Actividad> findByFechaInicioLessThanOrderByFechaInicioDesc(Date fecha);
	
	List<Actividad> findByCategoriasCategoriaIdAndFechaInicioGreaterThanOrderByFechaInicioAsc(String idCategoria, Date fecha);
		
	List<Actividad> findByListaParticipantesAndFechaInicioLessThanOrderByFechaInicioDesc(String idParticipante, Date fecha);
	
	List<Actividad> findByListaParticipantesAndFechaInicioGreaterThanOrderByFechaInicioAsc(String idParticipante, Date fecha);
		
	Actividad findById(String id);
	
	List<Actividad> findByListaParticipantes(String idParticipante);
}
