package br.com.contmatic.prova.utils.constantes;

public class AuditoriaConstantes {
	
	// numericos
	// NOME USUARIO CRIACAO
	public static final int AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MINIMO = 3;
	public static final int AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MAXIMO = 60;
	// NOME USUARIO ALTERACAO
	public static final int AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MINIMO = 3;
	public static final int AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MAXIMO = 60;
	// DATA CRIACAO
	public static final int AUDITORIA_DATA_CRIACAO_INTERVALO_ANO = 1;
	// DATA ALTERACAO
	public static final int AUDITORIA_DATA_ALTERACAO_INTERVALO_ANO = 1;
	
	// mensagens
	// NOME USUARIO CRIACAO
	public static final String MENSAGEM_NOME_USUARIO_CRIACAO_NULO = "Nome Usuário Criação não pode estar em branco.";
	public static final String MENSAGEM_NOME_USUARIO_CRIACAO_VAZIO = "Nome Usuário Criação não pode estar vazio.";
	public static final String MENSAGEM_NOME_USUARIO_CRIACAO_CARACTER_NUMERICO = "Nome Usuário Criação não deve conter número.";
	public static final String MENSAGEM_NOME_USUARIO_CRIACAO_TAMANHO = "Nome Usuário Criação deve ter no mínimo " + AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MINIMO + " e no máximo " + AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MAXIMO + " caracteres";
	// DATA CRIACAO
	public static final String MENSAGEM_DATA_CRIACAO_NULO = "Data Criação não pode estar em branco.";
	public static final String MENSAGEM_DATA_CRIACAO_ANTIGA = "Data criação não pode ser antiga";
	public static final String MENSAGEM_DATA_CRIACAO_FUTURA = "Data criação não pode ser futura";
	// IP CRIACAO
	public static final String MENSAGEM_IP_CRIACAO_NULO = "IP Criação não pode estar em branco.";
	public static final String MENSAGEM_REGEX_IP_CRIACAO = "IP Criação deve seguir o formato 0.0.0.0 até 255.255.255.255";
	// NOME USUARIO ALTERACAO
	public static final String MENSAGEM_NOME_USUARIO_ALTERACAO_NULO = "Nome Usuário Alteração não pode estar em branco.";
	public static final String MENSAGEM_NOME_USUARIO_ALTERACAO_VAZIO = "Nome Usuário Alteração não pode estar vazio.";
	public static final String MENSAGEM_NOME_USUARIO_ALTERACAO_CARACTER_NUMERICO = "Nome Alteração Criação não deve conter número.";
	public static final String MENSAGEM_NOME_USUARIO_ALTERACAO_TAMANHO = "Nome Usuário Alteração deve ter no mínimo " + AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MINIMO + " e no máximo " + AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MAXIMO + " caracteres";
	// DATA ALTERACAO
	public static final String MENSAGEM_DATA_ALTERACAO_NULO = "Data Alteração não pode estar em branco.";
	public static final String MENSAGEM_DATA_ALTERACAO_ANTIGA = "Data Alteração não pode ser antiga";
	public static final String MENSAGEM_DATA_ALTERACAO_FUTURA = "Data Alteração não pode ser futura";
	public static final String MENSAGEM_DATA_ALTERACAO_PRE_REQUISITO = "Data Alteração não deve existir se Data Criação for nula";
	public static final String MENSAGEM_DATA_ALTERACAO_ANTERIOR_A_DATA_CRIACAO = "Data Alteração não deve ser anterior a Data Criação";
	// IP ALTERACAO
	public static final String MENSAGEM_IP_ALTERACAO_NULO = "IP Alteração não pode estar em branco.";
	public static final String MENSAGEM_REGEX_IP_ALTERACAO = "IP Alteração deve seguir o formato 0.0.0.0 até 255.255.255.255";
	
	private AuditoriaConstantes() {}

}
