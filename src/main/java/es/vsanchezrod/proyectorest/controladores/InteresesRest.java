package es.vsanchezrod.proyectorest.controladores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.persistencia.modelos.Interes;
import es.vsanchezrod.proyectorest.servicios.InteresesService;
import es.vsanchezrod.proyectorest.servicios.vo.InteresVO;

@RestController
public class InteresesRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(InteresesRest.class);
	
	@Autowired
	private InteresesService interesesService;
	
	public InteresesRest() {
		LOGGER.info("Constructor: InteresesRest");
	}
	
	@RequestMapping(value = "/public/intereses", method = RequestMethod.GET)
	public List<Interes> obtenerIntereses () {
		List<Interes> intereses = new ArrayList<Interes>();
		
		/*intereses.add(new Interes(1, "Mountain Bike", "Rutas de ciclismo Mountain Bike"));
		intereses.add(new Interes(2, "Ciclismo de carretera", "Rutas por carretera"));
		intereses.add(new Interes(3, "Viajes", "Viajes de aventura y deporte"));
		intereses.add(new Interes(4, "Paseo con perros", "Paseos con perros por ciudad"));*/
				
		return intereses;
	}
	
	@RequestMapping(value = "/public/intereses", method = RequestMethod.POST)
	public void crearInteres() {
		final InteresVO interesVO = new InteresVO(null, "Mountain Bike", "Montaña");
		interesesService.crearInteres(interesVO);
	}
	
	
}
