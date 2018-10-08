package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public UsuarioVO buscarUsuarioPorNombre(String nombre) {
		return this.usuariosConverter.convertirUsuarioAUsuarioVO(this.usuariosRepository.findByNombre(nombre));
	}
	

}
