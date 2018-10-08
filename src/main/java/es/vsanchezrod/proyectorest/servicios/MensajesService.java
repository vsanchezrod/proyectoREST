package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.MensajeVO;

public interface MensajesService {

	List<MensajeVO> obtenerMensajesVO();
	
	void crearMensaje(MensajeVO mensajeVO);
		
}
