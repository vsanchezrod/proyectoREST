package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.InteresVO;

public interface InteresesService {
	
	void crearInteres(InteresVO interesVO);
	
	List<InteresVO> obtenerListaInteresesVO();
}
