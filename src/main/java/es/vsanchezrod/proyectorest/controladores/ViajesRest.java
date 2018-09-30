package es.vsanchezrod.proyectorest.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.vsanchezrod.proyectorest.servicios.vo.ViajeVO;

@RestController
public class ViajesRest {

	@RequestMapping(value = "/public/viajes", method = RequestMethod.GET)
	public List<ViajeVO> obtenerListaViajesVO() {
		
		List<ViajeVO> listaViajes = new ArrayList<ViajeVO>();
				
		listaViajes.add(new ViajeVO("asdadadadsads", "Pirineos", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		listaViajes.add(new ViajeVO("22222", "lalal", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		listaViajes.add(new ViajeVO("333333", "lololloolo", null, "lalalala", 3, 20, new Date(), "imagen", null, "33",  new Date(),  100, 10));
		
		return listaViajes;
	}
}
