package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.ESTADO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.ESTADO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.ESTADO_PAIS_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.ESTADO_PAIS_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.ESTADO_SIGLA_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.ESTADO_SIGLA_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_NOME_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_NOME_NULO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_NOME_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_NOME_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_PAIS_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_PAIS_NULO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_PAIS_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_PAIS_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_SIGLA_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_SIGLA_NULO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_SIGLA_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EstadoConstantes.MENSAGEM_SIGLA_VAZIO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

public class Estado {
	
	private String nome;
	
	private String sigla;
	
	private String pais; 
	
	public Estado(String nome, String sigla, String pais) {
		setNome(nome); 
		setSigla(sigla);
		setPais(pais);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MENSAGEM_NOME_NULO);
		validarVazio(nome, MENSAGEM_NOME_VAZIO);
		validarCaracter(nome, REGEX_CARACTER, MENSAGEM_NOME_CARACTER_NUMERICO);
		validarTamanhoString(nome, ESTADO_NOME_TAMANHO_MINIMO, ESTADO_NOME_TAMANHO_MAXIMO, MENSAGEM_NOME_TAMANHO);
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		validarNulo(sigla, MENSAGEM_SIGLA_NULO);
		validarVazio(sigla, MENSAGEM_SIGLA_VAZIO);
		validarCaracter(sigla, REGEX_CARACTER, MENSAGEM_SIGLA_CARACTER_NUMERICO);
		validarTamanhoString(sigla, ESTADO_SIGLA_TAMANHO_MINIMO, ESTADO_SIGLA_TAMANHO_MAXIMO, MENSAGEM_SIGLA_TAMANHO);
		this.sigla = sigla;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		validarNulo(pais, MENSAGEM_PAIS_NULO);
		validarVazio(pais, MENSAGEM_PAIS_VAZIO);
		validarCaracter(pais, REGEX_CARACTER, MENSAGEM_PAIS_CARACTER_NUMERICO);
		validarTamanhoString(pais, ESTADO_PAIS_TAMANHO_MINIMO, ESTADO_PAIS_TAMANHO_MAXIMO, MENSAGEM_PAIS_TAMANHO);
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nome.hashCode();
		result = prime * result + pais.hashCode();
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
		Estado other = (Estado) obj;
		if (!nome.equals(other.nome))
			return false;
		return pais.equals(other.pais);
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Estado [nome=").append(nome)
				.append(", sigla=").append(sigla)
			    .append(", pais=").append(pais)
			    .append("]")
			    .toString();
	}
	
}
