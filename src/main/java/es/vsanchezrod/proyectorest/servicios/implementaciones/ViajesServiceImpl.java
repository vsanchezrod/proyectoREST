package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;
import es.vsanchezrod.proyectorest.persistencia.repositorios.ViajesRepository;
import es.vsanchezrod.proyectorest.servicios.ViajesService;
import es.vsanchezrod.proyectorest.servicios.conversores.ViajesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@Service
public class ViajesServiceImpl implements ViajesService {

	@Autowired
	private ViajesConverter viajesConverter;
	
	@Autowired
	private ViajesRepository viajesRepository;
	
	@Override
	public List<ViajeVO> obtenerListaViajes(Map<String, String> queryParams) {
		
		List<Viaje> listaViajes = new ArrayList<>();
		
		if(queryParams.containsKey("realizadas") && (BooleanUtils.toBoolean(queryParams.get("realizadas")) == true)) {
			listaViajes = viajesRepository.findByFechaInicioLessThanOrderByFechaInicioDesc(new Date());
		}
		else {
			listaViajes = viajesRepository.findByFechaInicioGreaterThanOrderByFechaInicioAsc(new Date());
		}
		return this.viajesConverter.convertirListaViajessAListaViajesVO(listaViajes);
	}

	@Override
	public void crearViaje(ViajeVO viajeVO) {
		this.viajesRepository.save(this.viajesConverter.convertirViajeVOAViaje(viajeVO));
	}

	@Override
	public TotalVO obtenerNumeroViajes() {
		final TotalVO totalVO = new TotalVO();
		totalVO.setTotal(viajesRepository.count());
		return totalVO;
	}

}
