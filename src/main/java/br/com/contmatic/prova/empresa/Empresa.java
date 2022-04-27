package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_EMAIL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_ENDERECO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_ENDERECO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_TELEFONE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_LISTA_TELEFONE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_NOME_FANTASIA_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_NOME_FANTASIA_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_RAZAO_SOCIAL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.EMPRESA_RAZAO_SOCIAL_TAMANHO_MINIMO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_EMAIL_NULO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_EMAIL_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_ENDERECO_NULO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_ENDERECO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_FUNCIONARIO_NULO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_FUNCIONARIO_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_TELEFONE_NULO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_LISTA_TELEFONE_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_NOME_FANTASIA_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_NOME_FANTASIA_NULO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_NOME_FANTASIA_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_NOME_FANTASIA_VAZIO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_RAZAO_SOCIAL_CARACTER_NUMERICO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_RAZAO_SOCIAL_NULO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_RAZAO_SOCIAL_TAMANHO;
import static br.com.contmatic.prova.utils.constantes.EmpresaConstantes.MENSAGEM_RAZAO_SOCIAL_VAZIO;
import static br.com.contmatic.prova.utils.constantes.Regex.REGEX_CARACTER;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarCaracter;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoLista;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarTamanhoString;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;
import static br.com.contmatic.prova.utils.validacao.ValidacaoCnpj.validarCnpj;

import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.contato.Email;
import br.com.contmatic.prova.contato.Telefone;
import br.com.contmatic.prova.endereco.Endereco;

public class Empresa extends Auditoria {
	
	private String razaoSocial; 
	
	private String nomeFantasia;
	
	private String cnpj;	
	
	private List<Telefone> telefone;
	
	private List<Endereco> enderecos;
	
	private List<Funcionario> funcionarios;
	
	private List<Email> email;
	
	public Empresa(String cnpj) { 
		setCnpj(cnpj); 
	}

	public Empresa(String razaoSocial, String nomeFantasia, String cnpj, List<Telefone> telefone, List<Email> email, List<Endereco> enderecos, List<Funcionario> funcionarios) {
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);
		setCnpj(cnpj); 
		setTelefone(telefone);
		setEmail(email); 
		setEnderecos(enderecos);
		setFuncionarios(funcionarios);
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	} 

	public void setRazaoSocial(String razaoSocial) {
		validarNulo(razaoSocial, MENSAGEM_RAZAO_SOCIAL_NULO);
		validarVazio(razaoSocial, MENSAGEM_RAZAO_SOCIAL_VAZIO);
		validarCaracter(razaoSocial, REGEX_CARACTER, MENSAGEM_RAZAO_SOCIAL_CARACTER_NUMERICO);
		validarTamanhoString(razaoSocial, EMPRESA_RAZAO_SOCIAL_TAMANHO_MINIMO, EMPRESA_RAZAO_SOCIAL_TAMANHO_MAXIMO, MENSAGEM_RAZAO_SOCIAL_TAMANHO); 
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantasia() { 
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		validarNulo(nomeFantasia, MENSAGEM_NOME_FANTASIA_NULO);
		validarVazio(nomeFantasia, MENSAGEM_NOME_FANTASIA_VAZIO);
		validarCaracter(nomeFantasia, REGEX_CARACTER, MENSAGEM_NOME_FANTASIA_CARACTER_NUMERICO);
		validarTamanhoString(nomeFantasia, EMPRESA_NOME_FANTASIA_TAMANHO_MINIMO, EMPRESA_NOME_FANTASIA_TAMANHO_MAXIMO, MENSAGEM_NOME_FANTASIA_TAMANHO); 
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) { 
		validarCnpj(cnpj);
		this.cnpj = cnpj; 
	}
	
	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		validarNulo(telefone, MENSAGEM_LISTA_TELEFONE_NULO);
		validarTamanhoLista(telefone, EMPRESA_LISTA_TELEFONE_TAMANHO_MINIMO, EMPRESA_LISTA_TELEFONE_TAMANHO_MAXIMO, MENSAGEM_LISTA_TELEFONE_TAMANHO);
		this.telefone = telefone;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarNulo(enderecos, MENSAGEM_LISTA_ENDERECO_NULO);
		validarTamanhoLista(enderecos, EMPRESA_LISTA_ENDERECO_TAMANHO_MINIMO, EMPRESA_LISTA_ENDERECO_TAMANHO_MAXIMO, MENSAGEM_LISTA_ENDERECO_TAMANHO);
		this.enderecos = enderecos;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		validarNulo(funcionarios, MENSAGEM_LISTA_FUNCIONARIO_NULO);
		validarTamanhoLista(funcionarios, EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MINIMO, EMPRESA_LISTA_FUNCIONARIO_TAMANHO_MAXIMO, MENSAGEM_LISTA_FUNCIONARIO_TAMANHO);
		this.funcionarios = funcionarios; 
	}
	
	public List<Email> getEmail() {
		return email;
	}
	
	public void setEmail(List<Email> email) {
		validarNulo(email, MENSAGEM_LISTA_EMAIL_NULO);
		validarTamanhoLista(email, EMPRESA_LISTA_EMAIL_TAMANHO_MINIMO, EMPRESA_LISTA_EMAIL_TAMANHO_MAXIMO, MENSAGEM_LISTA_EMAIL_TAMANHO); 
		this.email = email;
	}

	@Override
	public int hashCode() { 
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true; 
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return new StringBuilder().append("Empresa [razaoSocial=").append(razaoSocial)
				.append(", nomeFantasia=").append(nomeFantasia)
			    .append(", cnpj=").append(cnpj)
			    .append(", telefone=").append(telefone)
			    .append(", email=").append(email)
			    .append(", enderecos=").append(enderecos)
			    .append(", funcionarios=").append(funcionarios)
			    .append("]")
			    .toString();
	}
	
}
