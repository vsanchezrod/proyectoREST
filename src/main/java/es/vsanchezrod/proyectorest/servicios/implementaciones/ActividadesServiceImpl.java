package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.ActividadesRepository;
import es.vsanchezrod.proyectorest.servicios.ActividadesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ActividadesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;

@Service
public class ActividadesServiceImpl implements ActividadesService {

	@Autowired
	private ActividadesConverter actividadesConverter;
	
	@Autowired
	private ActividadesRepository actividadesRepository;
		
	@Override
	public void crearActividad(ActividadVO actividadVO) {
		
		actividadesRepository.save(this.actividadesConverter.convertirActividadVOAActividad(actividadVO));
		
	}

	@Override
	public List<ActividadVO> obtenerListaActividadesVO() {
		
		return actividadesConverter.convetirListaActividadesAListaActividadesVO(this.actividadesRepository.findAll());
	}

	@Override
	public void borrarActividad(String id) {
		
		actividadesRepository.delete(id);
		
	}

}
