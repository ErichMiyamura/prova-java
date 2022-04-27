package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_CODIGO_NULO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_CODIGO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_NOME_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_NOME_NULO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_NOME_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_NOME_VAZIO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_REGEX_CODIGO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_VALOR_NULO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.MENSAGEM_VALOR_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.PRODUTO_CODIGO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.PRODUTO_CODIGO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.PRODUTO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.PRODUTO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.PRODUTO_VALOR_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.ProdutoConstantes.PRODUTO_VALOR_MINIMO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CODIGO;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarRegex;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoNumeroDecimal;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto extends Auditoria {
	
	private String codigo; 
	
	private String nome;
	 
	private BigDecimal valor;
	
	public Produto(String codigo) { 
		setCodigo(codigo); 
	}
 
	public Produto(String codigo, String nome, BigDecimal valor) {
		setCodigo(codigo);
		setNome(nome);
		setValor(valor);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) { 
		validarNulo(codigo, MENSAGEM_CODIGO_NULO);
		validarTamanhoString(codigo, PRODUTO_CODIGO_TAMANHO_MINIMO, PRODUTO_CODIGO_TAMANHO_MAXIMO, MENSAGEM_CODIGO_TAMANHO);
		validarRegex(codigo, REGEX_CODIGO, MENSAGEM_REGEX_CODIGO);
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, MENSAGEM_NOME_NULO);
		validarVazio(nome, MENSAGEM_NOME_VAZIO);
		validarCaracter(nome, REGEX_CARACTER, MENSAGEM_NOME_CARACTER_NUMERICO);
		validarTamanhoString(nome, PRODUTO_NOME_TAMANHO_MINIMO, PRODUTO_NOME_TAMANHO_MAXIMO, MENSAGEM_NOME_TAMANHO); 
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	} 

	public void setValor(BigDecimal valor) {
		validarNulo(valor, MENSAGEM_VALOR_NULO);
		validarTamanhoNumeroDecimal(valor, PRODUTO_VALOR_MINIMO, PRODUTO_VALOR_MAXIMO, MENSAGEM_VALOR_TAMANHO);
		this.valor = valor;
	}

	@Override
	public int hashCode() { 
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) 
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	public String toString() {
		return new StringBuilder().append("Produto [cod=").append(codigo)
				.append(", nome=").append(nome)
			    .append(", valor=").append(valor)
			    .append("]")
			    .toString();
	}

}
