package br.com.contmatic.prova.utils.constantes;

public class EstadoConstantes {

	// numericos
	// NOME
	public static final int ESTADO_NOME_TAMANHO_MINIMO = 3;
	public static final int ESTADO_NOME_TAMANHO_MAXIMO = 60;
	// SIGLA
	public static final int ESTADO_SIGLA_TAMANHO_MINIMO = 2;
	public static final int ESTADO_SIGLA_TAMANHO_MAXIMO = 2;
	// PAIS
	public static final int ESTADO_PAIS_TAMANHO_MINIMO = 3;
	public static final int ESTADO_PAIS_TAMANHO_MAXIMO = 60;

	// mensagens
	// NOME
	public static final String MENSAGEM_NOME_NULO = "Nome não pode estar em branco.";
	public static final String MENSAGEM_NOME_VAZIO = "Nome não pode estar vazio.";
	public static final String MENSAGEM_NOME_CARACTER_NUMERICO = "Nome não deve conter número.";
	public static final String MENSAGEM_NOME_TAMANHO = "Nome deve ter no mínimo " + ESTADO_NOME_TAMANHO_MINIMO + " e no máximo " + ESTADO_NOME_TAMANHO_MAXIMO + " caracteres";
	// SIGLA
	public static final String MENSAGEM_SIGLA_NULO = "Sigla não pode estar em branco.";
	public static final String MENSAGEM_SIGLA_VAZIO = "Sigla não pode estar vazio.";
	public static final String MENSAGEM_SIGLA_CARACTER_NUMERICO = "Sigla não deve conter número.";
	public static final String MENSAGEM_SIGLA_TAMANHO = "Sigla deve ter no mínimo " + ESTADO_SIGLA_TAMANHO_MINIMO + " e no máximo " + ESTADO_SIGLA_TAMANHO_MAXIMO + " caracteres";
	// PAIS
	public static final String MENSAGEM_PAIS_NULO = "País não pode estar em branco.";
	public static final String MENSAGEM_PAIS_VAZIO = "País não pode estar vazio.";
	public static final String MENSAGEM_PAIS_CARACTER_NUMERICO = "País não deve conter número.";
	public static final String MENSAGEM_PAIS_TAMANHO = "País deve ter no mínimo " + ESTADO_PAIS_TAMANHO_MINIMO + " e no máximo " + ESTADO_PAIS_TAMANHO_MAXIMO + " caracteres";

	private EstadoConstantes() {
	}

}
