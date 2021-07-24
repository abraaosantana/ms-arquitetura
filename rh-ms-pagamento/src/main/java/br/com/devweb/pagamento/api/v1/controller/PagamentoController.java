package br.com.devweb.pagamento.api.v1.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.pagamento.domain.model.PagamentoModel;
import br.com.devweb.pagamento.domain.service.PagamentoService;

@RestController
@RequestMapping(value = "/v1/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;

	@GetMapping(value = "/{idColaborador}/dias/{diasTrabalhados}")
	public ResponseEntity<PagamentoModel> pagamentoColaborador(@PathVariable Long idColaborador,
			                                                    @PathVariable BigDecimal diasTrabalhados) {

		PagamentoModel infosPagamento = pagamentoService.getPagamentoFeingClient(idColaborador, diasTrabalhados);

		return ResponseEntity.ok(infosPagamento);
	}

}
