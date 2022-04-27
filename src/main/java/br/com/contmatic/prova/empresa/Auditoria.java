package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.AUDITORIA_DATA_ALTERACAO_INTERVALO_ANO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.AUDITORIA_DATA_CRIACAO_INTERVALO_ANO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_ALTERACAO_ANTERIOR_A_DATA_CRIACAO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_ALTERACAO_ANTIGA;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_ALTERACAO_FUTURA;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_ALTERACAO_NULO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_ALTERACAO_PRE_REQUISITO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_CRIACAO_ANTIGA;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_CRIACAO_FUTURA;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_DATA_CRIACAO_NULO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_IP_ALTERACAO_NULO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_IP_CRIACAO_NULO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_ALTERACAO_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_ALTERACAO_NULO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_ALTERACAO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_ALTERACAO_VAZIO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_CRIACAO_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_CRIACAO_NULO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_CRIACAO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_NOME_USUARIO_CRIACAO_VAZIO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_REGEX_IP_ALTERACAO;
import static br.com.contmatic.prova.utils.constantes.AuditoriaConstantes.MENSAGEM_REGEX_IP_CRIACAO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_IP;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarPreRequisitoNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarRegex;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarDataAntiga;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarDataFutura;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarDataIsBefore;

import java.time.LocalDateTime;

public abstract class Auditoria {
	
	private String nomeUsuarioCriacao;
	
	private LocalDateTime dataCriacao;
	
	private String ipCriacao;
	
	private String nomeUsuarioAlteracao;
	 
	private LocalDateTime dataAlteracao;
	
	private String ipAlteracao;
	
	public String getNomeUsuarioCriacao() { 
		return nomeUsuarioCriacao;   
	}

	public void setNomeUsuarioCriacao(String nomeUsuarioCriacao) {
		validarNulo(nomeUsuarioCriacao, MENSAGEM_NOME_USUARIO_CRIACAO_NULO);
		validarVazio(nomeUsuarioCriacao, MENSAGEM_NOME_USUARIO_CRIACAO_VAZIO);
		validarCaracter(nomeUsuarioCriacao, REGEX_CARACTER, MENSAGEM_NOME_USUARIO_CRIACAO_CARACTER_NUMERICO);
		validarTamanhoString(nomeUsuarioCriacao, AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MINIMO, AUDITORIA_NOME_USUARIO_CRIACAO_TAMANHO_MAXIMO, MENSAGEM_NOME_USUARIO_CRIACAO_TAMANHO);
		this.nomeUsuarioCriacao = nomeUsuarioCriacao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		validarNulo(dataCriacao, MENSAGEM_DATA_CRIACAO_NULO);
		validarDataAntiga(dataCriacao, AUDITORIA_DATA_CRIACAO_INTERVALO_ANO, MENSAGEM_DATA_CRIACAO_ANTIGA);
		validarDataFutura(dataCriacao, AUDITORIA_DATA_CRIACAO_INTERVALO_ANO, MENSAGEM_DATA_CRIACAO_FUTURA);
		this.dataCriacao = dataCriacao;
	}

	public String getIpCriacao() {
		return ipCriacao;
	}

	public void setIpCriacao(String ipCriacao) {
		validarNulo(ipCriacao, MENSAGEM_IP_CRIACAO_NULO);
		validarRegex(ipCriacao, REGEX_IP, MENSAGEM_REGEX_IP_CRIACAO);
		this.ipCriacao = ipCriacao;
	}

	public String getNomeUsuarioAlteracao() {
		return nomeUsuarioAlteracao;
	}

	public void setNomeUsuarioAlteracao(String nomeUsuarioAlteracao) {
		validarNulo(nomeUsuarioAlteracao, MENSAGEM_NOME_USUARIO_ALTERACAO_NULO);
		validarVazio(nomeUsuarioAlteracao, MENSAGEM_NOME_USUARIO_ALTERACAO_VAZIO);
		validarCaracter(nomeUsuarioAlteracao, REGEX_CARACTER, MENSAGEM_NOME_USUARIO_ALTERACAO_CARACTER_NUMERICO);
		validarTamanhoString(nomeUsuarioAlteracao, AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MINIMO, AUDITORIA_NOME_USUARIO_ALTERACAO_TAMANHO_MAXIMO, MENSAGEM_NOME_USUARIO_ALTERACAO_TAMANHO);
		this.nomeUsuarioAlteracao = nomeUsuarioAlteracao;
	}

	public LocalDateTime getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDateTime dataAlteracao) {
		validarNulo(dataAlteracao, MENSAGEM_DATA_ALTERACAO_NULO);
		validarPreRequisitoNulo(dataCriacao, MENSAGEM_DATA_ALTERACAO_PRE_REQUISITO);
		validarDataAntiga(dataAlteracao, AUDITORIA_DATA_ALTERACAO_INTERVALO_ANO, MENSAGEM_DATA_ALTERACAO_ANTIGA);
		validarDataFutura(dataAlteracao, AUDITORIA_DATA_ALTERACAO_INTERVALO_ANO, MENSAGEM_DATA_ALTERACAO_FUTURA);
		// TODO comparar a data de alteracao é anterior a data criacao
		validarDataIsBefore(dataAlteracao, AUDITORIA_DATA_CRIACAO_INTERVALO_ANO, MENSAGEM_DATA_ALTERACAO_ANTERIOR_A_DATA_CRIACAO);
		this.dataAlteracao = dataAlteracao;
	}

	public String getIpAlteracao() {
		return ipAlteracao;
	}

	public void setIpAlteracao(String ipAlteracao) {
		validarNulo(ipAlteracao, MENSAGEM_IP_ALTERACAO_NULO);
		validarRegex(ipAlteracao, REGEX_IP, MENSAGEM_REGEX_IP_ALTERACAO);
		this.ipAlteracao = ipAlteracao;
	}
	
}
