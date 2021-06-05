package br.com.devweb.colaborador.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "RH_COLABORADOR")
public class ColaboradorEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_COLABORADOR")
	@SequenceGenerator(name = "GEN_SEQ_COLABORADOR", sequenceName = "SEQ_COLABORADOR", initialValue = 1, allocationSize = 1)
	@Column(name = "ID_COLABORADOR", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "RENDA_DIARIA", precision = 7, scale = 2, nullable = false)
	private BigDecimal rendaDiaria;
	
	@Column(name = "RENDA_Bruta", precision = 7, scale = 2, nullable = false)
	private BigDecimal rendaBruta;

	public ColaboradorEntity() {
	}

	public ColaboradorEntity(Long id, String nome, BigDecimal rendaDiaria, BigDecimal rendaBruta) {
		super();
		this.id = id;
		this.nome = nome;
		this.rendaDiaria = rendaDiaria;
		this.rendaBruta = rendaBruta;
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

	public BigDecimal getRendaDiaria() {
		return rendaDiaria;
	}

	public void setRendaDiaria(BigDecimal rendaDiaria) {
		this.rendaDiaria = rendaDiaria;
	}

	public BigDecimal getRendaBruta() {
		return rendaBruta;
	}

	public void setRendaBruta(BigDecimal rendaBruta) {
		this.rendaBruta = rendaBruta;
	}

	@Override
	public String toString() {
		return "ColaboradorEntity [id=" + id + ", nome=" + nome + ", rendaDiaria=" + rendaDiaria + ", rendaMBruta="
				+ rendaBruta + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColaboradorEntity other = (ColaboradorEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
