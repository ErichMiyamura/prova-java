package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.utils.constantes.EmailConstantes.MENSAGEM_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.MENSAGEM_EMAIL_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.MENSAGEM_REGEX_EMAIL;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.MENSAGEM_TIPO_EMAIL_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.MENSAGEM_TIPO_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.MENSAGEM_TIPO_EMAIL_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.MENSAGEM_TIPO_EMAIL_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.TIPO_EMAIL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EmailConstantes.TIPO_EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_EMAIL;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarRegex;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

import java.util.Objects;

public class Email {
	
	private String endereco;
	
	private String tipo;
	
	public Email(String endereco) {
		setEndereco(endereco);
	} 

	public Email(String endereco, String tipo) {
		setEndereco(endereco);
		setTipo(tipo);
	} 

	public String getEndereco() {
		return endereco; 
	}

	public void setEndereco(String endereco) {
		validarNulo(endereco, MENSAGEM_EMAIL_NULO);
		validarVazio(endereco, MENSAGEM_EMAIL_VAZIO);
		validarRegex(endereco, REGEX_EMAIL, MENSAGEM_REGEX_EMAIL); 
		this.endereco = endereco;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		validarNulo(tipo, MENSAGEM_TIPO_EMAIL_NULO);
		validarVazio(tipo, MENSAGEM_TIPO_EMAIL_VAZIO);
		validarCaracter(tipo, REGEX_CARACTER, MENSAGEM_TIPO_EMAIL_CARACTER_NUMERICO);
		validarTamanhoString(tipo, TIPO_EMAIL_TAMANHO_MINIMO, TIPO_EMAIL_TAMANHO_MAXIMO, MENSAGEM_TIPO_EMAIL_TAMANHO); 
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(endereco, other.endereco);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Email [enderecoEmail=").append(endereco)
				.append(", tipo=").append(tipo)
			    .append("]")
			    .toString();
	}

}
