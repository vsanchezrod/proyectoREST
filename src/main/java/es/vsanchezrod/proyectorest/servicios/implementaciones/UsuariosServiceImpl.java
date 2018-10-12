package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.modelos.Rol;
import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;
import es.vsanchezrod.proyectorest.servicios.UsuariosService;
import es.vsanchezrod.proyectorest.servicios.conversores.UsuariosConverter;
import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

@Service
public class UsuariosServiceImpl implements UsuariosService {

	@Autowired
	private UsuariosConverter usuariosConverter;
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<UsuarioVO> obtenerListaUsuariosVO() {
		return usuariosConverter.convertirListaUsuariosAListaUsuariosVO(usuariosRepository.findAll());

	}

	@Override
	public void crearUsuario(UsuarioVO usuarioVO) {
		// Encriptación de password
		usuarioVO.setPassword(passwordEncoder.encode(usuarioVO.getPassword()));
		
		Usuario usuario = usuariosConverter.convertirUsuarioVOAUsuario(usuarioVO);
		// Asignación rol por defecto
		usuario.getRoles().add("usuario");
		usuariosRepository.save(usuario);
		
	}
	
	@Override
	public UsuarioVO obtenerUsuarioVOPorId(String id) {
		Usuario usuario = usuariosRepository.findById(id);
		return usuariosConverter.convertirUsuarioAUsuarioVO(usuario);
	}

	@Override
	public UsuarioVO obtenerUsuarioVOPorNombre(String nombre) {
		Usuario usuario = usuariosRepository.findByNombre(nombre);
		return usuariosConverter.convertirUsuarioAUsuarioVO(usuario);
	}
	

}
