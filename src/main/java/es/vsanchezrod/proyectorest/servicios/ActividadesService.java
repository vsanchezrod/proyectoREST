package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

public interface ActividadesService {

	void crearActividad(ActividadVO actividadVO);
	
	List<ActividadVO> obtenerListaActividadesVO();
	
	void borrarActividad(String id);
	
	List<ActividadVO> obtenerListaActividadesVOCreadasPorUsuario(String id);
	
	TotalVO obtenerNumeroActividades();
}
