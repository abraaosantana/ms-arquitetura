package br.com.devweb.autorizacao.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.autorizacao.domain.client.UsuarioFeingClient;
import br.com.devweb.autorizacao.domain.model.UsuarioModel;

@Service
public class UsuarioService {

	private static Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioFeingClient usuarioFeingClient;

	public UsuarioModel buscarPorEmail(String email) {

		UsuarioModel usuario = null;
		try {
			usuario = usuarioFeingClient.buscarUsuarioPorEmail(email).getBody();
			LOG.info("Usuário encontrado por email: {}", email);
		} catch (Exception e) {
			String erro = String.format("Usuário não encontrado por email: %s" , email);
			LOG.error(erro);
			throw new IllegalArgumentException(erro);
		}
		
		return usuario;
	}

}
