package br.com.devweb.pagamento.domain.service.teste.dto;

import java.util.List;

public class ADto {

	private String nome;
	private List<String> registros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getRegistros() {
		return registros;
	}

	public void setRegistros(List<String> registros) {
		this.registros = registros;
	}

}
