package br.com.devweb.pagamento.domain.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.devweb.pagamento.domain.entities.ColaboradorEntity;
import br.com.devweb.pagamento.domain.entities.PagamentoEntity;

@Service
public class PagamentoService {

	@Value(value = "${rh-ms.colaborador.host}")
	private String colaboradorHost;

	@Autowired
	private RestTemplate restTemplate;

	private static final String PATH_COLABORADOR = "/v1/colaboradores/{idColaborador}";

	public PagamentoEntity getPagamento(Long idColaborador, BigDecimal diasTrabalhados) {

		Map<String, String> uriVariaveis = new HashMap<>();
		uriVariaveis.put("idColaborador", idColaborador.toString());

		String url = String.join("", colaboradorHost, PATH_COLABORADOR);

		ColaboradorEntity colaborador = restTemplate.getForObject(url, ColaboradorEntity.class, uriVariaveis);

		return new PagamentoEntity(colaborador.getNome(), colaborador.getRendaDiaria(), diasTrabalhados);

	}

}
