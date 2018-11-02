package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

@Component
public class UsuariosConverter {
	
	@Autowired
	private ProvinciasConverter provinciasConverter;
	
	@Autowired
	private ActividadCategoriasConverter actividadCategoriaConverter;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Usuario convertirUsuarioVOAUsuario(UsuarioVO usuarioVO) {
		Usuario usuario = new Usuario();
		
		usuario.setId(usuarioVO.getId());
		usuario.setNombre(usuarioVO.getNombre());
		usuario.setApellido(usuarioVO.getApellido());
		usuario.setEmail(usuarioVO.getEmail());
		usuario.setPassword(usuarioVO.getPassword());
		usuario.setFechaNacimiento(usuarioVO.getFechaNacimiento());
		usuario.setSexo(usuarioVO.getSexo());
		usuario.setProvincia(provinciasConverter.convertirProvinciaVOAProvincia(usuarioVO.getProvincia()));
		usuario.setAvatar(usuarioVO.getAvatar());
		usuario.setInfo(usuarioVO.getInfo());
		usuario.setIntereses(actividadCategoriaConverter.convertirListaActividadCategoriasVOAListaActividadCategorias(usuarioVO.getIntereses()));
		usuario.setTerminos(usuarioVO.getTerminos());
		usuario.setValoracion(usuarioVO.getValoracion());
		usuario.setRoles(usuarioVO.getRoles());
		usuario.setAmigos(usuarioVO.getAmigos());
		
		return usuario;
	}
	
	public UsuarioVO convertirUsuarioAUsuarioVO(Usuario usuario) {
	UsuarioVO usuarioVO = new UsuarioVO();
		
		usuarioVO.setId(usuario.getId());
		usuarioVO.setNombre(usuario.getNombre());
		usuarioVO.setApellido(usuario.getApellido());
		usuarioVO.setEmail(usuario.getEmail());
		usuarioVO.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioVO.setSexo(usuario.getSexo());
		usuarioVO.setProvincia(provinciasConverter.convertirProvinciaAProvinciaVO(usuario.getProvincia()));
		usuarioVO.setAvatar(usuario.getAvatar());
		usuarioVO.setInfo(usuario.getInfo());
		usuarioVO.setIntereses(actividadCategoriaConverter.convertirListaActividadCategoriasAListaActividadCategoriasVO(usuario.getIntereses()));	
		usuarioVO.setTerminos(usuario.getTerminos());
		usuarioVO.setValoracion(usuario.getValoracion());
		usuarioVO.setRoles(usuario.getRoles());
		usuarioVO.setAmigos(usuario.getAmigos());
			
		return usuarioVO;

	}
	
	public List<UsuarioVO> convertirListaUsuariosAListaUsuariosVO(List<Usuario> usuarios) {
		List<UsuarioVO> listaUsuariosVO = new ArrayList<UsuarioVO>();
		
		for(Usuario usuario : usuarios ) {
			listaUsuariosVO.add(convertirUsuarioAUsuarioVO(usuario));
		}
		
		return listaUsuariosVO;
	}
	
	public void actualizarModeloUsuario(Usuario usuario, UsuarioVO usuarioVO) {
			
		if(StringUtils.isNotBlank(usuarioVO.getNombre())) {
			final String nombre = WordUtils.capitalizeFully(StringUtils.trim(usuarioVO.getNombre()));
			usuario.setNombre(nombre);
		}
		
		if(StringUtils.isNotBlank(usuarioVO.getApellido())) {
			final String apellido = WordUtils.capitalizeFully(StringUtils.trim(usuarioVO.getApellido()));
			usuario.setApellido(apellido);
		}
		
		if(usuarioVO.getFechaNacimiento() != null) {
			usuario.setFechaNacimiento(usuarioVO.getFechaNacimiento());
		}
		
		if(usuarioVO.getProvincia() != null) {
			usuario.setProvincia(provinciasConverter.convertirProvinciaVOAProvincia(usuarioVO.getProvincia()));
		}
		
		if(StringUtils.isNotBlank(usuarioVO.getInfo())) {
			final String info = StringUtils.trim(usuarioVO.getInfo());
			usuario.setInfo(info);
		}
		
		if (StringUtils.isNotBlank(usuarioVO.getPassword())) {
			usuario.setPassword(passwordEncoder.encode(StringUtils.trim(usuarioVO.getPassword())));
		}
		
		if (StringUtils.isNotBlank(usuarioVO.getSexo())) {
			usuario.setSexo(usuarioVO.getSexo());
		}
	
		if(StringUtils.isNotBlank(usuarioVO.getAvatar())) {
			usuario.setAvatar(usuarioVO.getAvatar());
		}
				
	}
}
