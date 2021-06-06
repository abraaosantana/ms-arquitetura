package br.com.devweb.pagamento.api.resources.v1;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.pagamento.domain.entities.PagamentoEntity;
import br.com.devweb.pagamento.domain.services.PagamentoService;

@RestController
@RequestMapping(value = "/v1/pagamentos")
public class PagamentoResouce {

	@Autowired
	private PagamentoService pagamentoService;

	@GetMapping(value = "/{idColaborador}/dias/{diasTrabalhados}")
	public ResponseEntity<PagamentoEntity> pagamentoColaborador(@PathVariable Long idColaborador,
			                                                    @PathVariable BigDecimal diasTrabalhados) {

		PagamentoEntity infosPagamento = pagamentoService.getPagamentoFeingClient(idColaborador, diasTrabalhados);

		return ResponseEntity.ok(infosPagamento);
	}

}
