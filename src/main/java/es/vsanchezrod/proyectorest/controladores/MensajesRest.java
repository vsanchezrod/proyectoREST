package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.MensajesService;
import es.vsanchezrod.proyectorest.servicios.vo.MensajeVO;

@RestController
public class MensajesRest {

	@Autowired
	private MensajesService mensajesService;
	
	@RequestMapping(value = "/public/mensajes", method = RequestMethod.GET)
	public List<MensajeVO> obtenerMensajes(){
		
		return mensajesService.obtenerMensajesVO();
	}
	
	@RequestMapping(value = "/public/mensajes", method = RequestMethod.POST)
	public void enviarMensajes(MensajeVO mensajeVO){
		
		mensajesService.crearMensaje(mensajeVO);
	}
	
}
