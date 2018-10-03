package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

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
	
	public InteresVO convertirInteresAInteresVO(Interes interes) {
		return new InteresVO(interes.getId(), interes.getNombre(), interes.getDescripcion());
	}
	
	public List<InteresVO> convertirListaInteresesAListaInteresesVO(List<Interes> intereses) {
		List<InteresVO> listaInteresesVO = new ArrayList<InteresVO>();
		
		for (Interes interes : intereses ) {
			listaInteresesVO.add(convertirInteresAInteresVO(interes));
		}
		
		return listaInteresesVO;
	}
	
	public List<Interes> convertirListaInteresesVOAListaIntereses(List<InteresVO> interesesVO) {
		List<Interes> listaIntereses = new ArrayList<Interes>();
		
		for (InteresVO interesVO : interesesVO ) {
			listaIntereses.add(convertirInteresVOAInteres(interesVO));
		}
		
		return listaIntereses;
	}
	
}
