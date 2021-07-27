package br.com.devweb.autorizacao.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.autorizacao.domain.model.UsuarioModel;
import br.com.devweb.autorizacao.domain.service.UsuarioService;

@RestController
@RequestMapping(value = "/v1/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/pesquisa")
	public ResponseEntity<UsuarioModel> buscarUsuarioPorEmail(@RequestParam String email) {
		try {
			UsuarioModel usuario = usuarioService.buscarPorEmail(email);
			return ResponseEntity.ok(usuario);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

}
