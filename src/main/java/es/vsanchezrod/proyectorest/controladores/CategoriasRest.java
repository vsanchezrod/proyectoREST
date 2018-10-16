package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.CategoriasService;
import es.vsanchezrod.proyectorest.servicios.vo.CategoriaVO;

@RestController
public class CategoriasRest {

	@Autowired
	private CategoriasService categoriasService;
	
	@RequestMapping(value = "/public/categorias", method = RequestMethod.GET)
	public List<CategoriaVO> obtenerCategorias() {
		
		return categoriasService.obtenerListaCategoriasVO();
	}
	
	@RequestMapping(value = "/categorias", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.CREATED)
	public void crearCategorias(@RequestBody CategoriaVO categoriaVO) {
		
		categoriasService.crearCategoria(categoriaVO);
		
	}
	
	@RequestMapping(value = "/categorias/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.OK)
	public void borrarCategoria(@PathVariable("id") String id) {
		
		categoriasService.borrarCategoria(id);
	}
}
