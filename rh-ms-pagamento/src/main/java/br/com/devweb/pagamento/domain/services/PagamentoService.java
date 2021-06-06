package br.com.devweb.pagamento.domain.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.devweb.pagamento.domain.entities.PagamentoEntity;

@Service
public class PagamentoService {

	public PagamentoEntity getPagamento(long idColaborador, BigDecimal diasTrabalhados) {
		
		return new PagamentoEntity(String.format("Colaborador Mock: Identificador %s", idColaborador),
				BigDecimal.valueOf(200.00), diasTrabalhados);
	}

}
