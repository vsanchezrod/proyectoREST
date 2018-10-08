package es.vsanchezrod.proyectorest.servicios.conversores;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.OpinionUsuario;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionUsuarioVO;

@Component
public class OpinionUsuariosConverter {
	
	public OpinionUsuarioVO convertirOpinionUsuarioAOpinionUsuarioVO(OpinionUsuario opinionUsuario) {
		
		OpinionUsuarioVO opinionUsuarioVO = new OpinionUsuarioVO();
		
		opinionUsuarioVO.setId(opinionUsuario.getId());
		opinionUsuarioVO.setNombre(opinionUsuario.getNombre());
		opinionUsuarioVO.setAvatar(opinionUsuario.getAvatar());
		
		return opinionUsuarioVO;
	}
	
	public OpinionUsuario convertirOpinionUsuarioVOAOpinionUsuario(OpinionUsuarioVO opinionUsuarioVO) {
		
		OpinionUsuario opinionUsuario = new OpinionUsuario();
		
		opinionUsuario.setId(opinionUsuarioVO.getId());
		opinionUsuario.setNombre(opinionUsuarioVO.getNombre());
		opinionUsuario.setAvatar(opinionUsuarioVO.getAvatar());
		
		
		return opinionUsuario;
	}
}
