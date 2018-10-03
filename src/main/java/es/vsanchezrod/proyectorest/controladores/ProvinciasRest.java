package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.ProvinciasService;
import es.vsanchezrod.proyectorest.servicios.vo.ProvinciaVO;

@RestController
public class ProvinciasRest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProvinciasRest.class);
	
	@Autowired
	private ProvinciasService provinciasService;
	
	public ProvinciasRest() {
		LOGGER.info("Constructor: ProvinciasRest");
	}

	@RequestMapping(value = "/public/provincias", method = RequestMethod.GET)
	public List<ProvinciaVO> obtenerProvincias() {
		
		return provinciasService.obtenerListaProvincias();
	}
}
