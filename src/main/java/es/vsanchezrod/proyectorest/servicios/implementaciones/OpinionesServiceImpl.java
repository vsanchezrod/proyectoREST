package es.vsanchezrod.proyectorest.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.OpinionesRepository;
import es.vsanchezrod.proyectorest.servicios.OpinionesService;
import es.vsanchezrod.proyectorest.servicios.conversores.OpinionesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;

@Service
public class OpinionesServiceImpl implements OpinionesService {

	@Autowired
	private OpinionesConverter opinionesConverter;
	
	@Autowired
	private OpinionesRepository opinionesRepository;
	
	@Override
	public void guardarOpinion(OpinionVO opinionVO) {
		opinionesRepository.save(opinionesConverter.convertirOpinionVOAOpinion(opinionVO));
		
	}

}
