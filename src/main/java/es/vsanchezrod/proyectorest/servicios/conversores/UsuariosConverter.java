package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

@Component
public class UsuariosConverter {
	
	@Autowired
	private InteresesConverter interesesConverter;
	
	@Autowired
	private ProvinciasConverter provinciasConverter;

	public Usuario convertirUsuarioVOAUsuario(UsuarioVO usuarioVO) {
		return new Usuario(
				usuarioVO.getId(),
				usuarioVO.getNombre(),
				usuarioVO.getApellido(),
				usuarioVO.getEmail(),
				usuarioVO.getPassword(),
				usuarioVO.getFechaNacimiento(),
				usuarioVO.getSexo(),
				this.provinciasConverter.convertirProvinciaVOAProvincia(usuarioVO.getProvincia()),
				usuarioVO.getAvatar(),
				usuarioVO.getInfo(),
				this.interesesConverter.convertirListaInteresesVOAListaIntereses(usuarioVO.getIntereses()),
				usuarioVO.getTerminos(),
				usuarioVO.getValoracion(),
				usuarioVO.getRoles()
		);
	}
	
	public UsuarioVO convertirUsuarioAUsuarioVO(Usuario usuario) {
		
		return new UsuarioVO(
				usuario.getId(),
				usuario.getNombre(),
				usuario.getApellido(),
				usuario.getEmail(),
				usuario.getPassword(),
				usuario.getFechaNacimiento(),
				usuario.getSexo(),
				this.provinciasConverter.convertirProvinciaAProvinciaVO(usuario.getProvincia()),
				usuario.getAvatar(),
				usuario.getInfo(),
				this.interesesConverter.convertirListaInteresesAListaInteresesVO(usuario.getIntereses()),
				usuario.getTerminos(),
				usuario.getValoracion(),
				usuario.getRoles()
		);
		
	}
	
	public List<UsuarioVO> convertirListaUsuariosAListaUsuariosVO(List<Usuario> usuarios) {
		List<UsuarioVO> listaUsuariosVO = new ArrayList<UsuarioVO>();
		
		for (Usuario usuario : usuarios ) {
			listaUsuariosVO.add(convertirUsuarioAUsuarioVO(usuario));
		}
		
		return listaUsuariosVO;
	}
	
}
