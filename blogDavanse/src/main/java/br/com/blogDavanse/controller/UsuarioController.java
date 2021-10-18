package br.com.blogDavanse.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.blogDavanse.model.UserLogin;
import br.com.blogDavanse.model.Usuario;
import br.com.blogDavanse.repository.UsuarioRepository;
import br.com.blogDavanse.service.UsuarioService;

/**
 * @author Priscila Davanse
 * @version 1.0
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping("/logar")
	public ResponseEntity<UserLogin> autentication(@Valid @RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(novoUsuario));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoUsuario));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
