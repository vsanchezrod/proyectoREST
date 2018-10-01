package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Categoria;
import es.vsanchezrod.proyectorest.servicios.vo.CategoriaVO;

@Component
public class CategoriasConverter {

	
	public CategoriaVO convertirCategoriaACategoriaVO(Categoria categoria) {
		
		return new CategoriaVO(categoria.getId(), categoria.getNombre(), categoria.getDescripcion(), categoria.getImagen());
	}
	
	public Categoria convertirCategoriaVOACategoria(CategoriaVO categoriaVO) {
		
		return new Categoria(categoriaVO.getId(), categoriaVO.getNombre(), categoriaVO.getDescripcion(), categoriaVO.getImagen());
	}
	
	
	
	public List<CategoriaVO> convertirListaCategoriasAListaCategoriasVO(List<Categoria> listaCategorias){
	
		List<CategoriaVO> listaCategoriasVO = new ArrayList<CategoriaVO>();
		
		for(Categoria categoria: listaCategorias) {
			
			listaCategoriasVO.add(convertirCategoriaACategoriaVO(categoria));
		}
				
		return listaCategoriasVO;
	}
	
	public List<Categoria> convertirListaCategoriasVOAListaCategorias(List<CategoriaVO> listaCategoriasVO) {
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		for(CategoriaVO categoriaVO: listaCategoriasVO) {
			
			listaCategorias.add(convertirCategoriaVOACategoria(categoriaVO));
		}
		
		return listaCategorias;
	}
	
}
