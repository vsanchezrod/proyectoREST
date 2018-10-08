package es.vsanchezrod.proyectorest.servicios;

import java.util.List;

import es.vsanchezrod.proyectorest.servicios.vo.UsuarioVO;

public interface UsuariosService {

	List<UsuarioVO> obtenerListaUsuariosVO();
	
	void crearUsuario(UsuarioVO usuario);
	
}