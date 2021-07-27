package br.com.devweb.usuario.domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SEG_USUARIO")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 4551449222466630700L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_SEG_USUARIO")
	@SequenceGenerator(name = "GEN_SEQ_SEG_USUARIO", sequenceName = "SEQ_SEG_USUARIO", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_USUARIO", unique = true, nullable = false)
	private Long id;

	@Column(name = "NM_USUARIO", nullable = false)
	private String nome;

	@Column(name = "DS_EMAIL", unique = true, nullable = false)
	private String email;

	@Column(name = "COD_SENHA", nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SEG_USUARIO_FUNCAO", 
		joinColumns = @JoinColumn(name = "ID_USUARIO"), 
		inverseJoinColumns = @JoinColumn(name = "ID_FUNCAO"), 
		foreignKey = @ForeignKey(name = "FK_USUARIO_FUNCAO"))
	private Set<FuncaoEntity> funcoes = new HashSet<>();

	public UsuarioEntity() {
		super();
	}

	public UsuarioEntity(Long id, String nome, String email, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<FuncaoEntity> getFuncoes() {
		return funcoes;
	}

}
