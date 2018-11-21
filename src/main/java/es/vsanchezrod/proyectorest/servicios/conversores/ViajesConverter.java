package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.ActividadCategoria;
import es.vsanchezrod.proyectorest.persistencia.modelos.Viaje;
import es.vsanchezrod.proyectorest.servicios.vo.ActividadCategoriaVO;
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
	
	public void actualizarModeloViaje(Viaje viaje, ViajeVO viajeVO) {
			
		if(StringUtils.isNoneBlank(viajeVO.getNombre())) {
			final String nombre = WordUtils.capitalizeFully(StringUtils.trim(viajeVO.getNombre()));
			viaje.setNombre(nombre);
		}
		
		if(!viajeVO.getCategorias().isEmpty()) {
			final List<ActividadCategoriaVO> categoriasVO = viajeVO.getCategorias();
			final List<ActividadCategoria> categorias = actividadCategoriasConverter.convertirListaActividadCategoriasVOAListaActividadCategorias(categoriasVO);
			viaje.setCategorias(categorias);
		}
		
		if(StringUtils.isNoneBlank(viajeVO.getDescripcion())) {
			final String descripcion = WordUtils.capitalizeFully(StringUtils.trim(viajeVO.getDescripcion()));
			viaje.setDescripcion(descripcion);
		}
		
		if(viajeVO.getNivel() != null) {
			viaje.setNivel(viajeVO.getNivel());
		}
		
		if(viajeVO.getDistancia() != null) {
			viaje.setDistancia(viajeVO.getDistancia());
		}
		
		if(viajeVO.getFechaInicio() != null) {
			viaje.setFechaInicio(viajeVO.getFechaInicio());
		}
		
		if(viajeVO.getFechaFin() != null) {
			viaje.setFechaFin(viajeVO.getFechaFin());
		}
		
		if(viajeVO.getPrecio() != null) {
			viaje.setPrecio(viajeVO.getPrecio());
		}
		
		if(viajeVO.getPlazas() != null) {
			viaje.setPlazas(viajeVO.getPlazas());
		}
		
		if(StringUtils.isNoneBlank(viajeVO.getImagen())) {
			final String imagen = viajeVO.getImagen();
			viaje.setImagen(imagen);
		}
			
	}
	

}
