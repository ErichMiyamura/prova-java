package br.com.contmatic.prova.utils.constantes;

public class UfConstantes {

	// numericos
	// NOME
	public static final int UF_NOME_TAMANHO_MINIMO = 3;
	public static final int UF_NOME_TAMANHO_MAXIMO = 60;
	// SIGLA
	public static final int UF_SIGLA_TAMANHO_MINIMO = 2;
	public static final int UF_SIGLA_TAMANHO_MAXIMO = 2;
	// PAIS
	public static final int UF_PAIS_TAMANHO_MINIMO = 3;
	public static final int UF_PAIS_TAMANHO_MAXIMO = 60;
	// CODIGO IBGE
	public static final int UF_CODIGO_IBGE_TAMANHO_MINIMO = 7;
	public static final int UF_CODIGO_IBGE_TAMANHO_MAXIMO = 7;

	// mensagens
	// NOME
	public static final String MENSAGEM_NOME_NULO = "Nome não pode estar em branco.";
	public static final String MENSAGEM_NOME_VAZIO = "Nome não pode estar vazio.";
	public static final String MENSAGEM_NOME_CARACTER_NUMERICO = "Nome não deve conter número.";
	public static final String MENSAGEM_NOME_TAMANHO = "Nome deve ter no mínimo " + UF_NOME_TAMANHO_MINIMO + " e no máximo " + UF_NOME_TAMANHO_MAXIMO + " caracteres";
	// SIGLA
	public static final String MENSAGEM_SIGLA_NULO = "Sigla não pode estar em branco.";
	public static final String MENSAGEM_SIGLA_VAZIO = "Sigla não pode estar vazio.";
	public static final String MENSAGEM_SIGLA_CARACTER_NUMERICO = "Sigla não deve conter número.";
	public static final String MENSAGEM_SIGLA_TAMANHO = "Sigla deve ter no mínimo " + UF_SIGLA_TAMANHO_MINIMO + " e no máximo " + UF_SIGLA_TAMANHO_MAXIMO + " caracteres";
	// PAIS
	public static final String MENSAGEM_PAIS_NULO = "País não pode estar em branco.";
	public static final String MENSAGEM_PAIS_VAZIO = "País não pode estar vazio.";
	public static final String MENSAGEM_PAIS_CARACTER_NUMERICO = "País não deve conter número.";
	public static final String MENSAGEM_PAIS_TAMANHO = "País deve ter no mínimo " + UF_PAIS_TAMANHO_MINIMO + " e no máximo " + UF_PAIS_TAMANHO_MAXIMO + " caracteres";
	// CODIGO IBGE
	public static final String MENSAGEM_UF_CODIGO_IBGE_NULO = "Código IBGE não pode estar em branco.";
	public static final String MENSAGEM_UF_CODIGO_IBGE_VAZIO = "Código IBGE não pode estar vazio.";
	public static final String MENSAGEM_UF_CODIGO_IBGE_TAMANHO = "Código IBGE deve ter no mínimo " + UF_CODIGO_IBGE_TAMANHO_MINIMO + " e no máximo " + UF_CODIGO_IBGE_TAMANHO_MAXIMO + " caracteres numéricos";
	public static final String MENSAGEM_UF_REGEX_CODIGO_IBGE = "Código IBGE não deve conter letras";

	private UfConstantes() {
	}

}
