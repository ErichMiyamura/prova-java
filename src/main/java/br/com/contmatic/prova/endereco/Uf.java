package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CODIGO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_NOME_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_NOME_NULO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_NOME_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_NOME_VAZIO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_PAIS_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_PAIS_NULO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_PAIS_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_PAIS_VAZIO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_SIGLA_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_SIGLA_NULO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_SIGLA_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_SIGLA_VAZIO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_UF_CODIGO_IBGE_NULO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_UF_CODIGO_IBGE_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_UF_CODIGO_IBGE_VAZIO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.MENSAGEM_UF_REGEX_CODIGO_IBGE;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_CODIGO_IBGE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_CODIGO_IBGE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_PAIS_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_PAIS_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_SIGLA_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.UfConstantes.UF_SIGLA_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarRegex;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

public class Uf {
	
	private String codigoIbge;
	
	private String nome;
	
	private String sigla;
	
	private String pais; 
	
	public Uf(String codigoIbge) {
		setCodigoIbge(codigoIbge);
	} 
	
	public Uf(String codigoIbge, String nome, String sigla, String pais) {
		setCodigoIbge(codigoIbge);
		setNome(nome); 
		setSigla(sigla);
		setPais(pais);
	}
	
	public String getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(String codigoIbge) {
		validarNulo(codigoIbge, MENSAGEM_UF_CODIGO_IBGE_NULO);
		validarVazio(codigoIbge, MENSAGEM_UF_CODIGO_IBGE_VAZIO);
		validarTamanhoString(codigoIbge, UF_CODIGO_IBGE_TAMANHO_MINIMO, UF_CODIGO_IBGE_TAMANHO_MAXIMO, MENSAGEM_UF_CODIGO_IBGE_TAMANHO);
		validarRegex(codigoIbge, REGEX_CODIGO, MENSAGEM_UF_REGEX_CODIGO_IBGE);
		this.codigoIbge = codigoIbge;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MENSAGEM_NOME_NULO);
		validarVazio(nome, MENSAGEM_NOME_VAZIO);
		validarCaracter(nome, REGEX_CARACTER, MENSAGEM_NOME_CARACTER_NUMERICO);
		validarTamanhoString(nome, UF_NOME_TAMANHO_MINIMO, UF_NOME_TAMANHO_MAXIMO, MENSAGEM_NOME_TAMANHO);
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		validarNulo(sigla, MENSAGEM_SIGLA_NULO);
		validarVazio(sigla, MENSAGEM_SIGLA_VAZIO);
		validarCaracter(sigla, REGEX_CARACTER, MENSAGEM_SIGLA_CARACTER_NUMERICO);
		validarTamanhoString(sigla, UF_SIGLA_TAMANHO_MINIMO, UF_SIGLA_TAMANHO_MAXIMO, MENSAGEM_SIGLA_TAMANHO);
		this.sigla = sigla;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		validarNulo(pais, MENSAGEM_PAIS_NULO);
		validarVazio(pais, MENSAGEM_PAIS_VAZIO);
		validarCaracter(pais, REGEX_CARACTER, MENSAGEM_PAIS_CARACTER_NUMERICO);
		validarTamanhoString(pais, UF_PAIS_TAMANHO_MINIMO, UF_PAIS_TAMANHO_MAXIMO, MENSAGEM_PAIS_TAMANHO);
		this.pais = pais;
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
		Uf other = (Uf) obj;
		if (!nome.equals(other.nome))
			return false;
		return pais.equals(other.pais);
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Uf [codigoIbge=").append(codigoIbge)
				.append(", nome=").append(nome)
				.append(", sigla=").append(sigla)
			    .append(", pais=").append(pais)
			    .append("]")
			    .toString();
	}
	
}
