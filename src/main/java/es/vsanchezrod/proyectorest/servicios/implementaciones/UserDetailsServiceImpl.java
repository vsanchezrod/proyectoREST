package es.vsanchezrod.proyectorest.servicios.implementaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
		//final Usuario usuario = usuariosServicio.obtenerUsuarioPorNombreUsuario(username);
		
    	final Usuario usuario = new Usuario("john.doe", "$2a$10$zbiuPsYMxW28bvHC8GCLNuEoh.Ij15HZWCnjy1Ttpnv4PgJasDqPG");
    	
        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("El usuario '%s' no existe", username));
        }
		
        final List<GrantedAuthority> authorities = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        return new User(usuario.getNombreUsuario(), usuario.getPassword(), authorities);
    }
}