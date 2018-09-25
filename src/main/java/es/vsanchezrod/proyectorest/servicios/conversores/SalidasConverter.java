package es.vsanchezrod.proyectorest.servicios.conversores;

import es.vsanchezrod.proyectorest.persistencia.modelos.Salida;
import es.vsanchezrod.proyectorest.servicios.vo.SalidaVO;

public class SalidasConverter {

	public Salida convertirSalidaVOASalida(SalidaVO salidaVO) {
		return new Salida(
				salidaVO.getNombre(),
				salidaVO.getCategorias(),
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
				salida.getNombre(),
				salida.getCategorias(),
				salida.getDescripcion(),
				salida.getNivel(),
				salida.getDistancia(),
				salida.getFechaInicio(),
				salida.getImagen(),
				salida.getCoordenadas(),
				salida.getIdUsuarioCreacion()
		);
	}
}
