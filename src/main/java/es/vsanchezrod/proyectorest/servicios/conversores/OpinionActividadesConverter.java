package es.vsanchezrod.proyectorest.servicios.conversores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.OpinionActividad;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionActividadVO;

@Component
public class OpinionActividadesConverter {

	@Autowired
	private ActividadCategoriasConverter actividadCategoriasConverter;
	
	public OpinionActividadVO convertirOpinionActividadAOpinionActividadVO(OpinionActividad opinionActividad) {
		
		OpinionActividadVO opinionActividadVO = new OpinionActividadVO();
		
		opinionActividadVO.setId(opinionActividad.getId());
		opinionActividadVO.setNombre(opinionActividad.getNombre());
		opinionActividadVO.setCategorias(this.actividadCategoriasConverter.convertirListaActividadCategoriasAListaActividadCategoriasVO(opinionActividad.getCategorias()));
		
		
		return opinionActividadVO;
	}
	
	public OpinionActividad convertirOpinionActividadVOAOpinionActividad(OpinionActividadVO opinionActividadVO) {
		
		OpinionActividad opinionActividad = new OpinionActividad();
		
		opinionActividad.setId(opinionActividadVO.getId());
		opinionActividad.setNombre(opinionActividadVO.getNombre());
		opinionActividad.setCategorias(this.actividadCategoriasConverter.convertirListaActividadCategoriasVOAListaActividadCategorias(opinionActividadVO.getCategorias()));
		
		
		return opinionActividad;
	}
	
}
