package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

public interface ViajesService {

	List<ViajeVO> obtenerListaViajesVO ();
	
	void crearViaje (ViajeVO viaje);	
}
