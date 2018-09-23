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

import es.vsanchezrod.proyectorest.persistencia.modelos.Rol;
import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	// username ==> usuario.email
    	final Usuario usuario = usuariosRepository.findByEmail(username);
    	    	
        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("El usuario '%s' no existe", username));
        }
		List<Rol> roles = new ArrayList<>();
		Rol rolU = new Rol("Rol1", "lalalal");
		roles.add(rolU);
		
        usuario.setRoles(roles);
        
        final List<GrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        return new User(usuario.getEmail(), usuario.getPassword(), authorities);
    }
}