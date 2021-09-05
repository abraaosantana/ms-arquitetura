package br.com.devweb.usuario.api.v1.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.usuario.domain.entity.UsuarioEntity;
import br.com.devweb.usuario.domain.service.UsuarioService;

@RestController
@RequestMapping(value = "/v1/usuarios")
public class UsuarioController {

	private static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private Environment env;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/configs")
	public ResponseEntity<String> buscarConfigs() {
		return ResponseEntity.ok(env.getProperty("test.config"));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioEntity>> buscarUsuarios() {
		List<UsuarioEntity> usuarios = usuarioService.buscarUsuarios();
		if (usuarios == null || usuarios.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping(value = "/{idUsuario}")
	public ResponseEntity<UsuarioEntity> buscarUsuario(@PathVariable Long idUsuario) {

		LOG.info(String.join("=", "PORTA", env.getProperty("local.server.port")));

		Optional<UsuarioEntity> usuario = usuarioService.buscarPorId(idUsuario);
		
		if (!usuario.isPresent()) {
			return ResponseEntity.badRequest().body(new UsuarioEntity());
		}
		
		return ResponseEntity.ok(usuario.get());
	}

	@GetMapping(value = "/pesquisa")
	public ResponseEntity<UsuarioEntity> buscarUsuario(@RequestParam String email) {

		LOG.info(String.join("=", "PORTA", env.getProperty("local.server.port")));

		UsuarioEntity usuario = usuarioService.buscarPorEmail(email);
		
		if (usuario == null) {
			return ResponseEntity.badRequest().body(new UsuarioEntity());
		}
		
		return ResponseEntity.ok(usuario);
	}

}
