package br.com.blogDavanse.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import br.com.blogDavanse.model.Usuario;

/**
 * @author Priscila Davanse
 * @version 1.0
 */
public class UserDetailsImplements implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String email;
	private String senha;

	public UserDetailsImplements(Usuario usuario) {
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}

	public UserDetailsImplements() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
