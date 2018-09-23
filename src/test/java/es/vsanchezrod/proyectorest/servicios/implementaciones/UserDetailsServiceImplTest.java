package es.vsanchezrod.proyectorest.servicios.implementaciones;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import es.vsanchezrod.proyectorest.persistencia.modelos.Usuario;
import es.vsanchezrod.proyectorest.persistencia.repositorios.UsuariosRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsServiceImplTest {
	
	@Autowired
	private UsuariosRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Ignore
	@Test
	public void test() {
		Usuario usuario = new Usuario();
		usuario.setEmail("kaka");
		usuario.setPassword(passwordEncoder.encode("lala"));

		usuarioRepository.save(usuario);
			
	}

}
