package br.com.devweb.colaborador.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.colaborador.domain.entities.ColaboradorEntity;
import br.com.devweb.colaborador.domain.repositories.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public List<ColaboradorEntity> listarTodos() {
		return colaboradorRepository.findAll();
	}
	
	public Optional<ColaboradorEntity> buscarPorId(Long id) {
		return colaboradorRepository.findById(id);
	}

}
