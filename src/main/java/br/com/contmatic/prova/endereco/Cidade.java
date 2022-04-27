package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.CIDADE_CODIGO_IBGE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.CIDADE_CODIGO_IBGE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.CIDADE_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.CIDADE_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_CODIGO_IBGE_NULO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_CODIGO_IBGE_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_CODIGO_IBGE_VAZIO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_ESTADO_NULO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_NOME_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_NOME_NULO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_NOME_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_NOME_VAZIO;
import static br.com.contmatic.prova.utils.constantes.CidadeConstantes.MENSAGEM_REGEX_CODIGO_IBGE;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CODIGO;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarRegex;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

public class Cidade {
	
	private String nome;
	 
	private String codigoIbge;
	
	private Estado estado; 
	 
	public Cidade(String codigoIbge) {
		setCodigoIbge(codigoIbge);
	} 
	
	public Cidade(String nome, String codigoIbge, Estado estado) {  
		setNome(nome);
		setCodigoIbge(codigoIbge);
		setEstado(estado);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MENSAGEM_NOME_NULO);
		validarVazio(nome, MENSAGEM_NOME_VAZIO);
		validarCaracter(nome, REGEX_CARACTER, MENSAGEM_NOME_CARACTER_NUMERICO);
		validarTamanhoString(nome, CIDADE_NOME_TAMANHO_MINIMO, CIDADE_NOME_TAMANHO_MAXIMO, MENSAGEM_NOME_TAMANHO);
		this.nome = nome;
	}

	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		validarNulo(codigoIbge, MENSAGEM_CODIGO_IBGE_NULO);
		validarVazio(codigoIbge, MENSAGEM_CODIGO_IBGE_VAZIO);
		validarTamanhoString(codigoIbge, CIDADE_CODIGO_IBGE_TAMANHO_MINIMO, CIDADE_CODIGO_IBGE_TAMANHO_MAXIMO, MENSAGEM_CODIGO_IBGE_TAMANHO);
		validarRegex(codigoIbge, REGEX_CODIGO, MENSAGEM_REGEX_CODIGO_IBGE);
		this.codigoIbge = codigoIbge;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		validarNulo(estado, MENSAGEM_ESTADO_NULO);
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoIbge.hashCode();
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
		Cidade other = (Cidade) obj;
		return codigoIbge.equals(other.codigoIbge);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Cidade [nome=").append(nome)
				.append(", codigoIbge=").append(codigoIbge)
			    .append(", estado=").append(estado)
			    .append("]")
			    .toString();
	}
	
}
