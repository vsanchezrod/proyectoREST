package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadVO;

@Component
public class ActividadesConverter {

	@Autowired
	private ActividadCategoriasConverter actividadCategoriasConverter;
	
	public Actividad convertirActividadVOAActividad(ActividadVO actividadVO) {
		Actividad actividad = new Actividad();
		
		actividad.setId(actividadVO.getId());
		actividad.setNombre(actividadVO.getNombre());
		actividad.setCategorias(
				this.actividadCategoriasConverter.convertirListaActividadCategoriasVOAListaActividadCategorias(actividadVO.getCategorias()));
		actividad.setDescripcion(actividadVO.getDescripcion());
		actividad.setNivel(actividadVO.getNivel());
		actividad.setDistancia(actividadVO.getDistancia());
		actividad.setFechaInicio(actividadVO.getFechaInicio());
		actividad.setImagen(actividadVO.getImagen());
		actividad.setCoordenadas(actividadVO.getCoordenadas());
		actividad.setIdUsuarioCreacion(actividadVO.getIdUsuarioCreacion());
		actividad.setListaParticipantes(actividadVO.getListaParticipantes());
		actividad.setPuntuacion(actividadVO.getPuntuacion());
		
		return actividad;
				
	}
	
	public ActividadVO convertirActividadAActividadVO(Actividad actividad) {
		ActividadVO actividadVO = new ActividadVO();
		
		actividadVO.setId(actividad.getId());
		actividadVO.setNombre(actividad.getNombre());
		actividadVO.setCategorias(
				this.actividadCategoriasConverter.convertirListaActividadCategoriasAListaActividadCategoriasVO(actividad.getCategorias()));
		actividadVO.setDescripcion(actividad.getDescripcion());
		actividadVO.setNivel(actividad.getNivel());
		actividadVO.setDistancia(actividad.getDistancia());
		actividadVO.setFechaInicio(actividad.getFechaInicio());
		actividadVO.setImagen(actividad.getImagen());
		actividadVO.setCoordenadas(actividad.getCoordenadas());
		actividadVO.setIdUsuarioCreacion(actividad.getIdUsuarioCreacion());
		actividadVO.setListaParticipantes(actividad.getListaParticipantes());
		actividadVO.setPuntuacion(actividad.getPuntuacion());
		
		return actividadVO;
				
	}
	
	public List<ActividadVO> convetirListaActividadesAListaActividadesVO(List<Actividad> listaActividades) {
		
		List<ActividadVO> listaActividadesVO = new ArrayList<>();
		
		for(Actividad actividad: listaActividades) {
			listaActividadesVO.add(this.convertirActividadAActividadVO(actividad));
		}
				
		return listaActividadesVO;
			
	}

}
