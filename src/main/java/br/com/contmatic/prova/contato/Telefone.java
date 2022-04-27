package br.com.contmatic.prova.contato;

import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_DDD;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_DDI;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_NUMEROS;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_DDD_NULO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_DDD_VAZIO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_DDI_NULO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_DDI_VAZIO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_REGEX_DDD;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_REGEX_DDI;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_REGEX_TELEFONE;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_TELEFONE_NULO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_TELEFONE_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_TELEFONE_VAZIO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_TIPO_TELEFONE_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_TIPO_TELEFONE_NULO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_TIPO_TELEFONE_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.MENSAGEM_TIPO_TELEFONE_VAZIO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.TELEFONE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.TIPO_TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.TelefoneConstantes.TIPO_TELEFONE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarRegex;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoTelefone;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

public class Telefone {
	
	private String ddi;

	private String ddd;

	private String numero;

	private String tipo;

	public Telefone(String ddi, String ddd, String numero) {
		setDdi(ddi);
		setDdd(ddd);
		setNumero(numero);
	}

	public Telefone(String ddi, String ddd, String numero, String tipo) {
		setDdi(ddi);
		setDdd(ddd);
		setNumero(numero);
		setTipo(tipo);
	}
	
	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		validarNulo(ddi, MENSAGEM_DDI_NULO);
		validarVazio(ddi, MENSAGEM_DDI_VAZIO);
		validarRegex(ddi, REGEX_DDI, MENSAGEM_REGEX_DDI);
		this.ddi = ddi;
	}
	
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		validarNulo(ddd, MENSAGEM_DDD_NULO);
		validarVazio(ddd, MENSAGEM_DDD_VAZIO);
		validarRegex(ddd, REGEX_DDD, MENSAGEM_REGEX_DDD);
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		validarNulo(numero, MENSAGEM_TELEFONE_NULO);
		validarVazio(numero, MENSAGEM_TELEFONE_VAZIO);
		validarRegex(numero, REGEX_NUMEROS, MENSAGEM_REGEX_TELEFONE);
		validarTamanhoTelefone(numero, TELEFONE_TAMANHO_MINIMO, TELEFONE_TAMANHO_MAXIMO, MENSAGEM_TELEFONE_TAMANHO);
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		validarNulo(tipo, MENSAGEM_TIPO_TELEFONE_NULO);
		validarVazio(tipo, MENSAGEM_TIPO_TELEFONE_VAZIO);
		validarCaracter(tipo, REGEX_CARACTER, MENSAGEM_TIPO_TELEFONE_CARACTER_NUMERICO);
		validarTamanhoString(tipo, TIPO_TELEFONE_TAMANHO_MINIMO, TIPO_TELEFONE_TAMANHO_MAXIMO, MENSAGEM_TIPO_TELEFONE_TAMANHO);
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ddi.hashCode();
		result = prime * result + ddd.hashCode();
		result = prime * result + numero.hashCode();
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
		Telefone other = (Telefone) obj;
		if (!ddi.equals(other.ddi))
			return false;
		if (!ddd.equals(other.ddd))
			return false;
		return numero.equals(other.numero);
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("Telefone [ddi=").append(ddi)
				.append(", ddd=").append(ddd)
				.append(", numero=").append(numero)
				.append(", tipo=").append(tipo)
				.append("]").toString();
	}

}
