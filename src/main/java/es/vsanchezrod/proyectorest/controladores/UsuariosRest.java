	package es.vsanchezrod.proyectorest.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.UsuariosService;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

@RestController
public class UsuariosRest {
	
	@Autowired
	private UsuariosService usuariosService;
	
	// PATH PARAM
	@RequestMapping(value = "/public/usuarios/{id}", method = RequestMethod.GET)
	public UsuarioVO obtenerUsuarioPorId(@PathVariable("id") String id) {
		return usuariosService.obtenerUsuarioVOPorId(id);
	}
	
	// Si recibe QUERY PARAM da la lista filtrada, sino la lista entera
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('usuario') OR hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioVO> obtenerUsuarios(@RequestParam("nombre") String nombre) {
		return usuariosService.obtenerUsuarios(nombre);
	}
	
	@RequestMapping(value = "/public/usuarios",  method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void crearUsuarioVO(@RequestBody UsuarioVO usuarioVO) {
		usuariosService.crearUsuario(usuarioVO);
	}
	
	@RequestMapping(value = "/usuarios/{idUsuario}/amigos/{idAmigo}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('usuario')")
	public void borrarAmigo(@PathVariable("idUsuario") String idUsuario, @PathVariable("idAmigo") String idAmigo) {
		// TODO MIRAR COMO ES ESTO
	}
	
	@RequestMapping(value = "/usuarios/numero", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('administrador')")
	public TotalVO obtenerNumeroUsuarios() {
		return usuariosService.obtenerNumeroUsuarios();
	}
	
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PATCH)
	@PreAuthorize("hasAuthority('usuario') OR hasAuthority('administrador')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void actualizarUsuario(@PathVariable("id") String id, @RequestBody UsuarioVO usuarioVO ) {
		usuariosService.actualizarUsuario(id, usuarioVO);
	}
	
	
	
}
