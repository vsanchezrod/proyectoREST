package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.modelos.Opinion;
import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.persistencia.repositorios.OpinionesRepository;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;
import es.vsanchezrod.proyectorest.servicios.OpinionesService;
import es.vsanchezrod.proyectorest.servicios.conversores.OpinionesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.OpinionVO;
import es.vsanchezrod.proyectorest.servicios.vo.TotalVO;

@Service
public class OpinionesServiceImpl implements OpinionesService {

	@Autowired
	private OpinionesConverter opinionesConverter;
	
	@Autowired
	private OpinionesRepository opinionesRepository;
	
	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@Override
	public void guardarOpinion(OpinionVO opinionVO) {
		
		final Opinion opinion = opinionesConverter.convertirOpinionVOAOpinion(opinionVO);
		opinionesRepository.save(opinion);
		
		final Integer valoracionOpinion = (opinion.getOrganizacionValoracion() + opinion.getRecorridoValoracion() + opinion.getAmbienteValoracion()) / 3;
		
		// Buscar usuario
		final Usuario usuario = usuarioRepository.findById(opinion.getUsuarioOpinion());
		
		// recalcular valoracion
		if(usuario.getNumeroValoraciones() == null) {
			usuario.setNumeroValoraciones(0);
		}
		
		if(usuario.getValoracionTotal() == null) {
			usuario.setValoracionTotal(0);
		}
		usuario.setNumeroValoraciones(usuario.getNumeroValoraciones() + 1 );
		usuario.setValoracionTotal(usuario.getValoracionTotal() + valoracionOpinion);
		usuario.setValoracion((double)usuario.getValoracionTotal() / usuario.getNumeroValoraciones());
		
		usuarioRepository.save(usuario);
		
	}

	@Override
	public List<OpinionVO> obtenerListaOpinionesVO() {
		return opinionesConverter.convertirListaOpinionesAListaOpinionesVO(opinionesRepository.findTop5ByOrderByFechaDesc());
	}

	@Override
	public void borrarOpinion(String id) {
		opinionesRepository.deleteById(id);
	}

	@Override
	public TotalVO obtenerNumeroOpiniones() {
		final TotalVO totalVO = new TotalVO();
		
		totalVO.setTotal(opinionesRepository.count());
		return totalVO;

	}

	
}
