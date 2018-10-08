package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Provincia;
import es.vsanchezrod.proyectorest.servicios.vo.ProvinciaVO;

@Component
public class ProvinciasConverter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProvinciasConverter.class);
	
	public ProvinciasConverter() {
		LOGGER.info("Constructor: ProvinciasConverter");
	}
		
	public ProvinciaVO convertirProvinciaAProvinciaVO(Provincia provincia) {
		
		ProvinciaVO provinciaVO = new ProvinciaVO();
		
		provinciaVO.setId(provincia.getId());
		provinciaVO.setCodigo(provincia.getCodigo());
		provinciaVO.setNombre(provincia.getNombre());
		
		return provinciaVO;
	}
	
	public Provincia convertirProvinciaVOAProvincia(ProvinciaVO provinciaVO) {
		
		Provincia provincia = new Provincia();
		
		provincia.setId(provinciaVO.getId());
		provincia.setCodigo(provinciaVO.getCodigo());
		provincia.setNombre(provinciaVO.getNombre());
		
		return provincia;
	}
	
	public List<ProvinciaVO> convertirListaProvinciaAListaProvinciaVO(List<Provincia> listaProvincia){
		List<ProvinciaVO> listaProvinciasVO = new ArrayList<>();
		
		for (Provincia provincia : listaProvincia) {
			
			listaProvinciasVO.add(convertirProvinciaAProvinciaVO(provincia));
			
		}
		
		return listaProvinciasVO;
	}

}
