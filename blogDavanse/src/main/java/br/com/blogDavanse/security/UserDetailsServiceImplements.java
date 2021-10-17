package br.com.blogDavanse.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import br.com.blogDavanse.model.Usuario;
import br.com.blogDavanse.repository.UsuarioRepository;

/**
 * @author Priscila Davanse
 * @version 1.0
 */
@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> user = repository.findByEmail(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + "Not Found."));

		return user.map(UserDetailsImplements::new).get();
	}
}