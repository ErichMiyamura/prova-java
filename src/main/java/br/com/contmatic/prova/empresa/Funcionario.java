package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_ANTIGO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_FUTURO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_DATA_ADMISSAO_MES_INTERVALO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_DATA_ENCERRAMENTO_INTERVALO_ANO_ANTIGO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_DATA_ENCERRAMENTO_INTERVALO_MINIMO_DATA_ADMISSAO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_DATA_NASCIMENTO_INTERVALO_ANO_ANTIGO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_LISTA_EMAIL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_LISTA_EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_SALARIO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.FUNCIONARIO_SALARIO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_CARGO_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_CARGO_VAZIO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ADMISSAO_ANO_ANTIGO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ADMISSAO_ANO_FUTURO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ADMISSAO_MES_FUTURO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ADMISSAO_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ENCERRAMENTO_ANO_ANTIGO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ENCERRAMENTO_ANTERIOR_A_DATA_ADMISSAO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ENCERRAMENTO_ATUAL;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ENCERRAMENTO_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_ENCERRAMENTO_PRE_REQUISITO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_NASCIMENTO_ANTIGA;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_NASCIMENTO_MENOR_16_ANOS;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_DATA_NASCIMENTO_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_EMPRESA_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_ENDERECO_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_LISTA_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_LISTA_EMAIL_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_LISTA_TELEFONE_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_LISTA_TELEFONE_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_NOME_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_NOME_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_NOME_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_NOME_VAZIO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_SALARIO_NULO;
import static br.com.contmatic.prova.utils.constantes.FuncionarioConstantes.MENSAGEM_SALARIO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarPreRequisitoNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoLista;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoNumeroDecimal;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;
import static br.com.contmatic.prova.utils.validacao.ValidacaoCpf.validarCpf;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarDataAntiga;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarDataAtual;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarDataFutura;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarDataAnterior;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarMaior16Anos;
import static br.com.contmatic.prova.utils.validacao.ValidacaoData.validarMesFuturo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.contmatic.prova.contato.Email;
import br.com.contmatic.prova.contato.Telefone;
import br.com.contmatic.prova.endereco.Endereco;

public class Funcionario extends Auditoria {
	
	private String cpf;
	
	private String nome;
	
	private LocalDate dataNascimento; 
	
	private LocalDate dataAdmissao; 
	
	private LocalDate dataEncerramentoContrato; 
	
	private String cargo;  
	
	private BigDecimal salario;
	 
	private Endereco endereco;
	
	private Empresa empresa;
	
	private List<Telefone> telefones;
	
	private List<Email> emails;
	 
	public Funcionario(String cpf, Empresa empresa) {  
		setCpf(cpf);
		setEmpresa(empresa);
	}
	  
	public Funcionario(String cpf, Empresa empresa, String nome) {
		setCpf(cpf);
		setEmpresa(empresa);
		setNome(nome); 
	}

