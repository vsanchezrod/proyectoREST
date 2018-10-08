package es.vsanchezrod.proyectorest.servicios.conversores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.vsanchezrod.proyectorest.persistencia.modelos.Rol;
import es.vsanchezrod.proyectorest.servicios.vo.RolVO;

@Component
public class RolesConverter {

	public Rol convetirRolVOARol(RolVO rolVO) {
		
		Rol rol = new Rol();
		
		rol.setId(rolVO.getId());
		rol.setNombre(rolVO.getNombre());
		rol.setDescription(rolVO.getDescription());
		
		return rol;
		
	}
	
	public RolVO convetirRolARolVO(Rol rol) {
		
		RolVO rolVO = new RolVO();
		
		rolVO.setId(rol.getId());
		rolVO.setNombre(rol.getNombre());
		rolVO.setDescription(rol.getDescription());
		
		return rolVO;
		
	}
	
	public List<Rol> convertirListaRolVOAListaRol(List<RolVO> listaRolesVO) {
		
		List<Rol> listaRoles = new ArrayList<>();
		
		for (RolVO rolVO: listaRolesVO) {
			
			listaRoles.add(convetirRolVOARol(rolVO));
		}
				
		return listaRoles;
		
	}
	

	public List<RolVO> convertirListaRolAListaRolVO(List<Rol> listaRoles) {
		
		List<RolVO> listaRolesVO = new ArrayList<>();
		
		for (Rol rol: listaRoles) {
			
			listaRolesVO.add(convetirRolARolVO(rol));
		}
				
		return listaRolesVO;
		
	}
	
	
	
	
	
	
}
