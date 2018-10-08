package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import es.vsanchezrod.proyectorest.persistencia.modelos.Salida;
import es.vsanchezrod.proyectorest.servicios.vo.SalidaVO;

@Component
public class SalidasConverter {
/*
	@Autowired
	public CategoriasConverter categoriasConverter;
	
	public Salida convertirSalidaVOASalida(SalidaVO salidaVO) {
		return new Salida(
				salidaVO.getId(),
				salidaVO.getNombre(),
				this.categoriasConverter.convertirListaCategoriasVOAListaCategorias(salidaVO.getCategorias()),
				salidaVO.getDescripcion(),
				salidaVO.getNivel(),
				salidaVO.getDistancia(),
				salidaVO.getFechaInicio(),
				salidaVO.getImagen(),
				salidaVO.getCoordenadas(),
				salidaVO.getIdUsuarioCreacion()
		);
	}
	
	public SalidaVO convertirSalidaASalidaVO(Salida salida) {
		return new SalidaVO(
				salida.getId(),
				salida.getNombre(),
				this.categoriasConverter.convertirListaCategoriasAListaCategoriasVO(salida.getCategorias()),
				salida.getDescripcion(),
				salida.getNivel(),
				salida.getDistancia(),
				salida.getFechaInicio(),
				salida.getImagen(),
				salida.getCoordenadas(),
				salida.getIdUsuarioCreacion()
		);
	}
	
	public List<SalidaVO> convertirListaSalidasAListaSalidasVO(List<Salida> salidas) {
		List<SalidaVO> listaSalidasVO = new ArrayList<SalidaVO>();
		
		for (Salida salida : salidas ) {
			listaSalidasVO.add(convertirSalidaASalidaVO(salida));
		}
		
		return listaSalidasVO;
	}
	*/
}
