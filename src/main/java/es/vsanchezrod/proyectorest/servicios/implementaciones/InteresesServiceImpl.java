package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.InteresesRepository;
import es.vsanchezrod.proyectorest.servicios.InteresesService;
import es.vsanchezrod.proyectorest.servicios.conversores.InteresesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.InteresVO;

@Service
public class InteresesServiceImpl implements InteresesService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(InteresesServiceImpl.class);

	@Autowired
	private InteresesConverter interesesConverter;
	
	@Autowired
	private InteresesRepository interesesRepository;
	
	public InteresesServiceImpl() {
		
		LOGGER.info("Constructor: InteresesServiceImpl");
	}
	
	@Override
	public void crearInteres(InteresVO interesVO) {
		
		// Guarda en la base de datos el InteresVO convertirdo en Interes
		this.interesesRepository.save(interesesConverter.convertirInteresVOAInteres(interesVO));
	}

	@Override
	public List<InteresVO> obtenerListaInteresesVO() {
		// Recupera de la base de datos una lista de intereses y la convierte a InteresVO
		
		return this.interesesConverter.convertirListaInteresesAListaInteresesVO((interesesRepository.findAll()));
	}

}
