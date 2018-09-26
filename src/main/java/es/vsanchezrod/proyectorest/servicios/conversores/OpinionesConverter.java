package es.vsanchezrod.proyectorest.servicios.conversores;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Opinion;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;

@Component
public class OpinionesConverter {

	public Opinion convertirOpinionVOAOpinion(OpinionVO opinionVO) {

		return new Opinion(opinionVO.getActividad(), opinionVO.getTitulo(), opinionVO.getDetalle(),
						   opinionVO.getOrganizacionValoracion(), opinionVO.getAmbienteValoracion(),
						   opinionVO.getRecorridoValoracion());

	}
	
	public OpinionVO convertirOpinionAOpinionVO(Opinion opinion) {

		return new OpinionVO(opinion.getActividad(), opinion.getTitulo(), opinion.getDetalle(),
						   opinion.getOrganizacionValoracion(), opinion.getAmbienteValoracion(),
						   opinion.getRecorridoValoracion());

	}
}
