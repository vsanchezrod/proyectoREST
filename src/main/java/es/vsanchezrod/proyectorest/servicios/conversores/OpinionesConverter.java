package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Opinion;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;

@Component
public class OpinionesConverter {

	public Opinion convertirOpinionVOAOpinion(OpinionVO opinionVO) {

		return new Opinion(
				opinionVO.getId(),
				opinionVO.getActividad(),
				opinionVO.getTitulo(),
				opinionVO.getDetalle(),
				opinionVO.getOrganizacionValoracion(),
				opinionVO.getAmbienteValoracion(),
				opinionVO.getRecorridoValoracion());

	}
	
	public OpinionVO convertirOpinionAOpinionVO(Opinion opinion) {

		return new OpinionVO(
				opinion.getId(),
				opinion.getActividad(), 
				opinion.getTitulo(), 
				opinion.getDetalle(),
				opinion.getOrganizacionValoracion(),
				opinion.getAmbienteValoracion(),
				opinion.getRecorridoValoracion());

	}
	
	public List<OpinionVO> convertirListaOpinionesAListaOpinionesVO(List<Opinion> listaOpiniones){
		
		List<OpinionVO> listaOpinionesVO = new ArrayList<OpinionVO>();
		
		for (Opinion opinion: listaOpiniones) {
			listaOpinionesVO.add(convertirOpinionAOpinionVO(opinion));
		}
		
		return listaOpinionesVO;
		
	}
}
