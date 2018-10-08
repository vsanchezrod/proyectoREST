package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Categoria;
import es.vsanchezrod.proyectorest.servicios.vo.CategoriaVO;

@Component
public class CategoriasConverter {

	
	public CategoriaVO convertirCategoriaACategoriaVO(Categoria categoria) {
		
		CategoriaVO categoriaVO = new CategoriaVO();
		
		categoriaVO.setId(categoria.getId());
		categoriaVO.setNombre(categoria.getNombre());
		categoriaVO.setDescripcion(categoria.getDescripcion());
		categoriaVO.setImagen(categoria.getImagen());
				
		return categoriaVO;
		
	}
	
	public Categoria convertirCategoriaVOACategoria(CategoriaVO categoriaVO) {
		
		Categoria categoria = new Categoria();
			
		categoria.setId(categoriaVO.getId());
		categoria.setNombre(categoriaVO.getNombre());
		categoria.setDescripcion(categoriaVO.getDescripcion());
		categoria.setImagen(categoriaVO.getImagen());
					
		return categoria;
		
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
