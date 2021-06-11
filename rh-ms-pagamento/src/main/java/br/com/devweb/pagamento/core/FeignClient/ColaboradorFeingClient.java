package br.com.devweb.pagamento.core.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.devweb.pagamento.domain.entities.ColaboradorEntity;


@Component
@FeignClient(name = "rh-ms-colaborador", url = "localhost:8001", path = "/v1/colaboradores")
public interface ColaboradorFeingClient {

	@GetMapping(value = "/{idColaborador}")
	ResponseEntity<ColaboradorEntity> buscarColaboradorPorId(@PathVariable Long idColaborador);

}
