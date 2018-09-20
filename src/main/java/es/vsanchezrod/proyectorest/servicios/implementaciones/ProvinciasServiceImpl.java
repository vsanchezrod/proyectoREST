package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Provincia;
import es.vsanchezrod.proyectorest.persistencia.repositorios.ProvinciasRepository;
import es.vsanchezrod.proyectorest.servicios.ProvinciasService;
import es.vsanchezrod.proyectorest.servicios.conversores.ProvinciasConverter;
import es.vsanchezrod.proyectorest.servicios.vo.ProvinciaVO;

public class ProvinciasServiceImpl implements ProvinciasService {

	private ProvinciasRepository provinciasRepository;
	private ProvinciasConverter provinciasConverter;
	
	public ProvinciasServiceImpl() {
		provinciasRepository = new ProvinciasRepository();
		provinciasConverter = new ProvinciasConverter();
	}
	
	@Override
	public List<ProvinciaVO> obtenerProvincias() {
			
		List<Provincia> listaProvincias = provinciasRepository.obtenerProvincias();
		
		return provinciasConverter.convertirListaProvinciaAListaProvinciaVO(listaProvincias);
	}
	
}
