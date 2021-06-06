package br.com.devweb.colaborador.api.resources.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.colaborador.domain.entities.ColaboradorEntity;
import br.com.devweb.colaborador.domain.services.ColaboradorService;

@RestController
@RequestMapping(value = "/v1/colaboradores")
public class ColaboradorResource {
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public ResponseEntity<List<ColaboradorEntity>> buscarColaboradores() {
		List<ColaboradorEntity> colaboradores = colaboradorService.listarTodos(); 
		return ResponseEntity.ok(colaboradores);
	}
	
	@GetMapping(value = "/{idColaborador}")
	public ResponseEntity<ColaboradorEntity> buscarColaborador(@PathVariable Long idColaborador) {
		ColaboradorEntity colaborador = colaboradorService.buscarPorId(idColaborador).get(); 
		return ResponseEntity.ok(colaborador);
	}

}
