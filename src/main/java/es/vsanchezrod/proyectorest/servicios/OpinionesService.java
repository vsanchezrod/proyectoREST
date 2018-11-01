package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

public interface OpinionesService {

	void guardarOpinion(OpinionVO opinionVO);
	
	List<OpinionVO> obtenerListaOpinionesVO();
	
	void borrarOpinion(String id);
	
	TotalVO obtenerNumeroOpiniones();
}
