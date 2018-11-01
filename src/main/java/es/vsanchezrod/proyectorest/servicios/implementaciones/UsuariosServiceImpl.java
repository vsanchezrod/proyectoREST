package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;
import es.vsanchezrod.proyectorest.servicios.UsuariosService;
import es.vsanchezrod.proyectorest.servicios.conversores.UsuariosConverter;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
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
	public List<UsuarioVO> obtenerUsuarios(String nombre) {
		List<Usuario> usuarios = usuariosRepository.findByNombreIgnoreCase(nombre);
		return usuariosConverter.convertirListaUsuariosAListaUsuariosVO(usuarios);
	}

	@Override
	public void borrarAmigoDeUsuario(String idUsuario, String idAmigo) {
		// TODO	IMPLEMENTAR FUNCIÓN QUE BORRE EL AMIGO DE LA LISTA
	}

	@Override
	public TotalVO obtenerNumeroUsuarios() {
		final TotalVO totalVO = new TotalVO();
		totalVO.setTotal(usuariosRepository.count());
		return totalVO;
	}

	@Override
	public void actualizarUsuario(String id, UsuarioVO usuarioVO) {
		final Usuario usuario = usuariosRepository.findById(id);
		if (usuario == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "El usuario no existe.");
		}
		usuariosConverter.actualizarModeloUsuario(usuario, usuarioVO);
		usuariosRepository.save(usuario);
	}
}
