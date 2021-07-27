package br.com.devweb.user.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SEG_FUNCAO")
public class FuncaoEntity implements Serializable {

	private static final long serialVersionUID = 4687982923699478225L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_SEG_FUNCAO")
	@SequenceGenerator(name = "GEN_SEQ_SEG_FUNCAO", sequenceName = "SEQ_SEG_FUNCAO", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_FUNCAO", unique = true, nullable = false)
	private Long id;

	@Column(name = "NM_FUNCAO", nullable = false)
	private String nome;

	public FuncaoEntity() {
		super();
	}

	public FuncaoEntity(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
