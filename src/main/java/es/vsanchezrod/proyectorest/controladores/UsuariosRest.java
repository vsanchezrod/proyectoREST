package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.UsuariosService;
import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

@RestController
public class UsuariosRest {
	
	@Autowired
	private UsuariosService usuariosService;

	@RequestMapping(value = "/public/usuarios", method = RequestMethod.GET)
	public List<UsuarioVO> obtenerListaUsuarios() {
		
		return this.usuariosService.obtenerListaUsuariosVO();
	}
	
	@RequestMapping(value = "/public/usuarios/{id}", method = RequestMethod.GET)
	public UsuarioVO obtenerUsuario(@PathVariable("id") String id) {
		
		return this.usuariosService.obtenerUsuarioVO(id);
	}
	
	@RequestMapping(value = "/public/usuarios",  method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void crearUsuarioVO(@RequestBody UsuarioVO usuarioVO) {
		
		this.usuariosService.crearUsuario(usuarioVO);
	}
	
	
	
	
}
