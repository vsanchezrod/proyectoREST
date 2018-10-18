package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.repositorios.MensajesRepository;
import es.vsanchezrod.proyectorest.servicios.MensajesService;
import es.vsanchezrod.proyectorest.servicios.conversores.MensajesConverter;
import es.vsanchezrod.proyectorest.servicios.vo.MensajeVO;

@Service
public class MensajesServiceImpl implements MensajesService {

	@Autowired
	private MensajesConverter mensajesConverter;
	
	@Autowired
	private MensajesRepository mensajesRepository;
	
	@Override
	public List<MensajeVO> obtenerMensajesVO(String id) {
		return mensajesConverter.convertirListaMensajesAListaMensajesVO(mensajesRepository.findByidUsuarioReceptor(id));
	}

	@Override
	public void crearMensaje(MensajeVO mensajeVO) {
		mensajesRepository.save(mensajesConverter.convertirMensajeVOAMensaje(mensajeVO));
	}

	@Override
	public void borrarMensaje(String id) {
		mensajesRepository.deleteById(id);
	}

}
