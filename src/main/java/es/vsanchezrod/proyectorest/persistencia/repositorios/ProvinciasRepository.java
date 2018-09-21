package es.vsanchezrod.proyectorest.persistencia.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.vsanchezrod.proyectorest.persistencia.modelos.Provincia;

@Repository
public class ProvinciasRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProvinciasRepository.class);
	
	public ProvinciasRepository() {
		LOGGER.info("Constructor: ProvinciasRepository");
	}
	
	public List<Provincia> obtenerProvincias() {
		
		List<Provincia> provincias = new ArrayList<>();
		
		provincias.add(new Provincia (2, "Albacete"));
		provincias.add(new Provincia (3, "Alicante/Alacant"));
		provincias.add(new Provincia (4, "Almería"));
		provincias.add(new Provincia (1, "Araba/Álava"));
		provincias.add(new Provincia (33, "Asturias"));
		provincias.add(new Provincia (5, "Ávila"));
		provincias.add(new Provincia (6, "Badajoz"));
		provincias.add(new Provincia (7, "Balears, Illes"));
		provincias.add(new Provincia (8, "Barcelona"));
		provincias.add(new Provincia (48, "Bizkaia"));
		provincias.add(new Provincia (9, "Burgos"));
		provincias.add(new Provincia (10, "Cáceres"));
		provincias.add(new Provincia (11, "Cádiz"));
		provincias.add(new Provincia (39, "Cantabria"));
		provincias.add(new Provincia (12, "Castellón/Castelló"));
		provincias.add(new Provincia (13, "Ciudad Real"));
		provincias.add(new Provincia (14, "Córdoba"));
		provincias.add(new Provincia (15, "Coruña, A"));
		provincias.add(new Provincia (16, "Cuenca"));
		provincias.add(new Provincia (20, "Gipuzkoa"));
		provincias.add(new Provincia (17, "Girona"));
		provincias.add(new Provincia (18, "Granada"));
		provincias.add(new Provincia (19, "Guadalajara"));
		provincias.add(new Provincia (21, "Huelva"));
		provincias.add(new Provincia (22, "Huesca"));
		provincias.add(new Provincia (23, "Jaén"));
		provincias.add(new Provincia (24, "León"));
		provincias.add(new Provincia (25, "Lleida"));
		provincias.add(new Provincia (27, "Lugo"));
		provincias.add(new Provincia (28, "Madrid"));
		provincias.add(new Provincia (29, "Málaga"));
		provincias.add(new Provincia (30, "Murcia"));
		provincias.add(new Provincia (31, "Navarra"));
		provincias.add(new Provincia (32, "Ourense"));
		provincias.add(new Provincia (34, "Palencia"));
		provincias.add(new Provincia (35, "Palmas, Las"));
		provincias.add(new Provincia (36, "Pontevedra"));
		provincias.add(new Provincia (26, "Rioja, La"));
		provincias.add(new Provincia (37, "Salamanca"));
		provincias.add(new Provincia (38, "Santa Cruz de Tenerife"));
		provincias.add(new Provincia (40, "Segovia"));
		provincias.add(new Provincia (41, "Sevilla"));
		provincias.add(new Provincia (42, "Soria"));
		provincias.add(new Provincia (43, "Tarragona"));
		provincias.add(new Provincia (44, "Teruel"));
		provincias.add(new Provincia (45, "Toledo"));
		provincias.add(new Provincia (46, "Valencia/València"));
		provincias.add(new Provincia (47, "Valladolid"));
		provincias.add(new Provincia (49, "Zamora"));
		provincias.add(new Provincia (50, "Zaragoza"));
		provincias.add(new Provincia (51, "Ceuta"));
		provincias.add(new Provincia (52, "Melilla"));
		
		return provincias;
	}
	
	
	
}
