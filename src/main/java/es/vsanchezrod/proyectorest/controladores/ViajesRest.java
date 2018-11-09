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
import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@RestController
public class ViajesRest {

	@Autowired
	private ViajesService viajesService;
	
	@Autowired
	private AuthorizationUtilComponent authorizationUtilComponent;
	
	@RequestMapping(value = "/public/viajes", method = RequestMethod.GET)
	public List<ViajeVO> obtenerListaViajes(@RequestParam Map<String, String> queryParams) {
		return viajesService.obtenerListaViajes(queryParams);
	}
	
	@RequestMapping(value = "/viajes", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('administrador')")
	public void crearViaje(@RequestBody ViajeVO viajeVO) {
		viajesService.crearViaje(viajeVO);
	}
	
	@RequestMapping(value = "/viajes/numero", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('administrador')")
	public TotalVO obtenerNumeroViajes() {
		return viajesService.obtenerNumeroViajes();
	}
	
	@RequestMapping(value = "/viajes", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('usuario') OR hasAuthority('administrador')")
	public List<ViajeVO> obtenerListaActividadesConQueryParam(@RequestParam Map<String, String> queryParams) {
		
		// Se delega a la capa de negocio el valorar que queryParam recibe
		return viajesService.obtenerListaViajesConQueryParam(queryParams);
	}
	
	@RequestMapping(value = "/viajes/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.OK)
	public void borrarActividad(@PathVariable("id") String id, @RequestHeader("X-Motivo") String motivo, @RequestHeader("Authorization") String token) {
		
		final String idUsuarioBorradorViaje = authorizationUtilComponent.obtenerUserName(token);
		viajesService.borrarViaje(id, motivo, idUsuarioBorradorViaje);
	}
}
