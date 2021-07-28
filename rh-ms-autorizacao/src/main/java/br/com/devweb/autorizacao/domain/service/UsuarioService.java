package br.com.devweb.autorizacao.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.devweb.autorizacao.domain.client.UsuarioFeingClient;
import br.com.devweb.autorizacao.domain.model.UsuarioModel;

@Service
public class UsuarioService implements UserDetailsService {

	private static Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioFeingClient usuarioFeingClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioModel usuario = null;
		
		try {
			usuario = usuarioFeingClient.buscarUsuarioPorEmail(username).getBody();
			LOG.info("Usuário encontrado por email: {}", username);
		} catch (Exception e) {
			String erro = String.format("Usuário não encontrado por email: %s" , username);
			LOG.error(erro);
			throw new UsernameNotFoundException(erro);
		}
		
		return usuario;
	}

}
