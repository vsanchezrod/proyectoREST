package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Opinion;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;

@Component
public class OpinionesConverter {
	
	@Autowired
	private OpinionActividadesConverter opinionActividadesConverter;
	
	public Opinion convertirOpinionVOAOpinion(OpinionVO opinionVO) {

		Opinion opinion = new Opinion();
		
		opinion.setId(opinionVO.getId());
		opinion.setActividad(this.opinionActividadesConverter.convertirOpinionActividadVOAOpinionActividad(opinionVO.getActividad()));
		opinion.setTitulo(opinionVO.getTitulo());
		opinion.setDetalle(opinionVO.getDetalle());
		opinion.setFecha(opinionVO.getFecha());
		opinion.setOrganizacionValoracion(opinionVO.getOrganizacionValoracion());
		opinion.setAmbienteValoracion(opinionVO.getAmbienteValoracion());
		opinion.setRecorridoValoracion(opinionVO.getRecorridoValoracion());
		opinion.setUsuarioOpinion(opinionVO.getUsuarioOpinion());
	
		return opinion;

	}
	
	public OpinionVO convertirOpinionAOpinionVO(Opinion opinion) {

		OpinionVO opinionVO = new OpinionVO();
		
		opinionVO.setId(opinion.getId());
		opinionVO.setActividad(this.opinionActividadesConverter.convertirOpinionActividadAOpinionActividadVO(opinion.getActividad()));
		opinionVO.setTitulo(opinion.getTitulo());
		opinionVO.setDetalle(opinion.getDetalle());
		opinionVO.setFecha(opinion.getFecha());
		opinionVO.setOrganizacionValoracion(opinion.getOrganizacionValoracion());
		opinionVO.setAmbienteValoracion(opinion.getAmbienteValoracion());
		opinionVO.setRecorridoValoracion(opinion.getRecorridoValoracion());
		opinionVO.setUsuarioOpinion(opinion.getUsuarioOpinion());
			
		return opinionVO;

	}
	
	public List<OpinionVO> convertirListaOpinionesAListaOpinionesVO(List<Opinion> listaOpiniones){
		
		List<OpinionVO> listaOpinionesVO = new ArrayList<OpinionVO>();
		
		for (Opinion opinion: listaOpiniones) {
			listaOpinionesVO.add(convertirOpinionAOpinionVO(opinion));
		}
		
		return listaOpinionesVO;
		
	}
}
