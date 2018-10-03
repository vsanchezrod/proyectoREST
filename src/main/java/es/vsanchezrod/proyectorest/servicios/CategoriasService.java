package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.CategoriaVO;

public interface CategoriasService {

	void crearCategoria(CategoriaVO categoriaVO);
	
	List<CategoriaVO> obtenerListaCategoriasVO();
	
	void borrarCategoria(String id);
	
}
