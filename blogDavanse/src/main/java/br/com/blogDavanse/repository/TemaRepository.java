package br.com.blogDavanse.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.blogDavanse.model.Tema;

/**
 * @author Priscila Davanse
 * @version 1.0
 */
@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
