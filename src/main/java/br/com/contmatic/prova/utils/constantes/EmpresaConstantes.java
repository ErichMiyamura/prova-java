package br.com.contmatic.prova.utils.constantes;

public final class EmpresaConstantes {

	// numericos
	// RAZAO SOCIAL
	public static final int EMPRESA_RAZAO_SOCIAL_TAMANHO_MINIMO = 3;
	public static final int EMPRESA_RAZAO_SOCIAL_TAMANHO_MAXIMO = 60;
	// NOME FANTASIA
	public static final int EMPRESA_NOME_FANTASIA_TAMANHO_MINIMO = 3;
	public static final int EMPRESA_NOME_FANTASIA_TAMANHO_MAXIMO = 60;
	// ENDERECO
	public static final int EMPRESA_LISTA_ENDERECO_TAMANHO_MINIMO = 2;
	public static final int EMPRESA_LISTA_ENDERECO_TAMANHO_MAXIMO = 5;
	// TELEFONE
	public static final int EMPRESA_LISTA_TELEFONE_TAMANHO_MINIMO = 2;
	public static final int EMPRESA_LISTA_TELEFONE_TAMANHO_MAXIMO = 4;
	// FUNCIONARIO
	public static final int EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MINIMO = 4;
	public static final int EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MAXIMO = 50;
	// EMAIL
	public static final int EMPRESA_LISTA_EMAIL_TAMANHO_MINIMO = 2;
	public static final int EMPRESA_LISTA_EMAIL_TAMANHO_MAXIMO = 3;

	// mensagens
	// RAZAO SOCIAL
	public static final String MENSAGEM_RAZAO_SOCIAL_NULO = "Razão Social não pode estar em branco.";
	public static final String MENSAGEM_RAZAO_SOCIAL_VAZIO = "Razão Social não pode estar vazio.";
	public static final String MENSAGEM_RAZAO_SOCIAL_CARACTER_NUMERICO = "Razão Social não deve conter número.";
	public static final String MENSAGEM_RAZAO_SOCIAL_TAMANHO = "Razão Social deve ter no mínimo " + EMPRESA_RAZAO_SOCIAL_TAMANHO_MINIMO + " e no máximo " + EMPRESA_RAZAO_SOCIAL_TAMANHO_MAXIMO + " caracteres";
	// NOME FANTASIA
	public static final String MENSAGEM_NOME_FANTASIA_NULO = "Nome Fantasia não pode estar em branco.";
	public static final String MENSAGEM_NOME_FANTASIA_VAZIO = "Nome Fantasia não pode estar vazio.";
	public static final String MENSAGEM_NOME_FANTASIA_CARACTER_NUMERICO = "Nome Fantasia não deve conter número.";
	public static final String MENSAGEM_NOME_FANTASIA_TAMANHO_MIN = "Nome Fantasia possui tamanho menor que o mínimo permitido.";
	public static final String MENSAGEM_NOME_FANTASIA_TAMANHO = "Nome Fantasia deve ter no mínimo " + EMPRESA_NOME_FANTASIA_TAMANHO_MINIMO + " e no máximo " + EMPRESA_NOME_FANTASIA_TAMANHO_MAXIMO + " caracteres";
	// ENDERECO
	public static final String MENSAGEM_LISTA_ENDERECO_NULO = "Endereço não pode ter lista em branco.";
	public static final String MENSAGEM_LISTA_ENDERECO_TAMANHO = "A lista de endereço deve ter no mínimo " + EMPRESA_LISTA_ENDERECO_TAMANHO_MINIMO + " e no máximo " + EMPRESA_LISTA_ENDERECO_TAMANHO_MAXIMO + " endereços";
	// TELEFONE
	public static final String MENSAGEM_LISTA_TELEFONE_NULO = "Telefone não pode ter lista em branco.";
	public static final String MENSAGEM_LISTA_TELEFONE_TAMANHO = "A lista de telefone deve ter no mínimo " + EMPRESA_LISTA_TELEFONE_TAMANHO_MINIMO + " e no máximo " + EMPRESA_LISTA_TELEFONE_TAMANHO_MAXIMO + " telefones";
	// FUNCIONARIO
	public static final String MENSAGEM_LISTA_FUNCIONARIO_NULO = "Funcionário não pode ter lista em branco.";
	public static final String MENSAGEM_LISTA_FUNCIONARIO_TAMANHO = "A lista de funcionário deve ter no mínimo " + EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MINIMO + " e no máximo " + EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MAXIMO + " funcionários";
	// EMAIL
	public static final String MENSAGEM_LISTA_EMAIL_NULO = "Email não pode ter lista em branco.";
	public static final String MENSAGEM_LISTA_EMAIL_TAMANHO = "A lista de email deve ter no mínimo " + EMPRESA_LISTA_EMAIL_TAMANHO_MINIMO + " e no máximo " + EMPRESA_LISTA_EMAIL_TAMANHO_MAXIMO + " emails";

	private EmpresaConstantes() {
	}
}
