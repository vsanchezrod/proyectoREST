package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;
import es.vsanchezrod.proyectorest.persistencia.modelos.Mensaje;
import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.persistencia.repositorios.ActividadesRepository;
import es.vsanchezrod.proyectorest.persistencia.repositorios.MensajesRepository;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;
import es.vsanchezrod.proyectorest.servicios.ActividadesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ActividadesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;
import es.vsanchezrod.proyectorest.servicios.vo.NuevoParticipanteVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

@Service
public class ActividadesServiceImpl implements ActividadesService {

	@Autowired
	private ActividadesConverter actividadesConverter;
	
	@Autowired
	private ActividadesRepository actividadesRepository;
	
	@Autowired
	private MensajesRepository mensajesRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	public void crearActividad(ActividadVO actividadVO) {
		
		final Actividad actividad = actividadesConverter.convertirActividadVOAActividad(actividadVO);
		actividadesRepository.save(actividad);
	}
	
	@Override
	public ActividadVO obtenerActividad(String id) {
		Actividad actividad = actividadesRepository.findById(id);
		return actividadesConverter.convertirActividadAActividadVO(actividad);
	}

	@Override
	public List<ActividadVO> obtenerListaActividades(Map<String, String> queryParams) {
		List<Actividad> listaActividades = new ArrayList<>();
				
		if(queryParams.containsKey("categoria")) {
			final String idCategoria = queryParams.get("categoria");
			listaActividades = actividadesRepository.findByCategoriasCategoriaIdAndFechaInicioGreaterThanOrderByFechaInicioAsc(idCategoria, new Date());
		}
				
		if(queryParams.containsKey("realizadas")) {
			
			if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == true) {
				listaActividades = actividadesRepository.findByFechaInicioLessThanOrderByFechaInicioDesc(new Date());
			}
			
			if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == false) {
				listaActividades = actividadesRepository.findByFechaInicioGreaterThanOrderByFechaInicioAsc(new Date());
			}

		}
		
		if(queryParams.isEmpty()) {
			listaActividades = actividadesRepository.findAll();
		}
				
		return actividadesConverter.convetirListaActividadesAListaActividadesVO(listaActividades);
	}

	@Override
	public void borrarActividad(String id, String motivo, String idUsuarioBorradorActividad) {
		final Actividad actividad = actividadesRepository.findById(id);
		
		if (actividad == null)  {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Actividad no encontrada");
		}
		for (String idUsuarioReceptor: actividad.getListaParticipantes()) {
			final Mensaje mensaje = new Mensaje();
			mensaje.setIdUsuarioEmisor(idUsuarioBorradorActividad);
			mensaje.setIdUsuarioReceptor(idUsuarioReceptor);
			mensaje.setFecha(new Date());
			mensaje.setAsunto("Actividad Cancelada: " + actividad.getNombre());
			mensaje.setCuerpoMensaje("Cancelada por: " + motivo);
			mensaje.setLeido(false);
			
			mensajesRepository.save(mensaje);
		}
					
		actividadesRepository.deleteById(id);
	}
	
	@Override
	public List<ActividadVO> obtenerListaActividadesConQueryParam(Map<String, String> queryParams) {
		
		List<Actividad> listaActividades = new ArrayList<>();
		
		if(queryParams.containsKey("participante")) {
			
			if(queryParams.containsKey("participante") && queryParams.containsKey("realizadas")) {
				
				if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == true) {
					listaActividades = actividadesRepository.findByListaParticipantesAndFechaInicioLessThanOrderByFechaInicioDesc(queryParams.get("participante"), new Date());
				}
				
				if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == false) {
					listaActividades = actividadesRepository.findByListaParticipantesAndFechaInicioGreaterThanOrderByFechaInicioAsc(queryParams.get("participante"), new Date());
				}
			}
			
			else {
				listaActividades = actividadesRepository.findByListaParticipantes(queryParams.get("participante"));
			}
		}
		
		else {
			// Identificar criterios de filtrado
			final Example<Actividad> exampleActividad = identificarCriteriosDeFiltrado(queryParams);
			listaActividades = actividadesRepository.findAll(exampleActividad);
		}
			
		return actividadesConverter.convetirListaActividadesAListaActividadesVO(listaActividades);
		
	}

	@Override
	public TotalVO obtenerNumeroActividades() {
		
		final TotalVO totalVO = new TotalVO();
		totalVO.setTotal(actividadesRepository.count());
		return totalVO;
		
	}
	
	private Example<Actividad> identificarCriteriosDeFiltrado(Map<String, String> queryParams) {
		
		final ExampleMatcher actividadMatcher = ExampleMatcher.matching()
				.withIgnoreNullValues();
		
		final Actividad actividadQuery = new Actividad();
		
		// Como son lista vacías y se inicializan a [], es necesario establecer como valor null para que no sean parámetros de filtrado de datos
		actividadQuery.setCategorias(null);
		actividadQuery.setListaParticipantes(null);
				
		if(queryParams.containsKey("creador")) {
			actividadQuery.setIdUsuarioCreacion(queryParams.get("creador"));
		}
				
		final Example<Actividad> exampleActividad = Example.of(actividadQuery, actividadMatcher);
		return exampleActividad;
	}

	@Override
	public void actualizarActividad(String idActividad, NuevoParticipanteVO nuevoParticipanteVO) {
		final Actividad actividad = actividadesRepository.findById(idActividad);
		if (actividad == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "La actividad no existe.");
		}
		
		final Usuario usuario = usuariosRepository.findById(nuevoParticipanteVO.getIdParticipante());
		
		if (usuario == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "El usuario no existe" );
		}
		
		final List<String> listaParticipantesActividad = actividad.getListaParticipantes();
		if (listaParticipantesActividad.contains(nuevoParticipanteVO.getIdParticipante())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Participante ya inscrito");
		}
		
		listaParticipantesActividad.add(nuevoParticipanteVO.getIdParticipante());
		actividad.setListaParticipantes(listaParticipantesActividad);
		actividadesRepository.save(actividad);
		
	}

	@Override
	public void editarActividad(String idActividad, ActividadVO actividadVO) {
		final Actividad actividad = actividadesRepository.findById(idActividad);
		if (actividad == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "La actividad no existe");
		}
		
		for (String idUsuarioReceptor: actividad.getListaParticipantes()) {
			final Mensaje mensaje = new Mensaje();
			mensaje.setIdUsuarioEmisor(actividad.getIdUsuarioCreacion());
			mensaje.setIdUsuarioReceptor(idUsuarioReceptor);
			mensaje.setFecha(new Date());
			mensaje.setAsunto("Actividad modificada: " + actividad.getNombre());
			mensaje.setCuerpoMensaje("La actividad ha sido modificada. Consulta nueva información en nuestra web");
			mensaje.setLeido(false);
			
			mensajesRepository.save(mensaje);
		}
		
		actividadesConverter.actualizarModeloActividad(actividad, actividadVO);
		actividadesRepository.save(actividad);
		
	}

}
