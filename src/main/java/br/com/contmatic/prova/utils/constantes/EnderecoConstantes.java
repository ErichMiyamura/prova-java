package br.com.contmatic.prova.utils.constantes;

public class EnderecoConstantes {

	// numericos
	// RUA
	public static final int ENDERECO_RUA_TAMANHO_MINIMO = 3;
	public static final int ENDERECO_RUA_TAMANHO_MAXIMO = 60;
	// BAIRRO
	public static final int ENDERECO_BAIRRO_TAMANHO_MINIMO = 2;
	public static final int ENDERECO_BAIRRO_TAMANHO_MAXIMO = 60;
	// NUMERO
	public static final int ENDERECO_NUMERO_TAMANHO_MINIMO = 1;
	public static final int ENDERECO_NUMERO_TAMANHO_MAXIMO = 999999;

	// mensagens
	// RUA
	public static final String MENSAGEM_RUA_NULO = "Rua não pode estar em branco.";
	public static final String MENSAGEM_RUA_VAZIO = "Rua não pode estar vazio.";
	public static final String MENSAGEM_RUA_CARACTER_ESPECIAIS = "Rua não deve conter caracteres especiais.";
	public static final String MENSAGEM_RUA_TAMANHO = "Rua deve ter no mínimo " + ENDERECO_RUA_TAMANHO_MINIMO + " e no máximo " + ENDERECO_RUA_TAMANHO_MAXIMO + " caracteres";
	// BAIRRO
	public static final String MENSAGEM_BAIRRO_NULO = "Bairro não pode estar em branco.";
	public static final String MENSAGEM_BAIRRO_VAZIO = "Bairro não pode estar vazio.";
	public static final String MENSAGEM_BAIRRO_CARACTER_NUMERICO = "Bairro não deve conter número.";
	public static final String MENSAGEM_BAIRRO_TAMANHO = "Bairro deve ter no mínimo " + ENDERECO_BAIRRO_TAMANHO_MINIMO + " e no máximo " + ENDERECO_BAIRRO_TAMANHO_MAXIMO + " caracteres";
	// NUMERO
	public static final String MENSAGEM_NUMERO_NULO = "Número do endereço não pode estar em branco.";
	public static final String MENSAGEM_NUMERO_TAMANHO = "Número do endereço deve ser no mínimo " + ENDERECO_NUMERO_TAMANHO_MINIMO + " e no máximo " + ENDERECO_NUMERO_TAMANHO_MAXIMO;
	// COMPLEMENTO
	public static final String MENSAGEM_COMPLEMENTO_NULO = "Complemento não pode estar em branco.";
	public static final String MENSAGEM_COMPLEMENTO_VAZIO = "Complemento não pode estar vazio.";
	public static final String MENSAGEM_COMPLEMENTO_ALFANUMERICO = "Complemento não deve conter caracteres especiais.";
	// CEP
	public static final String MENSAGEM_CEP_NULO = "CEP não pode estar em branco.";
	public static final String MENSAGEM_CEP_VAZIO = "CEP não pode estar vazio.";
	public static final String MENSAGEM_REGEX_CEP = "CEP não deve conter letras.";
	// CIDADE
	public static final String MENSAGEM_CIDADE_NULO = "Cidade não pode estar em branco.";

	private EnderecoConstantes() {
	}

}
