package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@RestController
public class ViajesRest {

	/*@RequestMapping(value = "/public/viajes", method = RequestMethod.GET)
	public List<ViajeVO> obtenerListaViajesVO() {
		
		List<ViajeVO> listaViajes = new ArrayList<ViajeVO>();
				
		listaViajes.add(new ViajeVO("1", "Pirineos", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		listaViajes.add(new ViajeVO("2", "Mediterraneo", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		listaViajes.add(new ViajeVO("3", "El Escorial", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		listaViajes.add(new ViajeVO("4", "Navalcarnero", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		listaViajes.add(new ViajeVO("5", "Brunete", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		
		return listaViajes;
	}*/
	
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
	
	
}
