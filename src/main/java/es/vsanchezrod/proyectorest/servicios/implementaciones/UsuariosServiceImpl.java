package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public List<UsuarioVO> obtenerListaUsuariosVO() {
		return this.usuariosConverter.convertirListaUsuariosAListaUsuariosVO(this.usuariosRepository.findAll());

	}

	@Override
	public void crearUsuario(UsuarioVO usuarioVO) {
		this.usuariosRepository.save(this.usuariosConverter.convertirUsuarioVOAUsuario(usuarioVO));
		
	}
	
	@Override
	public UsuarioVO obtenerUsuarioVOPorId(String id) {
		Usuario usuario = this.usuariosRepository.findById(id);
		return this.usuariosConverter.convertirUsuarioAUsuarioVO(usuario);
	}

	@Override
	public UsuarioVO obtenerUsuarioVOPorNombre(String nombre) {
		Usuario usuario = this.usuariosRepository.findByNombre(nombre);
		return this.usuariosConverter.convertirUsuarioAUsuarioVO(usuario);
	}
	

}
