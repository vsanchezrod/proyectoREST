package es.vsanchezrod.proyectorest.servicios.conversores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Interes;
import es.vsanchezrod.proyectorest.servicios.vo.InteresVO;

@Component
public class InteresesConverter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InteresesConverter.class);
	
	public InteresesConverter() {
		
		LOGGER.info("Constructor: InteresesConverter");
	}

	public Interes convertirInteresVOAInteres(InteresVO interesVO) {
		return new Interes(interesVO.getId(), interesVO.getNombre(), interesVO.getDescripcion());
	}
	
}
