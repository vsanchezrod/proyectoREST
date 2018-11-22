package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import es.vsanchezrod.proyectorest.persistencia.modelos.Mensaje;
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
		return mensajesConverter.convertirListaMensajesAListaMensajesVO(mensajesRepository.findByidUsuarioReceptorOrderByFechaDesc(id));
	}

	@Override
	public void crearMensaje(MensajeVO mensajeVO) {
		mensajesRepository.save(mensajesConverter.convertirMensajeVOAMensaje(mensajeVO));
	}

	@Override
	public void borrarMensaje(String id) {
		mensajesRepository.deleteById(id);
	}

	@Override
	public void actualizarMensaje(String id, MensajeVO mensajeVO) {
		final Mensaje mensaje = mensajesRepository.findById(id);
		if (mensaje == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "El mensaje no existe.");
		}
		mensajesConverter.actualizarModeloMensaje(mensaje, mensajeVO);
		mensajesRepository.save(mensaje);
		
	}

}
