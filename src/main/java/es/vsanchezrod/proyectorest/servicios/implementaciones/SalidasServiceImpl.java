package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.SalidasRepository;
import es.vsanchezrod.proyectorest.servicios.SalidasService;
import es.vsanchezrod.proyectorest.servicios.conversores.SalidasConverter;
import es.vsanchezrod.proyectorest.servicios.vo.SalidaVO;


@Service
public class SalidasServiceImpl implements SalidasService{

	@Autowired
	private SalidasConverter salidasConverter;
	
	@Autowired
	private SalidasRepository salidasRepository;
	
	@Override
	public void crearSalida(SalidaVO salidaVO) {
		salidasRepository.save(salidasConverter.convertirSalidaVOASalida(salidaVO));
	}

	@Override
	public List<SalidaVO> obteneroSalidasVO() {
		
		return salidasConverter.convertirListaSalidasAListaSalidasVO((salidasRepository.findAll()));
	}

}
