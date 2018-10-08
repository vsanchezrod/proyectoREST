package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;
import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@Component
public class ViajesConverter {
	
	@Autowired
	private ActividadCategoriasConverter actividadCategoriasConverter;
	
	public Viaje convertirViajeVOAViaje(ViajeVO viajeVO) {

		Viaje viaje = new Viaje();
		
		viaje.setId(viajeVO.getId());
		viaje.setNombre(viajeVO.getNombre());
		viaje.setCategorias(
				this.actividadCategoriasConverter.convertirListaActividadCategoriasVOAListaActividadCategorias(viajeVO.getCategorias()));
		viaje.setDescripcion(viajeVO.getDescripcion());
		viaje.setNivel(viajeVO.getNivel());
		viaje.setDistancia(viajeVO.getDistancia());
		viaje.setFechaInicio(viajeVO.getFechaInicio());
		viaje.setImagen(viajeVO.getImagen());
		viaje.setCoordenadas(viajeVO.getCoordenadas());
		viaje.setIdUsuarioCreacion(viajeVO.getIdUsuarioCreacion());
		viaje.setListaParticipantes(viajeVO.getListaParticipantes());
		viaje.setPuntuacion(viajeVO.getPuntuacion());
		viaje.setFechaFin(viajeVO.getFechaFin());
		viaje.setPrecio(viajeVO.getPrecio());
		viaje.setPlazas(viajeVO.getPlazas());
		
		return viaje;
	}
	
	public ViajeVO convertirViajeAViajeVO(Viaje viaje) {
		
		ViajeVO viajeVO = new ViajeVO();
		
		viajeVO.setId(viaje.getId());
		viajeVO.setNombre(viaje.getNombre());
		viajeVO.setCategorias(
				this.actividadCategoriasConverter.convertirListaActividadCategoriasAListaActividadCategoriasVO(viaje.getCategorias()));
		viajeVO.setDescripcion(viaje.getDescripcion());
		viajeVO.setNivel(viaje.getNivel());
		viajeVO.setDistancia(viaje.getDistancia());
		viajeVO.setFechaInicio(viaje.getFechaInicio());
		viajeVO.setImagen(viaje.getImagen());
		viajeVO.setCoordenadas(viaje.getCoordenadas());
		viajeVO.setIdUsuarioCreacion(viaje.getIdUsuarioCreacion());
		viajeVO.setListaParticipantes(viaje.getListaParticipantes());
		viajeVO.setPuntuacion(viaje.getPuntuacion());
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
