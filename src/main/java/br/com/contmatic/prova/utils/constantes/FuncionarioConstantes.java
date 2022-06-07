package br.com.contmatic.prova.utils.constantes;

public class FuncionarioConstantes {
	
	// numericos
	// NOME
	public static final int FUNCIONARIO_NOME_TAMANHO_MINIMO = 3;
	public static final int FUNCIONARIO_NOME_TAMANHO_MAXIMO = 60;
	// TELEFONE
	public static final int FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MINIMO = 1;
	public static final int FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MAXIMO = 4;
	// EMAIL
	public static final int FUNCIONARIO_LISTA_EMAIL_TAMANHO_MINIMO = 2;
	public static final int FUNCIONARIO_LISTA_EMAIL_TAMANHO_MAXIMO = 3;
	// DATA NASCIMENTO
	public static final int FUNCIONARIO_DATA_NASCIMENTO_INTERVALO_ANO_ANTIGO = 120;
	// DATA ADMISSAO
	public static final int FUNCIONARIO_DATA_ADMISSAO_MES_INTERVALO_MAXIMO = 2;
	public static final int FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_FUTURO = 1;
	public static final int FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_ANTIGO = 120;
	// DATA ENCERRAMENTO
	public static final int FUNCIONARIO_DATA_ENCERRAMENTO_INTERVALO_ANO_ANTIGO = 120;
	public static final int FUNCIONARIO_DATA_ENCERRAMENTO_INTERVALO_MINIMO_DATA_ADMISSAO = 1;
	// SALARIO
	public static final float FUNCIONARIO_SALARIO_MINIMO = 1192.40f;
	public static final float FUNCIONARIO_SALARIO_MAXIMO = 999999.99f;
	
	// mensagens
	// NOME
	public static final String MENSAGEM_NOME_NULO = "Nome não pode estar em branco.";
	public static final String MENSAGEM_NOME_VAZIO = "Nome não pode estar vazio.";
	public static final String MENSAGEM_NOME_CARACTER_NUMERICO = "Nome não deve conter número.";
	public static final String MENSAGEM_NOME_TAMANHO = "Nome deve ter no mínimo " + FUNCIONARIO_NOME_TAMANHO_MINIMO + " e no máximo " + FUNCIONARIO_NOME_TAMANHO_MAXIMO + " caracteres";
	// DATA NASCIMENTO
	public static final String MENSAGEM_DATA_NASCIMENTO_NULO = "Data de Nascimento não pode estar em branco.";
	public static final String MENSAGEM_DATA_NASCIMENTO_ANTIGA = "Data de Nascimento não pode ser anterior à " + FUNCIONARIO_DATA_NASCIMENTO_INTERVALO_ANO_ANTIGO + " anos.";
	public static final String MENSAGEM_DATA_NASCIMENTO_MENOR_16_ANOS = "Funcionário menor de 16 anos.";
	// DATA ADMISSAO
	public static final String MENSAGEM_DATA_ADMISSAO_NULO = "Data de Admissao não pode estar em branco.";
	public static final String MENSAGEM_DATA_ADMISSAO_MES_FUTURO = "Data de Admissao não pode ser posterior à " + FUNCIONARIO_DATA_ADMISSAO_MES_INTERVALO_MAXIMO + " meses.";
	public static final String MENSAGEM_DATA_ADMISSAO_ANO_FUTURO = "Data de Admissao não pode ser posterior à " + FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_FUTURO + " ano.";
	public static final String MENSAGEM_DATA_ADMISSAO_ANO_ANTIGO = "Data de Admissao não pode ser anterior à " + FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_ANTIGO + " anos.";
	// DATA ENCERRAMENTO
	public static final String MENSAGEM_DATA_ENCERRAMENTO_NULO = "Data de Encerramento não pode estar em branco.";
	public static final String MENSAGEM_DATA_ENCERRAMENTO_ATUAL = "Data de Encerramento não pode ser anterior e posterior à hoje.";
	public static final String MENSAGEM_DATA_ENCERRAMENTO_ANTERIOR_A_DATA_ADMISSAO = "Data Encerramento Contrato não deve ser anterior a Data de Admissão.";
	public static final String MENSAGEM_DATA_ENCERRAMENTO_PRE_REQUISITO = "Data Encerramento Contrato não deve existir se Data Admissão for nula";
	public static final String MENSAGEM_DATA_ENCERRAMENTO_ANO_ANTIGO = "Data de Encerramento não pode ser anterior à " + FUNCIONARIO_DATA_ENCERRAMENTO_INTERVALO_ANO_ANTIGO + " anos.";
	// TELEFONE
	public static final String MENSAGEM_LISTA_TELEFONE_NULO = "Telefone não pode ter lista em branco.";
	public static final String MENSAGEM_LISTA_TELEFONE_TAMANHO = "A lista de telefone deve ter no mínimo " + FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MINIMO + " e no máximo " + FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MAXIMO + " telefones";
	// EMAIL
	public static final String MENSAGEM_LISTA_EMAIL_NULO = "Email não pode ter lista em branco.";
	public static final String MENSAGEM_LISTA_EMAIL_TAMANHO = "A lista de email deve ter no mínimo " + FUNCIONARIO_LISTA_EMAIL_TAMANHO_MINIMO + " e no máximo " + FUNCIONARIO_LISTA_EMAIL_TAMANHO_MAXIMO + " emails";
	// ENDERECO
	public static final String MENSAGEM_ENDERECO_NULO = "Endereço não pode estar em branco.";
	// SALARIO
	public static final String MENSAGEM_SALARIO_NULO = "Salário não pode estar em branco.";
	public static final String MENSAGEM_SALARIO_TAMANHO = "Salário deve ter valor mínimo de " + FUNCIONARIO_SALARIO_MINIMO + " e valor máximo de " + FUNCIONARIO_SALARIO_MAXIMO;
	// CARGO
	public static final String MENSAGEM_CARGO_NULO = "Cargo não pode estar em branco.";
	public static final String MENSAGEM_CARGO_VAZIO = "Cargo não pode estar vazio.";
	// EMPRESA
	public static final String MENSAGEM_EMPRESA_NULO = "Empresa não pode estar em branco.";

	private FuncionarioConstantes() {
	}

}
