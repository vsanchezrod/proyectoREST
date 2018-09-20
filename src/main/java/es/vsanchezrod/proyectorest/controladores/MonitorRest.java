package es.vsanchezrod.proyectorest.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitorRest {

	@RequestMapping(value = "monitor", method = RequestMethod.GET)
	public String obtenerEstado() {
		return "Estado";
	}
	
	
	
	
	
}
