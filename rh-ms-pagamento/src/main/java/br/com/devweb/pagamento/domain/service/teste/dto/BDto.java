package br.com.devweb.pagamento.domain.service.teste.dto;

import java.util.List;

public class BDto {

	private String nome;
	private String historico;
	private List<String> registros;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public List<String> getRegistros() {
		return registros;
	}

	public void setRegistros(List<String> registros) {
		this.registros = registros;
	}

}
