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
import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;
import es.vsanchezrod.proyectorest.persistencia.repositorios.MensajesRepository;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;
import es.vsanchezrod.proyectorest.persistencia.repositorios.ViajesRepository;
import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ViajesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.NuevoParticipanteVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@Service
public class ViajesServiceImpl implements ViajesService {

	@Autowired
	private ViajesConverter viajesConverter;
	
	@Autowired
	private ViajesRepository viajesRepository;
	
	@Autowired
	private MensajesRepository mensajesRepository;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	public void crearViaje(ViajeVO viajeVO) {
		this.viajesRepository.save(this.viajesConverter.convertirViajeVOAViaje(viajeVO));
	}
	

	@Override
	public ViajeVO obtenerViaje(String id) {
		
		Viaje viaje = viajesRepository.findById(id);
		return viajesConverter.convertirViajeAViajeVO(viaje);
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
	public void borrarViaje(String id, String motivo, String idUsuarioBorradorViaje) {
		Viaje viaje = viajesRepository.findById(id);
		
		for (String idUsuarioReceptor: viaje.getListaParticipantes()) {
			Mensaje mensaje = new Mensaje();
			mensaje.setIdUsuarioEmisor(idUsuarioBorradorViaje);
			mensaje.setIdUsuarioReceptor(idUsuarioReceptor);
			mensaje.setFecha(new Date());
			mensaje.setAsunto("Viaje Cancelado: " + viaje.getNombre());
			mensaje.setCuerpoMensaje("Cancelado por: " + motivo);
			mensaje.setLeido(false);
			
			mensajesRepository.save(mensaje);
		}
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
		
		if(queryParams.containsKey("participante")) {
			
			if(queryParams.containsKey("participante") && queryParams.containsKey("realizadas")) {
				
				if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == true) {
					listaViajes = viajesRepository.findByListaParticipantesAndFechaInicioLessThanOrderByFechaInicioDesc(queryParams.get("participante"), new Date());
				}
				
				if (BooleanUtils.toBoolean(queryParams.get("realizadas")) == false) {
					listaViajes = viajesRepository.findByListaParticipantesAndFechaInicioGreaterThanOrderByFechaInicioAsc(queryParams.get("participante"), new Date());
				}
			}
			
			else {
				listaViajes = viajesRepository.findByListaParticipantes(queryParams.get("participante"));
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
		viajeQuery.setPrecio(null);
		viajeQuery.setPlazas(null);
				
		if(queryParams.containsKey("creador")) {
			viajeQuery.setIdUsuarioCreacion(queryParams.get("creador"));
		}
		
		final Example<Viaje> exampleViaje = Example.of(viajeQuery, viajeMatcher);
		return exampleViaje;
	}


	@Override
	public void actualizarViaje(String idViaje, NuevoParticipanteVO nuevoParticipanteVO) {
		
		final Viaje viaje = viajesRepository.findById(idViaje);
		if (viaje == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "El viaje no existe.");
		}
		
		final Usuario usuario = usuariosRepository.findById(nuevoParticipanteVO.getIdParticipante());
		
		if (usuario == null) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "El usuario no existe" );
		}
		
		final List<String> listaParticipantesViaje = viaje.getListaParticipantes();
		if (listaParticipantesViaje.contains(nuevoParticipanteVO.getIdParticipante())) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Participante ya inscrito");
		}
		
		final Integer plazasViaje = viaje.getPlazas();
		if (listaParticipantesViaje.size() >= plazasViaje) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "El viaje no tiene plazas");
		}
		
		listaParticipantesViaje.add(nuevoParticipanteVO.getIdParticipante());
		viaje.setListaParticipantes(listaParticipantesViaje);
		viajesRepository.save(viaje);
		
	}


}
