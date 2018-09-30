package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.CategoriasRepository;
import es.vsanchezrod.proyectorest.servicios.CategoriasService;
import es.vsanchezrod.proyectorest.servicios.conversores.CategoriasConverter;
import es.vsanchezrod.proyectorest.servicios.vo.CategoriaVO;

@Service
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	private CategoriasConverter categoriasConverter;
	
	@Autowired
	private CategoriasRepository categoriasRepository;
	
	@Override
	public void crearCategoria(CategoriaVO categoriaVO) {
		
		this.categoriasRepository.save(this.categoriasConverter.convertirCategoriaVOACategoria(categoriaVO));
		
	}
		
	@Override
	public List<CategoriaVO> obtenerCategoriasVO() {
		
		return this.categoriasConverter.convertirListaCategoriasAListaCategoriasVO(this.categoriasRepository.findAll());
	
	}

}
