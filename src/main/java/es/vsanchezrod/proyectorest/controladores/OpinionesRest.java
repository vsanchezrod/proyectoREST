package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.OpinionesService;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;

@RestController
public class OpinionesRest {
	
	@Autowired
	private OpinionesService opinionesService; 
	
	@RequestMapping(value = "/public/opiniones", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void guardarOpinion(@RequestBody OpinionVO opinionVO) {
	
		opinionesService.guardarOpinion(opinionVO);
	}
	
	@RequestMapping(value = "/public/opiniones", method = RequestMethod.GET)
	public List<OpinionVO> obtenerOpiniones(){
		
		return opinionesService.obtenerOpiniones();
	}
	
	
	
}
