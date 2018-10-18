package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.MensajesService;
import es.vsanchezrod.proyectorest.servicios.vo.MensajeVO;

@RestController
public class MensajesRest {

	@Autowired
	private MensajesService mensajesService;
	
	@RequestMapping(value = "/mensajes/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('administrador') OR hasAuthority('usuario')")
	public List<MensajeVO> obtenerMensajes(@PathVariable("id") String id) {
		return mensajesService.obtenerMensajesVO(id);
	}
	
	@RequestMapping(value = "/mensajes", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('administrador') OR hasAuthority('usuario')")
	public void enviarMensaje(@RequestBody MensajeVO mensajeVO) {
		mensajesService.crearMensaje(mensajeVO);
	}
	
	@RequestMapping(value = "/mensajes/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('administrador') OR hasAuthority('usuario')")
	public void borrarMensaje(@PathVariable("id") String id) {
		mensajesService.borrarMensaje(id);
	}
	
	
}
