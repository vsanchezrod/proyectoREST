package es.vsanchezrod.proyectorest.servicios;

import java.util.List;
import java.util.Map;

import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;
import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

public interface UsuariosService {
	
	void crearUsuario(UsuarioVO usuario);
	
	UsuarioVO obtenerUsuarioVOPorId(String id);
	
	List<UsuarioVO> obtenerUsuarios(Map<String, String> queryParams);
	
	TotalVO obtenerNumeroUsuarios();
	
	void actualizarUsuario(String id, UsuarioVO usuarioVO);
	
	void borrarUsuario(String id);
}

