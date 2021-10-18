package br.com.blogDavanse.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.blogDavanse.model.Usuario;

/**
 * @author Priscila Davanse
 * @version 1.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}