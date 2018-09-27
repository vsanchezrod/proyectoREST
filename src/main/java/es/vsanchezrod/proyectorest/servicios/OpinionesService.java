package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;

public interface OpinionesService {

	void guardarOpinion(OpinionVO opinionVO);
	
	List<OpinionVO> obtenerOpiniones();
}
