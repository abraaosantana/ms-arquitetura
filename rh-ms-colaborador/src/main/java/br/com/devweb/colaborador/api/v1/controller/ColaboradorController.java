package br.com.devweb.colaborador.api.v1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.colaborador.domain.entity.ColaboradorEntity;
import br.com.devweb.colaborador.domain.service.ColaboradorService;

@RestController
@RequestMapping(value = "/v1/colaboradores")
public class ColaboradorController {
	
	private static Logger LOG = LoggerFactory.getLogger(ColaboradorController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorEntity>> buscarColaboradores() {
		List<ColaboradorEntity> colaboradores = colaboradorService.listarTodos(); 
		return ResponseEntity.ok(colaboradores);
	}
	
	@GetMapping(value = "/{idColaborador}")
	public ResponseEntity<ColaboradorEntity> buscarColaborador(@PathVariable Long idColaborador) {
		
		LOG.info(String.join("=", "PORTA", env.getProperty("local.server.port")));
		
		ColaboradorEntity colaborador = colaboradorService.buscarPorId(idColaborador).get(); 
		return ResponseEntity.ok(colaborador);
	}

}
