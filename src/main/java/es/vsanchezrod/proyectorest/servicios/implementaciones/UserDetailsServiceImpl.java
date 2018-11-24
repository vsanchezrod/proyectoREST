package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
    	final Usuario usuario = usuariosRepository.findByEmail(email);    	    	
        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("El usuario '%s' no existe", email));
        }
        
        final List<GrantedAuthority> authorities = new ArrayList<>();
        if(usuario.getRoles() != null) {   	
        	for(String rol: usuario.getRoles()) {
        		authorities.add(new SimpleGrantedAuthority(rol));
        	}       	
        }

        return new User(usuario.getId(), usuario.getPassword(), authorities);
    }
}