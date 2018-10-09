package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Mensaje;
import es.vsanchezrod.proyectorest.servicios.vo.MensajeVO;

@Component
public class MensajesConverter {

	public Mensaje convertirMensajeVOAMensaje(MensajeVO mensajeVO) {
		
		Mensaje mensaje = new Mensaje();
		
		mensaje.setId(mensajeVO.getId());
		mensaje.setIdUsuarioEmisor(mensajeVO.getIdUsuarioEmisor());
		mensaje.setIdUsuarioReceptor(mensajeVO.getIdUsuarioReceptor());
		mensaje.setFecha(mensajeVO.getFecha());
		mensaje.setAsunto(mensajeVO.getAsunto());
		mensaje.setMensaje(mensajeVO.getMensaje());
		mensaje.setLeido(mensajeVO.getLeido());
		
		return mensaje;
	}
	
	public MensajeVO convertirMensajeAMensajeVO(Mensaje mensaje) {
		
		MensajeVO mensajeVO = new MensajeVO();
		
		mensajeVO.setId(mensaje.getId());
		mensajeVO.setIdUsuarioEmisor(mensaje.getIdUsuarioEmisor());
		mensajeVO.setIdUsuarioReceptor(mensaje.getIdUsuarioReceptor());
		mensajeVO.setFecha(mensaje.getFecha());
		mensajeVO.setAsunto(mensaje.getAsunto());
		mensajeVO.setMensaje(mensaje.getMensaje());
		mensajeVO.setLeido(mensaje.getLeido());
		
		return mensajeVO;
	}
	
	public List<MensajeVO> convertirListaMensajesAListaMensajesVO(List<Mensaje> listaMensajes) {
		
		List<MensajeVO> listaMensajesVO = new ArrayList<MensajeVO>();
		
		for(Mensaje mensaje: listaMensajes) {
			listaMensajesVO.add(convertirMensajeAMensajeVO(mensaje));
		}
		
		return listaMensajesVO;
	}
}
