package br.com.blogDavanse.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.blogDavanse.model.Postagem;

/**
 * @author Priscila Davanse
 * @version 1.0
 */
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List<Postagem> findAllByTituloContainingIgnoreCase(String titutlo);
}
