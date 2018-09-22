package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public List<InteresVO> obtenerIntereses () {
		
		return interesesService.obtenerIntereses();
	}
	
	@RequestMapping(value = "/public/intereses", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	// @RequestBody es para decirle que los datos van dentro del body de la petición HTTP
	public void crearInteres(@RequestBody InteresVO interesVO) {
		interesesService.crearInteres(interesVO);
	}
	
}
