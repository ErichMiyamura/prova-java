package br.com.contmatic.prova.utils.constantes;

public class EnderecoConstantes {

	// numericos
	// LOGRADOURO
	public static final int ENDERECO_LOGRADOURO_TAMANHO_MINIMO = 3;
	public static final int ENDERECO_LOGRADOURO_TAMANHO_MAXIMO = 60;
	// TIPO LOGRADOURO
	public static final int ENDERECO_TIPO_LOGRADOURO_TAMANHO_MINIMO = 3;
	public static final int ENDERECO_TIPO_LOGRADOURO_TAMANHO_MAXIMO = 60;
	// BAIRRO
	public static final int ENDERECO_BAIRRO_TAMANHO_MINIMO = 2;
	public static final int ENDERECO_BAIRRO_TAMANHO_MAXIMO = 60;
	// NUMERO
	public static final int ENDERECO_NUMERO_TAMANHO_MINIMO = 1;
	public static final int ENDERECO_NUMERO_TAMANHO_MAXIMO = 999999;

	// mensagens
	// CEP
	public static final String MENSAGEM_CEP_NULO = "CEP não pode estar em branco.";
	public static final String MENSAGEM_CEP_VAZIO = "CEP não pode estar vazio.";
	public static final String MENSAGEM_REGEX_CEP = "CEP não deve conter letras.";
	// NUMERO
	public static final String MENSAGEM_NUMERO_NULO = "Número do endereço não pode estar em branco.";
	public static final String MENSAGEM_NUMERO_TAMANHO = "Número do endereço deve ser no mínimo " + ENDERECO_NUMERO_TAMANHO_MINIMO + " e no máximo " + ENDERECO_NUMERO_TAMANHO_MAXIMO;
	// LOGRADOURO
	public static final String MENSAGEM_LOGRADOURO_NULO = "Logradouro não pode estar em branco.";
	public static final String MENSAGEM_LOGRADOURO_VAZIO = "Logradouro não pode estar vazio.";
	public static final String MENSAGEM_LOGRADOURO_CARACTER_ESPECIAIS = "Logradouro não deve conter caracteres especiais.";
	public static final String MENSAGEM_LOGRADOURO_TAMANHO = "Logradouro deve ter no mínimo " + ENDERECO_LOGRADOURO_TAMANHO_MINIMO + " e no máximo " + ENDERECO_LOGRADOURO_TAMANHO_MAXIMO + " caracteres";
	// TIPO LOGRADOURO
	public static final String MENSAGEM_TIPO_LOGRADOURO_NULO = "Tipo logradouro não pode estar em branco.";
	public static final String MENSAGEM_TIPO_LOGRADOURO_VAZIO = "Tipo logradouro não pode estar vazio.";
	public static final String MENSAGEM_TIPO_LOGRADOURO_CARACTER = "Tipo logradouro deve conter apenas letras e opcionalmente \".\" e \"'\".";
	public static final String MENSAGEM_TIPO_LOGRADOURO_TAMANHO = "Tipo logradouro deve ter no mínimo " + ENDERECO_TIPO_LOGRADOURO_TAMANHO_MINIMO + " e no máximo " + ENDERECO_TIPO_LOGRADOURO_TAMANHO_MAXIMO + " caracteres";
	// BAIRRO
	public static final String MENSAGEM_BAIRRO_NULO = "Bairro não pode estar em branco.";
	public static final String MENSAGEM_BAIRRO_VAZIO = "Bairro não pode estar vazio.";
	public static final String MENSAGEM_BAIRRO_CARACTER_NUMERICO = "Bairro não deve conter número.";
	public static final String MENSAGEM_BAIRRO_TAMANHO = "Bairro deve ter no mínimo " + ENDERECO_BAIRRO_TAMANHO_MINIMO + " e no máximo " + ENDERECO_BAIRRO_TAMANHO_MAXIMO + " caracteres";
	// COMPLEMENTO
	public static final String MENSAGEM_COMPLEMENTO_NULO = "Complemento não pode estar em branco.";
	public static final String MENSAGEM_COMPLEMENTO_VAZIO = "Complemento não pode estar vazio.";
	public static final String MENSAGEM_COMPLEMENTO_ALFANUMERICO = "Complemento não deve conter caracteres especiais.";
	// CIDADE
	public static final String MENSAGEM_CIDADE_NULO = "Cidade não pode estar em branco.";

	private EnderecoConstantes() {
	}

}
