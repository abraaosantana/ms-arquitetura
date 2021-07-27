package br.com.devweb.autorizacao.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.devweb.autorizacao.domain.model.UsuarioModel;

@Component
@FeignClient(name = "rh-ms-usuario", path = "/v1/usuarios")
public interface UsuarioFeingClient {

	@GetMapping(value = "/pesquisa")
	ResponseEntity<UsuarioModel> buscarUsuarioPorEmail(@RequestParam("email") String email);

}
