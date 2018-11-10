package es.vsanchezrod.proyectorest.servicios;

import java.util.List;
import java.util.Map;

import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

public interface ViajesService {

	List<ViajeVO> obtenerListaViajes(Map<String, String> queryParams);
	
	void crearViaje (ViajeVO viaje);	
	
	List<ViajeVO> obtenerListaViajesConQueryParam(Map<String, String> queryParams);
	
	TotalVO obtenerNumeroViajes();
	
	void borrarViaje(String id, String motivo, String idUsuarioBorradorViaje);
	
	ViajeVO obtenerViaje(String id);
}
