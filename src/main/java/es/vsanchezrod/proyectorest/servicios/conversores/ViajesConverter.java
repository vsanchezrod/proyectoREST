package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@Component
public class ViajesConverter {
	/*
	@Autowired
	private CategoriasConverter categoriasConverter;

	public Viaje convertirViajeVOAViaje(ViajeVO viajeVO) {
		return new Viaje (
				viajeVO.getId(),
				viajeVO.getNombre(),
				this.categoriasConverter.convertirListaCategoriasVOAListaCategorias(viajeVO.getCategorias()),
				viajeVO.getDescripcion(),
				viajeVO.getNivel(),
				viajeVO.getDistancia(),
				viajeVO.getFechaInicio(),
				viajeVO.getImagen(),
				viajeVO.getCoordenadas(),
				viajeVO.getIdUsuarioCreacion(),
				viajeVO.getFechaFin(),
				viajeVO.getPrecio(),
				viajeVO.getPlazas()
		);
	}
	
	public ViajeVO convertirViajeAViajeVO(Viaje viaje) {
		return new ViajeVO (
				viaje.getId(),
				viaje.getNombre(),
				this.categoriasConverter.convertirListaCategoriasAListaCategoriasVO(viaje.getCategorias()),
				viaje.getDescripcion(),
				viaje.getNivel(),
				viaje.getDistancia(),
				viaje.getFechaInicio(),
				viaje.getImagen(),
				viaje.getCoordenadas(),
				viaje.getIdUsuarioCreacion(),
				viaje.getFechaFin(),
				viaje.getPrecio(),
				viaje.getPlazas()
		);
	}
	
	public List<ViajeVO> convertirListaViajessAListaViajesVO(List<Viaje> viajes) {
		List<ViajeVO> listaViajesVO = new ArrayList<ViajeVO>();
		
		for (Viaje viaje : viajes ) {
			listaViajesVO.add(convertirViajeAViajeVO(viaje));
		}
		
		return listaViajesVO;
	}
*/	
}
