package br.com.devweb.gateway.api.v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.gateway.domain.enumeration.FallbackEnum;


@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/usuarios")
    public ResponseEntity<String> usuario() {
        return ResponseEntity.internalServerError()
        		.body(FallbackEnum.RH_MS_USUARIO.getMesagem());
    }

}
