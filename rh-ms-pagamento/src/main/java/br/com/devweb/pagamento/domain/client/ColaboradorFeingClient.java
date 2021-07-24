package br.com.devweb.pagamento.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.devweb.pagamento.domain.model.ColaboradorModel;

@Component
@FeignClient(name = "rh-ms-colaborador", path = "/v1/colaboradores")
public interface ColaboradorFeingClient {

	@GetMapping(value = "/{idColaborador}")
	ResponseEntity<ColaboradorModel> buscarColaboradorPorId(@PathVariable Long idColaborador);

}
