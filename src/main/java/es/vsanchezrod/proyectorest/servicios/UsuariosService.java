package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

public interface UsuariosService {
	
	void crearUsuario(UsuarioVO usuario);
	
	UsuarioVO obtenerUsuarioVOPorId(String id);
	
	List<UsuarioVO> obtenerUsuarios(String nombre);
	
	void borrarAmigoDeUsuario(String idUsuario, String idAmigo);
	
	TotalVO obtenerNumeroUsuarios();
	
	void actualizarUsuario(String id, UsuarioVO usuarioVO);
}

