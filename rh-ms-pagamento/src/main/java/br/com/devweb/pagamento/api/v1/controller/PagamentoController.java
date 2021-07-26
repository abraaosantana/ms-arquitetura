package br.com.devweb.pagamento.api.v1.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.devweb.pagamento.domain.model.PagamentoModel;
import br.com.devweb.pagamento.domain.service.PagamentoService;

@RestController
@RequestMapping(value = "/v1/pagamentos")
public class PagamentoController {
	
	private static Logger LOG = LoggerFactory.getLogger(PagamentoController.class);

	@Autowired
	private Environment env;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@GetMapping(value = "/configs")
	public ResponseEntity<String> buscarConfigs() {
		LOG.info("Profile: {}", env.getProperty("test.config"));
		return ResponseEntity.ok(env.getProperty("test.config"));
	}	

	@HystrixCommand(fallbackMethod = "pagamentoColaboradorRedundancia")
	@GetMapping(value = "/{idColaborador}/dias/{diasTrabalhados}")
	public ResponseEntity<PagamentoModel> pagamentoColaborador(@PathVariable Long idColaborador,
			@PathVariable BigDecimal diasTrabalhados) {

		PagamentoModel infosPagamento = pagamentoService.getPagamentoFeingClient(idColaborador, diasTrabalhados);

		return ResponseEntity.ok(infosPagamento);
	}

	public ResponseEntity<PagamentoModel> pagamentoColaboradorRedundancia(Long idColaborador, BigDecimal diasTrabalhados) {
		final String falha = "FALHA - HYSTRIX FALLBACK";
		LOG.info("Profile: {}", falha);
		PagamentoModel infosPagamento = new PagamentoModel(falha, BigDecimal.TEN, diasTrabalhados);

		return ResponseEntity.ok(infosPagamento);
	}

}
