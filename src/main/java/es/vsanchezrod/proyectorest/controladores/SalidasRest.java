package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.SalidasService;
import es.vsanchezrod.proyectorest.servicios.vo.SalidaVO;

@RestController
public class SalidasRest {

	@Autowired
	private SalidasService salidasService;

	@RequestMapping(value = "/public/salidas", method = RequestMethod.GET)
	public List<SalidaVO> obtenerListaSalidasVO () {
		
		return salidasService.obteneroSalidasVO();
	}

	@RequestMapping(value = "/public/salidas", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	// @ResponseStatus: para que de más información a parte del 200OK
	// @RequestBody: datos dentro del body de la petición HTTP
	public void crearSalida(@RequestBody SalidaVO salidaVO) {
		
		salidasService.crearSalida(salidaVO);
	}
	
}
