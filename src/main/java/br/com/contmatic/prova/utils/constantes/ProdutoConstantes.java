package br.com.contmatic.prova.utils.constantes;

public class ProdutoConstantes {

	// numericos
	// CODIGO
	public static final int PRODUTO_CODIGO_TAMANHO_MINIMO = 8;
	public static final int PRODUTO_CODIGO_TAMANHO_MAXIMO = 14;
	// NOME
	public static final int PRODUTO_NOME_TAMANHO_MINIMO = 3;
	public static final int PRODUTO_NOME_TAMANHO_MAXIMO = 60;
	// VALOR
	public static final float PRODUTO_VALOR_MINIMO = 9.99f;
	public static final float PRODUTO_VALOR_MAXIMO = 999999.99f;

	// mensagens
	// CODIGO
	public static final String MENSAGEM_CODIGO_NULO = "Código do produto não pode estar em branco.";
	public static final String MENSAGEM_CODIGO_TAMANHO = "Código deve ter no mínimo " + PRODUTO_CODIGO_TAMANHO_MINIMO + " e no máximo " + PRODUTO_CODIGO_TAMANHO_MAXIMO + " caracteres numéricos";
	public static final String MENSAGEM_REGEX_CODIGO = "Código deve ter somente números";
	// NOME
	public static final String MENSAGEM_NOME_NULO = "Nome não pode estar em branco.";
	public static final String MENSAGEM_NOME_VAZIO = "Nome não pode estar vazio.";
	public static final String MENSAGEM_NOME_CARACTER_NUMERICO = "Nome não deve conter número.";
	public static final String MENSAGEM_NOME_TAMANHO_MIN = "Nome possui tamanho menor que o mínimo permitido.";
	public static final String MENSAGEM_NOME_TAMANHO_MAX = "Nome possui tamanho maior que o máximo permitido.";
	public static final String MENSAGEM_NOME_TAMANHO = "Nome deve ter no mínimo " + PRODUTO_NOME_TAMANHO_MINIMO + " e no máximo " + PRODUTO_NOME_TAMANHO_MAXIMO + " caracteres";
	// VALOR
	public static final String MENSAGEM_VALOR_NULO = "Valor do produto não pode estar em branco.";
	public static final String MENSAGEM_VALOR_TAMANHO_MIN = "Valor do produto possui valor menor que o mínimo permitido.";
	public static final String MENSAGEM_VALOR_TAMANHO_MAX = "Valor do produto possui valor maior que o máximo permitido.";
	public static final String MENSAGEM_VALOR_TAMANHO = "Valor deve ter no mínimo " + PRODUTO_VALOR_MINIMO + " e no máximo " + PRODUTO_VALOR_MAXIMO;

	private ProdutoConstantes() {
	}

}
