package br.com.devweb.pagamento.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class PagamentoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private BigDecimal rendaDiaria;
	private BigDecimal quantidadeDias;

	public PagamentoEntity() {

	}

	public PagamentoEntity(String nome, BigDecimal rendaDiaria, BigDecimal quantidadeDias) {
		super();
		this.nome = nome;
		this.rendaDiaria = rendaDiaria;
		this.quantidadeDias = quantidadeDias;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getRendaDiaria() {
		return rendaDiaria;
	}

	public void setRendaDiaria(BigDecimal rendaDiaria) {
		this.rendaDiaria = rendaDiaria;
	}

	public BigDecimal getQuantidadeDias() {
		return quantidadeDias;
	}

	public void setQuantidadeDias(BigDecimal quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}

	public BigDecimal getRendaTotal() {
		return rendaDiaria.multiply(quantidadeDias).setScale(2, RoundingMode.HALF_UP);
	}

}
