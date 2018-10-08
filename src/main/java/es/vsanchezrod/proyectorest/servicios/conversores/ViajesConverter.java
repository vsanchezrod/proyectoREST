package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@Component
public class ViajesConverter {
	
	public Viaje convertirViajeVOAViaje(ViajeVO viajeVO) {

		Viaje viaje = new Viaje();
		
		viaje.setFechaFin(viajeVO.getFechaFin());
		viaje.setPrecio(viajeVO.getPrecio());
		viaje.setPlazas(viajeVO.getPlazas());
		
		return viaje;
	}
	
	public ViajeVO convertirViajeAViajeVO(Viaje viaje) {
		
		ViajeVO viajeVO = new ViajeVO();
		
		viajeVO.setFechaFin(viaje.getFechaFin());
		viajeVO.setPrecio(viaje.getPrecio());
		viajeVO.setPlazas(viaje.getPlazas());
		
		return viajeVO;
	}
	
	public List<ViajeVO> convertirListaViajessAListaViajesVO(List<Viaje> viajes) {
		List<ViajeVO> listaViajesVO = new ArrayList<ViajeVO>();
		
		for (Viaje viaje : viajes ) {
			listaViajesVO.add(convertirViajeAViajeVO(viaje));
		}
		
		return listaViajesVO;
	}

}
