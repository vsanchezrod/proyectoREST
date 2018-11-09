package es.vsanchezrod.proyectorest.controladores.componentes;

import java.util.Base64;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationUtilComponent {

	public String obtenerUserName(String jwtToken) {
		
		// Se separa token por los . y nos quedamos con la parte de en medio q contiene la información del usuario
		final String[] composicionToken = jwtToken.split("\\.");
		final String infoUsuario = composicionToken[1];
		
		// Se utiliza decode para obtener la información
		final byte[] decodeBytes = Base64.getDecoder().decode(infoUsuario);
		String decodeInfo = new String(decodeBytes);
		
		// Se transforma un string en un JSONObject
		final JSONObject info = new JSONObject(decodeInfo);
		
		// Se accede al valor del id de usuario logado
		return info.getString("user_name");

	}
}
