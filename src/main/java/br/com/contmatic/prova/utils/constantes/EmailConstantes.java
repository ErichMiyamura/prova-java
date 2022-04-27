package br.com.contmatic.prova.utils.constantes;

public class EmailConstantes {

	// numericos
	// TIPO EMAIL
	public static final int TIPO_EMAIL_TAMANHO_MINIMO = 3;
	public static final int TIPO_EMAIL_TAMANHO_MAXIMO = 60;

	// mensagens
	// ENDERECO EMAIL
	public static final String MENSAGEM_EMAIL_NULO = "Email não pode estar em branco.";
	public static final String MENSAGEM_EMAIL_VAZIO = "Email não pode estar vazio.";
	public static final String MENSAGEM_REGEX_EMAIL = "Email não deve ter caracteres especiais e números após o símbolo arroba.";
	// TIPO EMAIL
	public static final String MENSAGEM_TIPO_EMAIL_NULO = "Email não pode estar em branco.";
	public static final String MENSAGEM_TIPO_EMAIL_VAZIO = "Email não pode estar vazio.";
	public static final String MENSAGEM_TIPO_EMAIL_CARACTER_NUMERICO = "Tipo de Email não deve conter número.";
	public static final String MENSAGEM_TIPO_EMAIL_TAMANHO = "Tipo de Email deve ter no mínimo " + TIPO_EMAIL_TAMANHO_MINIMO + " e no máximo " + TIPO_EMAIL_TAMANHO_MAXIMO + " caracteres";

}
