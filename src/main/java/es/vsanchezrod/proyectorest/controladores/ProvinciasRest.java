package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.ProvinciasService;
import es.vsanchezrod.proyectorest.servicios.implementaciones.ProvinciasServiceImpl;
import es.vsanchezrod.proyectorest.servicios.vo.ProvinciaVO;

@RestController
public class ProvinciasRest {
	
	private ProvinciasService provinciasService;
	
	public ProvinciasRest() {
		provinciasService = new ProvinciasServiceImpl();
	}

	@RequestMapping(value = "/public/provincias", method = RequestMethod.GET)
	public List<ProvinciaVO> obtenerProvincias() {
		
		return provinciasService.obtenerProvincias();
			

	}
	
	
}
