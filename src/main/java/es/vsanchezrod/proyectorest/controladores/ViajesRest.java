package es.vsanchezrod.proyectorest.controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@RestController
public class ViajesRest {

	@Autowired
	private ViajesService viajesService;
	
	
	@RequestMapping(value = "/public/viajes", method = RequestMethod.GET)
	public List<ViajeVO> obtenerListaViajes(@RequestParam Map<String, String> queryParams) {
		return this.viajesService.obtenerListaViajes(queryParams);
	}
	
	@RequestMapping(value = "/public/viajes", method = RequestMethod.POST)
	public void crearViaje(@RequestBody ViajeVO viajeVO) {
		this.viajesService.crearViaje(viajeVO);
	}
	
	@RequestMapping(value = "/viajes/numero", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('administrador')")
	public TotalVO obtenerNumeroViajes() {
		return viajesService.obtenerNumeroViajes();
	}
}
