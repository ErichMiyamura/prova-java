package br.com.contmatic.prova.utils.constantes;

public class CidadeConstantes {

	// numericos
	// NOME
	public static final int CIDADE_NOME_TAMANHO_MINIMO = 3;
	public static final int CIDADE_NOME_TAMANHO_MAXIMO = 60;
	// CODIGO IBGE
	public static final int CIDADE_CODIGO_IBGE_TAMANHO_MINIMO = 7;
	public static final int CIDADE_CODIGO_IBGE_TAMANHO_MAXIMO = 7;

	// mensagens
	// NOME
	public static final String MENSAGEM_NOME_NULO = "Nome não pode estar em branco.";
	public static final String MENSAGEM_NOME_VAZIO = "Nome não pode estar vazio.";
	public static final String MENSAGEM_NOME_CARACTER_NUMERICO = "Nome deve conter apenas letras e opcionalmente \".\" e \"'\".";
	public static final String MENSAGEM_NOME_TAMANHO = "Nome deve ter no mínimo " + CIDADE_NOME_TAMANHO_MINIMO + " e no máximo " + CIDADE_NOME_TAMANHO_MAXIMO + " caracteres";
	// CODIGO IBGE
	public static final String MENSAGEM_CODIGO_IBGE_NULO = "Código IBGE não pode estar em branco.";
	public static final String MENSAGEM_CODIGO_IBGE_VAZIO = "Código IBGE não pode estar vazio.";
	public static final String MENSAGEM_CODIGO_IBGE_TAMANHO = "Código IBGE deve ter no mínimo " + CIDADE_CODIGO_IBGE_TAMANHO_MINIMO + " e no máximo " + CIDADE_CODIGO_IBGE_TAMANHO_MAXIMO + " caracteres numéricos";
	public static final String MENSAGEM_REGEX_CODIGO_IBGE = "Código IBGE não deve conter letras";
	// ESTADO
	public static final String MENSAGEM_UF_NULO = "Uf não pode estar em branco.";

	private CidadeConstantes() {
	}

}