	public Funcionario(String cpf, Empresa empresa, String nome, LocalDate dataNascimento, LocalDate dataAdmissao, LocalDate dataEncerramentoContrato, List<Telefone> telefone, List<Email> email, Endereco endereco, BigDecimal salario, String cargo) {
		setCpf(cpf); 
		setEmpresa(empresa);
		setNome(nome);
		setDataNascimento(dataNascimento);  
		setDataAdmissao(dataAdmissao);
		setDataEncerramentoContrato(dataEncerramentoContrato);
		setTelefones(telefone);
		setEmails(email); 
		setEndereco(endereco);
		setSalario(salario);
		setCargo(cargo);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		validarNulo(nome, MENSAGEM_NOME_NULO);
		validarVazio(nome, MENSAGEM_NOME_VAZIO);
		validarCaracter(nome, REGEX_CARACTER, MENSAGEM_NOME_CARACTER_NUMERICO);
		validarTamanhoString(nome, FUNCIONARIO_NOME_TAMANHO_MINIMO, FUNCIONARIO_NOME_TAMANHO_MAXIMO, MENSAGEM_NOME_TAMANHO);
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		validarNulo(dataNascimento, MENSAGEM_DATA_NASCIMENTO_NULO);
		validarDataAntiga(dataNascimento, FUNCIONARIO_DATA_NASCIMENTO_INTERVALO_ANO_ANTIGO, MENSAGEM_DATA_NASCIMENTO_ANTIGA);
		validarMaior16Anos(dataNascimento, MENSAGEM_DATA_NASCIMENTO_MENOR_16_ANOS);
		this.dataNascimento = dataNascimento;
	}
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		validarNulo(dataAdmissao, MENSAGEM_DATA_ADMISSAO_NULO);
		validarMesFuturo(dataAdmissao, FUNCIONARIO_DATA_ADMISSAO_MES_INTERVALO_MAXIMO, MENSAGEM_DATA_ADMISSAO_MES_FUTURO);
		validarDataFutura(dataAdmissao, FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_FUTURO, MENSAGEM_DATA_ADMISSAO_ANO_FUTURO);
		validarDataAntiga(dataAdmissao, FUNCIONARIO_DATA_ADMISSAO_INTERVALO_ANO_ANTIGO, MENSAGEM_DATA_ADMISSAO_ANO_ANTIGO); 
		this.dataAdmissao = dataAdmissao; 
	}
	
	public LocalDate getDataEncerramentoContrato() {
		return dataEncerramentoContrato;
	}

	public void setDataEncerramentoContrato(LocalDate dataEncerramentoContrato) {
		validarNulo(dataEncerramentoContrato, MENSAGEM_DATA_ENCERRAMENTO_NULO);
		validarPreRequisitoNulo(dataAdmissao, MENSAGEM_DATA_ENCERRAMENTO_PRE_REQUISITO);
		validarDataAtual(dataEncerramentoContrato, MENSAGEM_DATA_ENCERRAMENTO_ATUAL);
		validarDataAntiga(dataEncerramentoContrato, FUNCIONARIO_DATA_ENCERRAMENTO_INTERVALO_ANO_ANTIGO, MENSAGEM_DATA_ENCERRAMENTO_ANO_ANTIGO); 
		validarDataAnterior(dataEncerramentoContrato, FUNCIONARIO_DATA_ENCERRAMENTO_INTERVALO_MINIMO_DATA_ADMISSAO, MENSAGEM_DATA_ENCERRAMENTO_ANTERIOR_A_DATA_ADMISSAO);
		this.dataEncerramentoContrato = dataEncerramentoContrato;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		validarNulo(telefones, MENSAGEM_LISTA_TELEFONE_NULO);
		validarTamanhoLista(telefones, FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MINIMO, FUNCIONARIO_LISTA_TELEFONE_TAMANHO_MAXIMO, MENSAGEM_LISTA_TELEFONE_TAMANHO);
		this.telefones = telefones;
	}

	public List<Email> getEmails() {
		return emails;
	}
	
	public void setEmails(List<Email> emails) {
		validarNulo(emails, MENSAGEM_LISTA_EMAIL_NULO);
		validarTamanhoLista(emails, FUNCIONARIO_LISTA_EMAIL_TAMANHO_MINIMO, FUNCIONARIO_LISTA_EMAIL_TAMANHO_MAXIMO, MENSAGEM_LISTA_EMAIL_TAMANHO); 
		this.emails = emails;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		validarCpf(cpf);
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		validarNulo(endereco, MENSAGEM_ENDERECO_NULO);
		this.endereco = endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		validarNulo(salario, MENSAGEM_SALARIO_NULO);
		validarTamanhoNumeroDecimal(salario, FUNCIONARIO_SALARIO_MINIMO, FUNCIONARIO_SALARIO_MAXIMO, MENSAGEM_SALARIO_TAMANHO);
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		validarNulo(cargo, MENSAGEM_CARGO_NULO);
		validarVazio(cargo, MENSAGEM_CARGO_VAZIO);
		this.cargo = cargo;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		validarNulo(empresa, MENSAGEM_EMPRESA_NULO);
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpf.hashCode();
		result = prime * result + empresa.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (!cpf.equals(other.cpf))
			return false; 
		return empresa.equals(other.empresa);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Funcionario [cpf=").append(cpf)
			    .append(", empresa=").append(empresa)
			    .append(", nome=").append(nome)
			    .append(", dataNascimento=").append(dataNascimento)
			    .append(", dataAdmissao=").append(dataAdmissao)
			    .append(", dataEncerramentoContrato=").append(dataEncerramentoContrato)
			    .append(", cargo=").append(cargo)
			    .append(", salario=").append(salario)
			    .append(", endereco=").append(endereco)
			    .append(", telefones=").append(telefones)
			    .append(", emails=").append(emails)
			    .append("]")
			    .append(super.toString())
			    .toString();
	}

}
