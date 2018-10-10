package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.ActividadesService;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;

@RestController
public class ActividadesRest {
	
	@Autowired
	private ActividadesService actividadesService;

	@RequestMapping(value = "public/actividades", method = RequestMethod.GET)
	public List<ActividadVO> obtenerListaActividadesVO(){
		
		return actividadesService.obtenerListaActividadesVO();
	}
	
	@RequestMapping(value = "public/actividades", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void crearActividadVO(@RequestBody ActividadVO actividadVO) {
		
		actividadesService.crearActividad(actividadVO);
	}
	
	
	
}
