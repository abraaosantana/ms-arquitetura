package br.com.devweb.autorizacao.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UsuarioModel implements Serializable {

	private static final long serialVersionUID = -8128841360815931608L;

	private Long id;

	private String nome;

	private String email;

	private String password;

	private Set<FuncaoModel> funcoes = new HashSet<>();

	public UsuarioModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Set<FuncaoModel> getFuncoes() {
		return funcoes;
	}

}
