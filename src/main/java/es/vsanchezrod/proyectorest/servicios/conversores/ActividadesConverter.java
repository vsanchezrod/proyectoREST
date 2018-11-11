package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Actividad;
import es.vsanchezrod.proyectorest.persistencia.modelos.ActividadCategoria;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadCategoriaVO;
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
				actividadCategoriasConverter.convertirListaActividadCategoriasVOAListaActividadCategorias(actividadVO.getCategorias()));
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
				actividadCategoriasConverter.convertirListaActividadCategoriasAListaActividadCategoriasVO(actividad.getCategorias()));
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
	
	public void actualizarModeloActividad(Actividad actividad, ActividadVO actividadVO) {
		
		if(StringUtils.isNoneBlank(actividadVO.getNombre())) {
			final String nombre = WordUtils.capitalizeFully(StringUtils.trim(actividadVO.getNombre()));
			actividad.setNombre(nombre);
		}
		
		if(!actividadVO.getCategorias().isEmpty()) {
			final List<ActividadCategoriaVO> categoriasVO = actividadVO.getCategorias();
			final List<ActividadCategoria> categorias = actividadCategoriasConverter.convertirListaActividadCategoriasVOAListaActividadCategorias(categoriasVO);
			actividad.setCategorias(categorias);
		}
		
		if(StringUtils.isNoneBlank(actividadVO.getDescripcion())) {
			final String descripcion = WordUtils.capitalizeFully(StringUtils.trim(actividadVO.getDescripcion()));
			actividad.setDescripcion(descripcion);
		}
		
		if(actividadVO.getNivel() != null) {
			actividad.setNivel(actividadVO.getNivel());
		}
		
		if(actividadVO.getDistancia() != null) {
			actividad.setDistancia(actividadVO.getDistancia());
		}
		
		if(actividadVO.getFechaInicio() != null) {
			actividad.setFechaInicio(actividadVO.getFechaInicio());
		}
		
		if(StringUtils.isNoneBlank(actividadVO.getImagen())) {
			final String imagen = actividadVO.getImagen();
			actividad.setImagen(imagen);
		}
		
	}
	

}
