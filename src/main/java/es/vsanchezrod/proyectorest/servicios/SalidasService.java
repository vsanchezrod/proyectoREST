package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.SalidaVO;

public interface SalidasService {

	void crearSalida(SalidaVO salidaVO);
	
	List<SalidaVO> obteneroSalidasVO();
}
