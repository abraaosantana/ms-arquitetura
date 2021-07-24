package br.com.devweb.pagamento.domain.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.devweb.pagamento.domain.client.ColaboradorFeingClient;
import br.com.devweb.pagamento.domain.model.ColaboradorModel;
import br.com.devweb.pagamento.domain.model.PagamentoModel;

@Service
public class PagamentoService {

	@Autowired
	private RestTemplate colaboradorRestTemplate;
	
	@Autowired
	private ColaboradorFeingClient colaboradorFeingClient;
	
	@Value(value = "${rh-ms-colaborador.host}")
	private String colaboradorHost;

	private static final String PATH_COLABORADOR = "/v1/colaboradores/{idColaborador}";

	public PagamentoModel getPagamentoRestTemplate(Long idColaborador, BigDecimal diasTrabalhados) {
		
		Map<String, String> uriVariaveis = new HashMap<>();
		uriVariaveis.put("idColaborador", idColaborador.toString());
		
		String url = String.join("", colaboradorHost, PATH_COLABORADOR);
		ColaboradorModel colaborador = colaboradorRestTemplate.getForObject(url, ColaboradorModel.class, uriVariaveis);
		
		return new PagamentoModel(colaborador.getNome(), colaborador.getRendaDiaria(), diasTrabalhados);
		
	}
	
	public PagamentoModel getPagamentoFeingClient(Long idColaborador, BigDecimal diasTrabalhados) {
		
		ColaboradorModel colaborador = colaboradorFeingClient.buscarColaboradorPorId(idColaborador).getBody();
		
		return new PagamentoModel(colaborador.getNome(), colaborador.getRendaDiaria(), diasTrabalhados);
		
	}

}
