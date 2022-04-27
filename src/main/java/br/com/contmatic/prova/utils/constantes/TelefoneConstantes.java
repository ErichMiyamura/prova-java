package br.com.contmatic.prova.utils.constantes;

public class TelefoneConstantes {

	// numericos
	// NUMERO TELEFONE
	public static final int TELEFONE_TAMANHO_MINIMO = 8;
	public static final int TELEFONE_TAMANHO_MAXIMO = 11;
	// TIPO TELEFONE
	public static final int TIPO_TELEFONE_TAMANHO_MINIMO = 3;
	public static final int TIPO_TELEFONE_TAMANHO_MAXIMO = 60;

	// mensagens
	// DDI
	public static final String MENSAGEM_DDI_NULO = "DDI não pode estar em branco.";
	public static final String MENSAGEM_DDI_VAZIO = "DDI não pode estar vazio.";
	public static final String MENSAGEM_REGEX_DDI = "DDI está inválido.";
	// DDD
	public static final String MENSAGEM_DDD_NULO = "DDD não pode estar em branco.";
	public static final String MENSAGEM_DDD_VAZIO = "DDD não pode estar vazio.";
	public static final String MENSAGEM_REGEX_DDD = "DDD está inválido.";
	// NUMERO TELEFONE
	public static final String MENSAGEM_TELEFONE_NULO = "Telefone não pode estar em branco.";
	public static final String MENSAGEM_TELEFONE_VAZIO = "Telefone não pode estar vazio.";
	public static final String MENSAGEM_REGEX_TELEFONE = "Telefone aceita somente números.";
	public static final String MENSAGEM_TELEFONE_TAMANHO = "Telefone deve ter no mínimo " + TELEFONE_TAMANHO_MINIMO + " digitos e no máximo " + TELEFONE_TAMANHO_MAXIMO + " digitos";
	// TIPO TELEFONE
	public static final String MENSAGEM_TIPO_TELEFONE_NULO = "Telefone não pode estar em branco.";
	public static final String MENSAGEM_TIPO_TELEFONE_VAZIO = "Telefone não pode estar vazio.";
	public static final String MENSAGEM_TIPO_TELEFONE_CARACTER_NUMERICO = "Tipo de Telefone não deve conter número.";
	public static final String MENSAGEM_TIPO_TELEFONE_TAMANHO = "Tipo de Telefone deve ter no mínimo " + TIPO_TELEFONE_TAMANHO_MINIMO + " e no máximo " + TIPO_TELEFONE_TAMANHO_MAXIMO + " caracteres";
}
