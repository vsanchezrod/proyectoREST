package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@RestController
public class ViajesRest {

	@Autowired
	private ViajesService viajesService;
	
	
	@RequestMapping(value = "/public/viajes", method = RequestMethod.GET)
	public List<ViajeVO> obtenerListaViajesVO() {
		
		return this.viajesService.obtenerListaViajesVO();
	
	}
	
	@RequestMapping(value = "/public/viajes", method = RequestMethod.POST)
	public void crearViaje(@RequestBody ViajeVO viajeVO) {
		
		this.viajesService.crearViaje(viajeVO);
	}
	
	@RequestMapping(value = "/viajes", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('administrador')")
	public long obtenerNumeroViajes() {
		
		return viajesService.obtenerNumeroViajes();
	}
}
