package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.ViajesRepository;
import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ViajesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@Service
public class ViajesServiceImpl implements ViajesService {

	@Autowired
	private ViajesConverter viajesConverter;
	
	@Autowired
	private ViajesRepository viajesRepository;
	
	@Override
	public List<ViajeVO> obtenerListaViajesVO() {
		
		return this.viajesConverter.convertirListaViajessAListaViajesVO(this.viajesRepository.findAll());
	}

	@Override
	public void crearViaje(ViajeVO viajeVO) {
		
		this.viajesRepository.save(this.viajesConverter.convertirViajeVOAViaje(viajeVO));
		
	}

}
