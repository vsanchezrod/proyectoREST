package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.ActividadCategoria;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadCategoriaVO;

@Component
public class ActividadCategoriasConverter {

	
	public ActividadCategoriaVO convertirActividadCategoriaAActividadCategoriaVO(ActividadCategoria categoria) {
		
		ActividadCategoriaVO actividadCategoriaVO = new ActividadCategoriaVO();
		
		actividadCategoriaVO.setId(categoria.getId());
		actividadCategoriaVO.setNombre(categoria.getNombre());
		
		return actividadCategoriaVO;
	}
	
	public ActividadCategoria convertirActividadCategoriaVOAActividadCategoria(ActividadCategoriaVO categoriaVO) {
		
		ActividadCategoria actividadCategoria = new ActividadCategoria();
		
		actividadCategoria.setId(categoriaVO.getId());
		actividadCategoria.setNombre(categoriaVO.getNombre());
		
		return actividadCategoria;
	}
	
		
	public List<ActividadCategoriaVO> convertirListaActividadCategoriasAListaActividadCategoriasVO(List<ActividadCategoria> listaCategorias){
		
		List<ActividadCategoriaVO> listaCategoriasVO = new ArrayList<ActividadCategoriaVO>();
		
		for(ActividadCategoria categoria: listaCategorias) {
			
			listaCategoriasVO.add(convertirActividadCategoriaAActividadCategoriaVO(categoria));
		}
				
		return listaCategoriasVO;
	}

	public List<ActividadCategoria> convertirListaActividadCategoriasVOAListaActividadCategorias(List<ActividadCategoriaVO> listaCategoriasVO){
		
		List<ActividadCategoria> listaCategorias = new ArrayList<ActividadCategoria>();
		
		for(ActividadCategoriaVO categoriaVO: listaCategoriasVO) {
			
			listaCategorias.add(convertirActividadCategoriaVOAActividadCategoria(categoriaVO));
		}
				
		return listaCategorias;
	}
	
}
