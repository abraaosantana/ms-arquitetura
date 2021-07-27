package br.com.devweb.autorizacao.domain.model;

import java.io.Serializable;

public class FuncaoModel implements Serializable {

	private static final long serialVersionUID = -757013924056777859L;

	private Long id;

	private String nome;

	public FuncaoModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
