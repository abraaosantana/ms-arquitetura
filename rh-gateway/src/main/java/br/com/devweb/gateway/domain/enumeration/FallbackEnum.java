package br.com.devweb.gateway.domain.enumeration;

public enum FallbackEnum {

	RH_MS_USUARIO(1, "Consulta de Usuários", "A API de usuários está demorando muito para responder ou está inativa. "
			+ "Por favor, tente novamente mais tarde");

	Integer codigo;
	String descricao;
	String mesagem;

	private FallbackEnum(Integer codigo, String descricao, String mesagem) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.mesagem = mesagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getMesagem() {
		return mesagem;
	}

}
