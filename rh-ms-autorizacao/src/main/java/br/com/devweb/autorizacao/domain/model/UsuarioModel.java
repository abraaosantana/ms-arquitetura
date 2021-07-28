package br.com.devweb.autorizacao.domain.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioModel implements UserDetails, Serializable {

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return funcoes.stream().map(x -> new SimpleGrantedAuthority(x.getNome()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
