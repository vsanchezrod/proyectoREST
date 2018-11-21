	package es.vsanchezrod.proyectorest.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.controladores.componentes.AuthorizationUtilComponent;
import es.vsanchezrod.proyectorest.servicios.ActividadesService;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;
import es.vsanchezrod.proyectorest.servicios.vo.NuevoParticipanteVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

@RestController
public class ActividadesRest {
	
	@Autowired
	private ActividadesService actividadesService;
	
	@Autowired
	private AuthorizationUtilComponent authorizationUtilComponent;

	@RequestMapping(value = "/public/actividades", method = RequestMethod.GET)
	public List<ActividadVO> obtenerListaActividades(@RequestParam Map<String, String> queryParams){
		return actividadesService.obtenerListaActividades(queryParams);
	}
	
	@RequestMapping(value = "/public/actividades/{id}", method = RequestMethod.GET)
	public ActividadVO obtenerActividad(@PathVariable("id") String id) {
		return actividadesService.obtenerActividad(id);
	}
	
	@RequestMapping(value = "/actividades", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('usuario')")
	public void crearActividadVO(@RequestBody ActividadVO actividadVO) {
		actividadesService.crearActividad(actividadVO);
	}
	
	@RequestMapping(value = "/actividades/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('usuario') OR hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.OK)
	public void borrarActividad(@PathVariable("id") String idActividad,  @RequestHeader("X-Motivo") String motivo, @RequestHeader("Authorization") String token) {
		
		final String idUsuarioBorradorActividad = authorizationUtilComponent.obtenerUserName(token);
		actividadesService.borrarActividad(idActividad, motivo, idUsuarioBorradorActividad);
	}
	
	@RequestMapping(value = "/actividades", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('usuario') OR hasAuthority('administrador')")
	public List<ActividadVO> obtenerListaActividadesConQueryParam(@RequestParam Map<String, String> queryParams) {
		// Se delega a la capa de negocio el valorar que queryParam recibe
		return actividadesService.obtenerListaActividadesConQueryParam(queryParams);
	}
	
	@RequestMapping(value = "/actividades/numero", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('administrador')")
	public TotalVO obtenerNumeroActividades() {
		return actividadesService.obtenerNumeroActividades();
	}
	
	@RequestMapping(value = "/actividades/{id}/participantes", method = RequestMethod.PUT)
	@PreAuthorize("hasAuthority('usuario') OR hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void actualizarParticipantesActividad(@PathVariable("id") String idActividad, @RequestBody NuevoParticipanteVO nuevoParticipanteVO ) {
		actividadesService.actualizarParticipantesActividad(idActividad, nuevoParticipanteVO);
	}
	
	@RequestMapping(value = "/actividades/{id}", method = RequestMethod.PATCH)
	@PreAuthorize("hasAuthority('usuario') OR hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void actualizarActividad(@PathVariable("id") String idActividad, @RequestBody ActividadVO actividadVO) {
		actividadesService.editarActividad(idActividad, actividadVO);
	}
	
}

