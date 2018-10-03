package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.modelos.Provincia;
import es.vsanchezrod.proyectorest.persistencia.repositorios.ProvinciasRepository;
import es.vsanchezrod.proyectorest.servicios.ProvinciasService;
import es.vsanchezrod.proyectorest.servicios.conversores.ProvinciasConverter;
import es.vsanchezrod.proyectorest.servicios.vo.ProvinciaVO;

@Service
public class ProvinciasServiceImpl implements ProvinciasService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ProvinciasServiceImpl.class);

	@Autowired
	private ProvinciasRepository provinciasRepository;
	@Autowired
	private ProvinciasConverter provinciasConverter;
	
	public ProvinciasServiceImpl() {
		
		LOGGER.info("Constructor: ProvinciasServiceImpl");
	}
	
	@Override
	public List<ProvinciaVO> obtenerListaProvincias() {
			
		List<Provincia> listaProvincias = provinciasRepository.obtenerProvincias();
		
		return provinciasConverter.convertirListaProvinciaAListaProvinciaVO(listaProvincias);
	}
	
}
