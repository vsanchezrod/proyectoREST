package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;

public interface ActividadesService {

	void crearActividad(ActividadVO actividadVO);
	
	List<ActividadVO> obtenerListaActividadesVO();
	
	void borrarActividad(String id);
	
	List<ActividadVO> obtenerListaActividadesVOCreadasPorUsuario(String id);
	
	long obtenerNumeroActividades();
}
