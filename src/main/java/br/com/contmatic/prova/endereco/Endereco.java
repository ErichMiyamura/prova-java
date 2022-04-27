package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.ENDERECO_BAIRRO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.ENDERECO_BAIRRO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.ENDERECO_NUMERO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.ENDERECO_NUMERO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.ENDERECO_RUA_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.ENDERECO_RUA_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_BAIRRO_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_BAIRRO_NULO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_BAIRRO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_BAIRRO_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_CEP_NULO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_CEP_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_CIDADE_NULO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_COMPLEMENTO_ALFANUMERICO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_COMPLEMENTO_NULO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_COMPLEMENTO_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_NUMERO_NULO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_NUMERO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_REGEX_CEP;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_RUA_CARACTER_ESPECIAIS;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_RUA_NULO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_RUA_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EnderecoConstantes.MENSAGEM_RUA_VAZIO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_ALFANUMERICO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CEP;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarAlfanumerico;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarRegex;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoNumeroInteiro;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

public class Endereco {
	
	private String rua;
	
	private String bairro;
	
	private Integer numero;
	
	private String complemento;
	
	private String cep;
	
	private Cidade cidade; 
	
	public Endereco(Integer numero, String cep) {
		setNumero(numero); 
		setCep(cep);
	}

	public Endereco(String rua, String bairro, Integer numero, String complemento, String cep, Cidade cidade) {
		setRua(rua);  
		setBairro(bairro);  
		setNumero(numero); 
		setComplemento(complemento); 
		setCep(cep); 
		setCidade(cidade);
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		validarNulo(rua, MENSAGEM_RUA_NULO);
		validarVazio(rua, MENSAGEM_RUA_VAZIO);
		validarAlfanumerico(rua, REGEX_ALFANUMERICO, MENSAGEM_RUA_CARACTER_ESPECIAIS);
		validarTamanhoString(rua, ENDERECO_RUA_TAMANHO_MINIMO, ENDERECO_RUA_TAMANHO_MAXIMO, MENSAGEM_RUA_TAMANHO);
		this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		validarNulo(bairro, MENSAGEM_BAIRRO_NULO);
		validarVazio(bairro, MENSAGEM_BAIRRO_VAZIO);
		validarCaracter(bairro, REGEX_CARACTER, MENSAGEM_BAIRRO_CARACTER_NUMERICO);
		validarTamanhoString(bairro, ENDERECO_BAIRRO_TAMANHO_MINIMO, ENDERECO_BAIRRO_TAMANHO_MAXIMO, MENSAGEM_BAIRRO_TAMANHO);
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		validarNulo(numero, MENSAGEM_NUMERO_NULO);
		validarTamanhoNumeroInteiro(numero, ENDERECO_NUMERO_TAMANHO_MINIMO, ENDERECO_NUMERO_TAMANHO_MAXIMO, MENSAGEM_NUMERO_TAMANHO);
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		validarNulo(complemento, MENSAGEM_COMPLEMENTO_NULO);
		validarVazio(complemento, MENSAGEM_COMPLEMENTO_VAZIO);
		validarAlfanumerico(complemento, REGEX_ALFANUMERICO, MENSAGEM_COMPLEMENTO_ALFANUMERICO);
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		validarNulo(cep, MENSAGEM_CEP_NULO);
		validarVazio(cep, MENSAGEM_CEP_VAZIO);
		validarRegex(cep, REGEX_CEP, MENSAGEM_REGEX_CEP);
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		validarNulo(cidade, MENSAGEM_CIDADE_NULO);
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cep.hashCode();
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
		Endereco other = (Endereco) obj;
		if (!cep.equals(other.cep)) 
			return false;
		return numero.equals(other.numero);
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Endereco [rua=").append(rua)
				.append(", numero=").append(numero)
			    .append(", complemento=").append(complemento)
			    .append(", cep=").append(cep)
			    .append(", cidade=").append(cidade)
			    .append("]")
			    .toString();
	}

}
