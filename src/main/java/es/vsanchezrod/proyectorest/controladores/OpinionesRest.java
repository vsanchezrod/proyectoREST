package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.OpinionesService;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

@RestController
public class OpinionesRest {
	
	@Autowired
	private OpinionesService opinionesService; 
	
	@RequestMapping(value = "/opiniones", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('usuario')")
	@ResponseStatus(HttpStatus.CREATED)
	public void guardarOpinion(@RequestBody OpinionVO opinionVO) {
	
		opinionesService.guardarOpinion(opinionVO);
	}
	
	@RequestMapping(value = "/public/opiniones", method = RequestMethod.GET)
	public List<OpinionVO> obtenerOpiniones(){
		return opinionesService.obtenerListaOpinionesVO();
	}
	
	@RequestMapping(value = "/opiniones/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('administrador')")
	public void borrarOpinion(@PathVariable("id") String id) {
		opinionesService.borrarOpinion(id);
	}
	
	@RequestMapping(value = "/opiniones/numero", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('administrador')")
	public TotalVO obtenerNumeroUsuarios() {
		return opinionesService.obtenerNumeroOpiniones();
	}
	
}
