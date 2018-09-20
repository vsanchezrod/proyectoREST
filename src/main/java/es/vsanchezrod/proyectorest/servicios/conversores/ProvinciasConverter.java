package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import es.vsanchezrod.proyectorest.persistencia.modelos.Provincia;
import es.vsanchezrod.proyectorest.servicios.vo.ProvinciaVO;

public class ProvinciasConverter {

	public ProvinciaVO convertirProvinciaAProvinciaVO(Provincia provincia) {
		return new ProvinciaVO(provincia.getCodigo(), provincia.getNombre());
	}
	
	public List<ProvinciaVO> convertirListaProvinciaAListaProvinciaVO(List<Provincia> listaProvincia){
		List<ProvinciaVO> listaProvinciasVO = new ArrayList<>();
		
		for (Provincia provincia : listaProvincia) {
			
			listaProvinciasVO.add(convertirProvinciaAProvinciaVO(provincia));
			
		}
		
		return listaProvinciasVO;
	}
}
