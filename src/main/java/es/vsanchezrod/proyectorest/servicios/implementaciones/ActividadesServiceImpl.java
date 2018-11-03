package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;
import es.vsanchezrod.proyectorest.persistencia.repositorios.ActividadesRepository;
import es.vsanchezrod.proyectorest.servicios.ActividadesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ActividadesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

@Service
public class ActividadesServiceImpl implements ActividadesService {

	@Autowired
	private ActividadesConverter actividadesConverter;
	
	@Autowired
	private ActividadesRepository actividadesRepository;
		
	@Override
	public void crearActividad(ActividadVO actividadVO) {
		actividadesRepository.save(actividadesConverter.convertirActividadVOAActividad(actividadVO));
	}

	@Override
	public List<ActividadVO> obtenerListaActividades(Map<String, String> queryParams) {
		List<Actividad> listaActividades = new ArrayList<>();
		
		if(queryParams.containsKey("realizadas") && (BooleanUtils.toBoolean(queryParams.get("realizadas")) == true)) {
			listaActividades = actividadesRepository.findByFechaInicioLessThanOrderByFechaInicioDesc(new Date());
		}
		else {
			listaActividades = actividadesRepository.findByFechaInicioGreaterThanOrderByFechaInicioAsc(new Date());
		}
		return actividadesConverter.convetirListaActividadesAListaActividadesVO(listaActividades);
	}

	@Override
	public void borrarActividad(String id) {
		actividadesRepository.deleteById(id);
	}

	@Override
	public List<ActividadVO> obtenerListaActividadesConQueryParam(Map<String, String> queryParams) {
		
		// Identificar criterios de filtrado
		final Example<Actividad> exampleActividad = identificarCriteriosDeFiltrado(queryParams);
		
		final List<Actividad> listaActividades = actividadesRepository.findAll(exampleActividad);
		return actividadesConverter.convetirListaActividadesAListaActividadesVO(listaActividades);
		
	}

	@Override
	public TotalVO obtenerNumeroActividades() {
		
		final TotalVO totalVO = new TotalVO();
		totalVO.setTotal(actividadesRepository.count());
		return totalVO;
		
	}
	
	private Example<Actividad> identificarCriteriosDeFiltrado(Map<String, String> queryParams) {
		final Actividad actividadQuery = new Actividad();
		
		// Como son lista vacías y se inicializan a [], es necesario establecer como valor null para que no sean parámetros de filtrado de datos
		actividadQuery.setCategorias(null);
		actividadQuery.setListaParticipantes(null);
				
		if(queryParams.containsKey("creador")) {
			actividadQuery.setIdUsuarioCreacion(queryParams.get("creador"));
		}
		
		if(queryParams.containsKey("participante")) {
			List<String> listaParticipantes = new ArrayList<>();
			listaParticipantes.add(queryParams.get("participante"));
		
			
			actividadQuery.setListaParticipantes(listaParticipantes);
		}
		
		final Example<Actividad> exampleActividad = Example.of(actividadQuery);
		return exampleActividad;
	}

}
