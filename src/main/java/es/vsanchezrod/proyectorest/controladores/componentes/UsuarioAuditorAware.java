package es.vsanchezrod.proyectorest.controladores.componentes;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioAuditorAware implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	}

	
}
