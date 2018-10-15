package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	//@PreAuthorize("hasAuthority('administrador')")
	public List<UsuarioVO> obtenerListaUsuarios() {
		
		return usuariosService.obtenerListaUsuariosVO();
	}
	
	// PATH PARAM
	@RequestMapping(value = "/public/usuarios/{id}", method = RequestMethod.GET)
	//@PreAuthorize("hasAuthority('administrador') OR hasAuthority('usuario')")
	public UsuarioVO obtenerUsuarioPorId(@PathVariable("id") String id) {
		
		return usuariosService.obtenerUsuarioVOPorId(id);
	}
	
	// QUERY PARAM
	/*@RequestMapping(value = "/public/usuarios", method = RequestMethod.GET)
	public UsuarioVO obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre) {
		return usuariosService.obtenerUsuarioVOPorNombre(nombre);
	}*/
	
	@RequestMapping(value = "/public/usuarios",  method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void crearUsuarioVO(@RequestBody UsuarioVO usuarioVO) {
		
		usuariosService.crearUsuario(usuarioVO);
	}
	
	
	
	
}
