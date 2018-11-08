package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.MensajeVO;

public interface MensajesService {

	List<MensajeVO> obtenerMensajesVO(String id);
	
	void crearMensaje(MensajeVO mensajeVO);
	
	void borrarMensaje(String id);
	
	void actualizarMensaje(String id, MensajeVO mensajeVO);
	

}
