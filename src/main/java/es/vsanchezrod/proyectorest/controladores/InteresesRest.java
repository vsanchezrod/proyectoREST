package es.vsanchezrod.proyectorest.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.persistencia.modelos.Interes;

@RestController
public class InteresesRest {

	@RequestMapping(value = "/public/intereses", method = RequestMethod.GET)
	public List<Interes> obtenerIntereses () {
		List<Interes> intereses = new ArrayList<Interes>();
		
		intereses.add(new Interes(1, "Mountain Bike", "Rutas de ciclismo Mountain Bike"));
		intereses.add(new Interes(2, "Ciclismo de carretera", "Rutas por carretera"));
		intereses.add(new Interes(3, "Viajes", "Viajes de aventura y deporte"));
		intereses.add(new Interes(4, "Paseo con perros", "Paseos con perros por ciudad"));
				
		return intereses;
	}
	
	
}
