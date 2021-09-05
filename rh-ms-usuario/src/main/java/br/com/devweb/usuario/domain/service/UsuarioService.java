package br.com.devweb.usuario.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.usuario.domain.entity.UsuarioEntity;
import br.com.devweb.usuario.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public  List<UsuarioEntity> buscarUsuarios() {

		return usuarioRepository.findAll();
	}

	public  Optional<UsuarioEntity> buscarPorId(Long idUsuario) {

		return usuarioRepository.findById(idUsuario);
	}

	public UsuarioEntity buscarPorEmail(String email) {

		return usuarioRepository.findByEmail(email);
	}
}
