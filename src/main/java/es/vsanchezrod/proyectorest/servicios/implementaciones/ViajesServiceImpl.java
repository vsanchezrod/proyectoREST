package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBList;

import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;
import es.vsanchezrod.proyectorest.persistencia.repositorios.ViajesRepository;
import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ViajesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@Service
public class ViajesServiceImpl implements ViajesService {

	@Autowired
	private ViajesConverter viajesConverter;
	
	@Autowired
	private ViajesRepository viajesRepository;
	
	@Override
	public void crearViaje(ViajeVO viajeVO) {
		this.viajesRepository.save(this.viajesConverter.convertirViajeVOAViaje(viajeVO));
	}
	
	@Override
	public List<ViajeVO> obtenerListaViajes(Map<String, String> queryParams) {
		
		List<Viaje> listaViajes = new ArrayList<>();
		
		if(queryParams.containsKey("categoria")) {
			final String idCategoria = queryParams.get("categoria");
			listaViajes = viajesRepository.findByCategoriasCategoriaId(idCategoria);
		}
			
		if(queryParams.containsKey("realizadas")) {
			
			if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == true) {
				listaViajes = viajesRepository.findByFechaInicioLessThanOrderByFechaInicioDesc(new Date());
			}
			
			if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == false) {
				listaViajes = viajesRepository.findByFechaInicioGreaterThanOrderByFechaInicioAsc(new Date());
			}
			
			if (listaViajes.isEmpty()) {
				listaViajes = viajesRepository.findAll();
			}
		}
		
		if(queryParams.isEmpty()) {
			listaViajes = viajesRepository.findAll();
		}
				
		return viajesConverter.convertirListaViajessAListaViajesVO(listaViajes);
	
	}

	
	@Override
	public void borrarViaje(String id) {
		viajesRepository.deleteById(id);
	}

	@Override
	public TotalVO obtenerNumeroViajes() {
		final TotalVO totalVO = new TotalVO();
		totalVO.setTotal(viajesRepository.count());
		return totalVO;
	}

	@Override
	public List<ViajeVO> obtenerListaViajesConQueryParam(Map<String, String> queryParams) {
		
		List<Viaje> listaViajes = new ArrayList<>();
		if(queryParams.containsKey("participante") && queryParams.containsKey("realizadas")) {
			
			if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == true) {
				listaViajes = viajesRepository.findByListaParticipantesAndFechaInicioLessThanOrderByFechaInicioDesc(queryParams.get("participante"), new Date());
			}
			
			if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == false) {
				listaViajes = viajesRepository.findByListaParticipantesAndFechaInicioGreaterThanOrderByFechaInicioAsc(queryParams.get("participante"), new Date());
			}
		}
		
		else {
			// Identificar criterios de filtrado
			final Example<Viaje> exampleViaje = identificarCriteriosDeFiltrado(queryParams);
			listaViajes = viajesRepository.findAll(exampleViaje);
		}
			
		return viajesConverter.convertirListaViajessAListaViajesVO(listaViajes);
		
	}
	
	private Example<Viaje> identificarCriteriosDeFiltrado(Map<String, String> queryParams) {
		
		final ExampleMatcher viajeMatcher = ExampleMatcher.matching()
				.withIgnoreNullValues();
		
		final Viaje viajeQuery = new Viaje();
		
		// Como son lista vacías y se inicializan a [], es necesario establecer como valor null para que no sean parámetros de filtrado de datos
		viajeQuery.setCategorias(null);
		viajeQuery.setListaParticipantes(null);
				
		if(queryParams.containsKey("creador")) {
			viajeQuery.setIdUsuarioCreacion(queryParams.get("creador"));
		}
		
		if(queryParams.containsKey("participante")) {
			viajeMatcher.withMatcher("listaParticipantes", match -> match.transform(source -> ((BasicDBList) source).iterator().next()).caseSensitive());
			final List<String> listaParticipantes = new ArrayList<>();
			listaParticipantes.add(queryParams.get("participante"));
			viajeQuery.setListaParticipantes(listaParticipantes);
		}
		
		final Example<Viaje> exampleViaje = Example.of(viajeQuery, viajeMatcher);
		return exampleViaje;
	}

}
