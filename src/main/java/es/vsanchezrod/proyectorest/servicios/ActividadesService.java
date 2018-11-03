package es.vsanchezrod.proyectorest.servicios;

import java.util.List;
import java.util.Map;

import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

public interface ActividadesService {

	void crearActividad(ActividadVO actividadVO);
	
	List<ActividadVO> obtenerListaActividades(Map<String, String> queryParams);
	
	void borrarActividad(String id);
	
	List<ActividadVO> obtenerListaActividadesConQueryParam(Map<String, String> queryParams);
	
	TotalVO obtenerNumeroActividades();
}
