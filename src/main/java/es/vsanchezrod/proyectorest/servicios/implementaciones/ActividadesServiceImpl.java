package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.ActividadesRepository;
import es.vsanchezrod.proyectorest.servicios.ActividadesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ActividadesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

@Service
public class ActividadesServiceImpl implements ActividadesService {

	@Autowired
	private ActividadesConverter actividadesConverter;
	
	@Autowired
	private ActividadesRepository actividadesRepository;
		
	@Override
	public void crearActividad(ActividadVO actividadVO) {
		actividadesRepository.save(actividadesConverter.convertirActividadVOAActividad(actividadVO));
	}

	@Override
	public List<ActividadVO> obtenerListaActividadesVO() {
		return actividadesConverter.convetirListaActividadesAListaActividadesVO(actividadesRepository.findAll());
	}

	@Override
	public void borrarActividad(String id) {
		actividadesRepository.deleteById(id);
	}

	@Override
	public List<ActividadVO> obtenerListaActividadesVOCreadasPorUsuario(String id) {

		return actividadesConverter.convetirListaActividadesAListaActividadesVO(
				actividadesRepository.findByIdUsuarioCreacion(id));
	}

	@Override
	public TotalVO obtenerNumeroActividades() {
		
		final TotalVO totalVO = new TotalVO();
		totalVO.setTotal(actividadesRepository.count());
		return totalVO;
		
	}

}
