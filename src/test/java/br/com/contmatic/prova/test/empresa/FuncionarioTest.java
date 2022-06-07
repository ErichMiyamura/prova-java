package br.com.contmatic.prova.test.empresa;

import static java.time.LocalDate.now;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.contato.Email;
import br.com.contmatic.prova.contato.Telefone;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.empresa.Funcionario;
import br.com.contmatic.prova.endereco.Cidade;
import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.endereco.Uf;

public class FuncionarioTest {
	
	private static final String RESULTADO_ESPERADO = "Funcionario [cpf=95200487072, empresa=Empresa [cnpj=15619162000180, razaoSocial=Escritorio de Software, nomeFantasia=Casa do Pão, telefones=[Telefone [ddi=+55, ddd=22, numero=988932333, tipo=null], Telefone [ddi=+55, ddd=11, numero=999999999, tipo=null], Telefone [ddi=+55, ddd=25, numero=977775555, tipo=null]], emails=[Email [endereco=erich@gmail.com, tipo=null], Email [endereco=erich@gmail.com, tipo=null], Email [endereco=erich@gmail.com, tipo=null]], enderecos=[Endereco [cep=04117010, numero=1, logradouro=null, tipoLogradouro=null, bairro=null, complemento=null, cidade=null], Endereco [cep=02728000, numero=2, logradouro=null, tipoLogradouro=null, bairro=null, complemento=null, cidade=null], Endereco [cep=05208060, numero=3, logradouro=null, tipoLogradouro=null, bairro=null, complemento=null, cidade=null]], funcionarios=[Funcionario [cpf=17255071023, empresa=Empresa [cnpj=65141186000144, razaoSocial=null, nomeFantasia=null, telefones=null, emails=null, enderecos=null, funcionarios=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], nome=Erich, dataNascimento=null, dataAdmissao=null, dataEncerramentoContrato=null, cargo=null, salario=null, endereco=null, telefones=null, emails=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], Funcionario [cpf=17255071023, empresa=Empresa [cnpj=65141186000144, razaoSocial=null, nomeFantasia=null, telefones=null, emails=null, enderecos=null, funcionarios=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], nome=Marco, dataNascimento=null, dataAdmissao=null, dataEncerramentoContrato=null, cargo=null, salario=null, endereco=null, telefones=null, emails=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], Funcionario [cpf=17255071023, empresa=Empresa [cnpj=65141186000144, razaoSocial=null, nomeFantasia=null, telefones=null, emails=null, enderecos=null, funcionarios=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], nome=João, dataNascimento=null, dataAdmissao=null, dataEncerramentoContrato=null, cargo=null, salario=null, endereco=null, telefones=null, emails=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], Funcionario [cpf=17255071023, empresa=Empresa [cnpj=65141186000144, razaoSocial=null, nomeFantasia=null, telefones=null, emails=null, enderecos=null, funcionarios=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], nome=Maria, dataNascimento=null, dataAdmissao=null, dataEncerramentoContrato=null, cargo=null, salario=null, endereco=null, telefones=null, emails=null]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null]]]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null], nome=Marcelo, dataNascimento=2005-11-12, dataAdmissao=2021-03-12, dataEncerramentoContrato=2022-06-07, cargo=TI, salario=5500.0, endereco=Endereco [cep=62120970, numero=34, logradouro=Rua A, tipoLogradouro=null, bairro=null, complemento=null, cidade=Cidade [codigoIbge=3550308, nome=São Paulo, uf=Uf [codigoIbge=1200013, nome=São Paulo, sigla=SP, pais=Brasil]]], telefones=[Telefone [ddi=+55, ddd=22, numero=988932333, tipo=null], Telefone [ddi=+55, ddd=11, numero=999999999, tipo=null], Telefone [ddi=+55, ddd=25, numero=977775555, tipo=null]], emails=[Email [endereco=erich@gmail.com, tipo=null], Email [endereco=erich@gmail.com, tipo=null], Email [endereco=erich@gmail.com, tipo=null]]]Auditoria [nomeUsuarioCriacao=null, dataCriacao=null, ipCriacao=null, nomeUsuarioAlteracao=null, dataAlteracao=null, ipAlteracao=null]";
	private static final int IDADE_MINIMA_FUNCIONARIO = 16;
	private static final String NOME_FUNCIONARIO = "Marcelo";
	private static final String NOME_FUNCIONARIO_2 = "Robson";
	private static final LocalDate DATA_ANIVERSARIO = LocalDate.of(2005, 11, 12);
	private static final LocalDate DATA_ADMISSAO = LocalDate.of(2021, 3, 12);
	private static final LocalDate DATA_ENCERRAMENTO_CONTRATO = LocalDate.now();
	private static final String CPF = "95200487072";
	private static final String CPF_2 = "48925330091";
	
	private static final BigDecimal SALARIO = new BigDecimal("5500.0");
	private static final String CARGO = "TI";
	
	private static final LocalDateTime DATA_CRIACAO = LocalDateTime.of(2022, 04, 18, 12, 00);
	private static final LocalDateTime DATA_ALTERACAO_HOJE = LocalDateTime.now();
	
	private List<Telefone> telefones;
	private List<Telefone> telefones2;
	private List<Email> emails;
	private List<Email> emails2;
	private List<Endereco> listaEnderecos;
	private List<Funcionario> listaFuncionarios;
	private Funcionario funcionario;
	private Funcionario funcionarioCompleto;
	private Empresa empresa;
	private Empresa empresa1;
	private Uf uf1;
	private Endereco endereco1;
	private LocalDate dataHoje;
	
	@Before 
	public void setUp() { 
		empresa = new Empresa("65141186000144");
		
		telefones = new ArrayList<Telefone>();
		telefones.add(new Telefone("+55", "22", "988932333"));
		telefones.add(new Telefone("+55", "11", "999999999"));
		telefones.add(new Telefone("+55", "25", "977775555"));
		
		emails = new ArrayList<Email>();
		emails.add(new Email("erich@gmail.com"));
		emails.add(new Email("erich@gmail.com"));
		emails.add(new Email("erich@gmail.com"));
		
		listaEnderecos = new ArrayList<Endereco>();
		listaEnderecos.add(new Endereco("04117010", 1));
		listaEnderecos.add(new Endereco("02728000", 2));
		listaEnderecos.add(new Endereco("05208060", 3));
		
		listaFuncionarios = new ArrayList<Funcionario>();
		listaFuncionarios.add(new Funcionario("17255071023", empresa, "Erich"));
		listaFuncionarios.add(new Funcionario("17255071023", empresa, "Marco"));
		listaFuncionarios.add(new Funcionario("17255071023", empresa, "João"));
		listaFuncionarios.add(new Funcionario("17255071023", empresa, "Maria"));
		
		telefones2 = new ArrayList<Telefone>();
		emails2 = new ArrayList<Email>();
		uf1 = new Uf("1200013", "São Paulo", "SP", "Brasil");
		endereco1 = new Endereco("04053041", 34);
		empresa1 = new Empresa("15619162000180", "Escritorio de Software", "DevStyle", telefones, emails, listaEnderecos, listaFuncionarios); 
		dataHoje = LocalDate.now();
		funcionarioCompleto = new Funcionario("13234375097", empresa1, "João", LocalDate.of(1993, 11, 3), LocalDate.now(), LocalDate.now(), telefones, emails, endereco1, SALARIO, "Gerente");
	} 
	
	@After 
	public void tearDown() {
	} 
	
	@BeforeClass 
	public static void setUpClass() {  
		System.out.println("Inicializando a classe"); 
	}
	
	@AfterClass 
	public static void tearDownClass() {
		System.out.println("Finalizando a classe");
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR OBRIGATORIOS ////////////////////////////////////////////////////
	@Test(timeout = 1000)
	public void deve_verificar_o_construtor_classe_obrigatorio_1() {
		Funcionario f1 = new Funcionario(CPF, empresa1);
		
		assertNotNull(f1);
		assertEquals(CPF, f1.getCpf());
		assertEquals(empresa1, f1.getEmpresa());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_construtor_obrigatorio_com_cpf_nulo_1() {
		funcionario = new Funcionario(null, empresa1);
	}
	
	@Test
	public void deve_verificar_o_construtor_classe_obrigatorio_2() {
		Funcionario f1 = new Funcionario(CPF_2, empresa1, NOME_FUNCIONARIO_2);
		
		assertNotNull(f1);
		assertEquals(CPF_2, f1.getCpf());
		assertEquals(NOME_FUNCIONARIO_2, f1.getNome());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_construtor_obrigatorio_com_cpf_nulo_2() {
		funcionario = new Funcionario(null, empresa1, NOME_FUNCIONARIO_2);
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR //////////////////////////////////////////////////// 
	@Test
	public void deve_verificar_o_construtor_classe() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		
		Funcionario f1 = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
		
		assertNotNull(f1);
		assertEquals(CPF, f1.getCpf());
		assertEquals(empresa1, f1.getEmpresa());
		assertEquals(NOME_FUNCIONARIO, f1.getNome());
		assertEquals(DATA_ANIVERSARIO, f1.getDataNascimento());
		assertEquals(DATA_ADMISSAO, f1.getDataAdmissao());
		assertEquals(DATA_ENCERRAMENTO_CONTRATO, f1.getDataEncerramentoContrato());
		assertEquals(telefones, f1.getTelefones());
		assertEquals(emails, f1.getEmails());
		assertEquals(SALARIO, f1.getSalario());
		assertEquals(CARGO, f1.getCargo());
		assertEquals(endereco1, f1.getEndereco());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_cpf_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(null, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_empresa_nulo() {
		endereco1.setLogradouro("Rua Tal");
		funcionario = new Funcionario(CPF, null, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_nome_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, null, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_data_de_nascimento_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, null, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_data_de_admissao_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, null, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_data_encerramento_contrato_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, null, telefones, emails, endereco1, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_telefone_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, null, emails, endereco1, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_email_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, null, endereco1, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_endereco_nulo() {
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, null, SALARIO, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_salario_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, null, CARGO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_funcionario_com_cargo_nulo() {
		endereco1.setLogradouro("Rua Tal");
		empresa1.setNomeFantasia("Nismo");
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, null);
	}
	
	//////////////////////////////////////////////////// TESTE NOME ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome() {
		assertThat(funcionarioCompleto.getNome(), is("João"));	
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_nome() {
		assertThat(funcionarioCompleto.getNome(), is("João"));	
	}
	
	@Test
	public void deve_aceitar_nome_e_sobrenome_com_um_espaco() {
		funcionarioCompleto.setNome("João Silva");
	}
	
	@Test
	public void deve_verificar_que_nome_nao_sao_iguais() {
		funcionarioCompleto.setNome("João");
		assertThat(funcionarioCompleto.getNome(), is(not("Maria")));	
	}
	
	@Test
	public void deve_aceitar_nome_que_contem_ponto() { 
		funcionarioCompleto.setNome("João S. Santos Jr.");
		assertThat(funcionarioCompleto.getNome(), is("João S. Santos Jr."));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_nome_nulo() { 
		funcionarioCompleto.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_nome_vazio() {
		funcionarioCompleto.setNome("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_contendo_numeros() {
		funcionarioCompleto.setNome("João123");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_caracteres_especiais() {
		funcionarioCompleto.setNome("Joao@&*");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_mais_de_60_caracteres() {
		funcionarioCompleto.setNome("Ana Maria Clara Ana Maria Clara Ana Maria Clara Ana Maria Clara Ana Maria Clara");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_menos_de_3_caracteres() {
		funcionarioCompleto.setNome("An");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espacos_no_inicio() {
		funcionarioCompleto.setNome(" João");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espacos_no_final() {
		funcionarioCompleto.setNome("João ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_mais_de_um_espaco_no_meio() {
		funcionarioCompleto.setNome("João   Silva");
	}
	
	//////////////////////////////////////////////////// TESTE DATA NASCIMENTO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_nascimento() {
		LocalDate dataNascimento = LocalDate.of(1921, 1, 1);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
		assertEquals(funcionarioCompleto.getDataNascimento(), dataNascimento);	 
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_data_nascimento() {
		LocalDate dataNascimento = LocalDate.of(1921, 1, 1);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
		assertEquals(funcionarioCompleto.getDataNascimento(), dataNascimento);	 
	}
	
	@Test
	public void deve_aceitar_data_nascimento_maior_16_anos() {
		LocalDate dataNascimento = LocalDate.of(1990, 10, 1);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
	}
	
	@Test
	public void deve_aceitar_data_nascimento_16_anos_completos() {
		LocalDate dataNascimento = LocalDate.of(2005, 11, 25);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
	}
	
	@Test
	public void deve_aceitar_data_nascimento_16_anos_hoje() {
		LocalDate dataNascimento = LocalDate.of(dataHoje.getYear() - IDADE_MINIMA_FUNCIONARIO, dataHoje.getMonthValue(), dataHoje.getDayOfMonth());
		funcionarioCompleto.setDataNascimento(dataNascimento); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_nascimento_funcionario_menor_de_16_anos() {
		LocalDate dataNascimento = LocalDate.of(2009, 01, 12);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_nascimento_antiga() {
		LocalDate dataNascimento = LocalDate.of(1800, 1, 1);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_nascimento_futura() {
		LocalDate dataNascimento = LocalDate.of(2077, 1, 1);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_nascimento_minoridade() {
		LocalDate dataNascimento = LocalDate.of(2018, 1, 1);
		funcionarioCompleto.setDataNascimento(dataNascimento); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_data_nulo() {
		funcionarioCompleto.setDataNascimento(null);
	}
	
	////////////////////////////////////////////////// TESTE DATA ADMISSAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_admissao() {
		LocalDate dataAdmissao = LocalDate.of(2022, 2, 7);
		funcionarioCompleto.setDataAdmissao(dataAdmissao); 
		assertEquals(funcionarioCompleto.getDataAdmissao(), dataAdmissao);	 
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_data_admissao() {
		LocalDate dataAdmissao = LocalDate.of(2022, 2, 7);
		funcionarioCompleto.setDataAdmissao(dataAdmissao); 
		assertEquals(funcionarioCompleto.getDataAdmissao(), dataAdmissao);	 
	}
	
	@Test
	public void deve_verificar_que_data_admissao_nao_sao_iguais() {
		LocalDate dataAdmissao = LocalDate.of(2021, 3, 7);
		assertThat(funcionarioCompleto.getDataAdmissao(), is(not(dataAdmissao)));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_admissao_futura() {
		LocalDate dataAdmissao = LocalDate.of(dataHoje.getYear() + 30, 3, 7);
		funcionarioCompleto.setDataAdmissao(dataAdmissao); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_admissao_muito_antiga() {
		LocalDate dataAdmissao = LocalDate.of(1900, 3, 7);
		funcionarioCompleto.setDataAdmissao(dataAdmissao); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_funcionario_admitido_3_meses_no_futuro() {
		LocalDate dataAdmissao = LocalDate.of(dataHoje.getYear(), dataHoje.getMonthValue() + 3, dataHoje.getDayOfMonth());
		funcionarioCompleto.setDataAdmissao(dataAdmissao); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_funcionario_admitido_5_meses_no_futuro() {
		LocalDate dataAdmissao = LocalDate.of(dataHoje.getYear(), dataHoje.getMonthValue() + 5, dataHoje.getDayOfMonth());
		funcionarioCompleto.setDataAdmissao(dataAdmissao); 
	}
	
	////////////////////////////////////////////////// TESTE DATA ENCERRAMENTO CONTRATO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_encerramento_contrato() {
		funcionarioCompleto.setDataEncerramentoContrato(dataHoje); 
		assertEquals(funcionarioCompleto.getDataEncerramentoContrato(), dataHoje);	 
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_data_encerramento_contrato() {
		funcionarioCompleto.setDataEncerramentoContrato(dataHoje); 
		assertEquals(funcionarioCompleto.getDataEncerramentoContrato(), dataHoje);	 
	}
	
	@Test
	public void deve_verificar_que_data_encerramento_contrato_nao_sao_iguais() {
		LocalDate dataEncerramentoContrato = LocalDate.of(2021, 3, 7);
		assertThat(funcionarioCompleto.getDataEncerramentoContrato(), is(not(dataEncerramentoContrato)));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_encerramento_contrato_futura() {
		LocalDate dataEncerramentoContrato = LocalDate.of(dataHoje.getYear() + 3, 3, 7);
		funcionarioCompleto.setDataEncerramentoContrato(dataEncerramentoContrato); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_encerramento_contrato_muito_antiga() {
		LocalDate dataEncerramentoContrato = LocalDate.of(1900, 3, 7);
		funcionarioCompleto.setDataEncerramentoContrato(dataEncerramentoContrato); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_funcionario_com_encerramento_contrato_1_ano_no_futuro() {
		LocalDate dataEncerramentoContrato = LocalDate.of(dataHoje.getYear() + 1, dataHoje.getMonthValue(), dataHoje.getDayOfMonth());
		funcionarioCompleto.setDataEncerramentoContrato(dataEncerramentoContrato); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_funcionario_com_encerramento_contrato_5_meses_no_futuro() {
		LocalDate dataEncerramentoContrato = LocalDate.of(dataHoje.getYear(), dataHoje.getMonthValue() + 5, dataHoje.getDayOfMonth());
		funcionarioCompleto.setDataEncerramentoContrato(dataEncerramentoContrato); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_encerramento_contrato_anterior_a_data_admissao() {
		LocalDate dataAdmissao = now();
		LocalDate dataEncerramentoContrato = LocalDate.of(2020, 01, 01);;
		funcionarioCompleto.setDataAdmissao(dataAdmissao);
		funcionarioCompleto.setDataEncerramentoContrato(dataEncerramentoContrato);
	}
	
	//////////////////////////////////////////////////// TESTE LISTA TELEFONE ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_lista_de_telefone_com_tamanho_3() {
		telefones2.add(new Telefone("+55", "11", "988932333"));
		telefones2.add(new Telefone("+55", "11", "999999999"));
		telefones2.add(new Telefone("+55", "11", "977775555"));

		funcionarioCompleto.setTelefones(telefones2);
		assertNotNull(funcionarioCompleto.getTelefones());
		assertEquals(3, funcionarioCompleto.getTelefones().size());
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_lista_de_telefone_com_tamanho_3() {
		telefones2.add(new Telefone("+55", "11", "988932333"));
		telefones2.add(new Telefone("+55", "11", "999999999"));
		telefones2.add(new Telefone("+55", "11", "977775555"));

		funcionarioCompleto.setTelefones(telefones2);
		assertNotNull(funcionarioCompleto.getTelefones());
		assertEquals(3, funcionarioCompleto.getTelefones().size());
	}

	@Test
	public void deve_aceitar_lista_de_telefone_com_tamanho_4() {
		for (int i = 0; i < 4; i++) {
			telefones2.add(new Telefone("+55", "11", "985936133"));
		}
		funcionarioCompleto.setTelefones(telefones2);

		assertNotNull(funcionarioCompleto.getTelefones());
		assertEquals(4, funcionarioCompleto.getTelefones().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_lista_de_telefone_nulo() {
		funcionarioCompleto.setTelefones(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_telefone_com_tamanho_menor_que_1() {
		funcionarioCompleto.setTelefones(telefones2);
	}

	@Test(expected = IllegalStateException.class) 
	public void nao_deve_aceitar_lista_de_telefone_com_tamanho_maior_que_4() {
		for (int i = 0; i <= 5; i++) {
			telefones2.add(new Telefone("+55", "11", "985936133"));
		}
		funcionarioCompleto.setTelefones(telefones2);
	}
	
	//////////////////////////////////////////////////// TESTE LISTA EMAIL ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_lista_de_email_com_tamanho_2() {
		emails2.add(new Email("erich@gmail.com"));
		emails2.add(new Email("erich@gmail.com"));

		funcionarioCompleto.setEmails(emails2);
		assertNotNull(funcionarioCompleto.getEmails());
		assertEquals(2, funcionarioCompleto.getEmails().size());
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_lista_de_email_com_tamanho_2() {
		emails2.add(new Email("erich@gmail.com"));
		emails2.add(new Email("erich@gmail.com"));

		funcionarioCompleto.setEmails(emails2);
		assertNotNull(funcionarioCompleto.getEmails());
		assertEquals(2, funcionarioCompleto.getEmails().size());
	}

	@Test
	public void deve_aceitar_lista_de_email_com_tamanho_3() {
		for (int i = 0; i < 3; i++) {
			emails2.add(new Email("erich@gmail.com"));
		}
		funcionarioCompleto.setEmails(emails2);
		assertNotNull(funcionarioCompleto.getEmails());
		assertEquals(3, funcionarioCompleto.getEmails().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_lista_de_email_nulo() {
		funcionarioCompleto.setEmails(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_email_com_tamanho_menor_que_2() {
		emails2.add(new Email("erich@gmail.com"));
		funcionarioCompleto.setEmails(emails2);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_email_com_tamanho_maior_que_3() {
		for (int i = 0; i <= 5; i++) {
			emails2.add(new Email("erich@gmail.com"));
		}
		funcionarioCompleto.setEmails(emails2);
	}
	
	//////////////////////////////////////////////////// TESTE CPF ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_cpf_valido(){
		funcionarioCompleto.setCpf("04731784000");
		assertThat(funcionarioCompleto.getCpf(), is("04731784000"));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_cpf_valido(){
		funcionarioCompleto.setCpf("04731784000");
		assertThat(funcionarioCompleto.getCpf(), is("04731784000"));
	}
	
	@Test
	public void deve_verificar_que_cpf_nao_sao_iguais() {
		assertThat(funcionarioCompleto.getCpf(), is(not("05179351049")));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_com_digito_verificador_1_invalido(){
		funcionarioCompleto.setCpf("53865496098");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_com_digito_verificador_2_invalido(){
		funcionarioCompleto.setCpf("53865496009");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cpf_nulo() {
		funcionarioCompleto.setCpf(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_vazio() {
		funcionarioCompleto.setCpf("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_com_mais_de_onze_numeros() {
		funcionarioCompleto.setCpf("12345678901234567");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_com_menos_de_onze_numeros() {
		funcionarioCompleto.setCpf("01234567");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_zeros() {
		funcionarioCompleto.setCpf("00000000000");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_1() {
		funcionarioCompleto.setCpf("11111111111");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_2() {
		funcionarioCompleto.setCpf("22222222222");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_3() {
		funcionarioCompleto.setCpf("33333333333");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_4() {
		funcionarioCompleto.setCpf("44444444444");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_5() {
		funcionarioCompleto.setCpf("55555555555");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_6() {
		funcionarioCompleto.setCpf("66666666666");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_7() {
		funcionarioCompleto.setCpf("77777777777");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_8() {
		funcionarioCompleto.setCpf("88888888888");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cpf_somente_com_9() {
		funcionarioCompleto.setCpf("99999999999");
	}
	
	//////////////////////////////////////////////////// TESTE ENDERECO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_endereco_valido(){
		endereco1.setLogradouro("Rua Teste");
		assertThat(endereco1.getLogradouro(), is("Rua Teste"));	
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_endereco_valido(){
		endereco1.setLogradouro("Rua Teste");
		assertThat(endereco1.getLogradouro(), is("Rua Teste"));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_endereco_nulo() {
		endereco1.setLogradouro(null);
	}
	
	//////////////////////////////////////////////////// TESTE SALARIO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_salario(){
		funcionarioCompleto.setSalario(new BigDecimal("5000.0"));
		assertThat(funcionarioCompleto.getSalario(), is((new BigDecimal("5000.0"))));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_salario(){
		funcionarioCompleto.setSalario(new BigDecimal("5000.0"));
		assertThat(funcionarioCompleto.getSalario(), is((new BigDecimal("5000.0"))));
	}
	
	@Test
	public void deve_verificar_que_salario_nao_sao_iguais() {
		assertThat(funcionarioCompleto.getSalario(), is(not(new BigDecimal("10.0"))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_salario_nulo() {
		funcionarioCompleto.setSalario(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_salario_menor_ou_igual_a_zero() {
		funcionarioCompleto.setSalario(new BigDecimal("0.0"));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_salario_menor_do_que_salario_minimo() {
		funcionarioCompleto.setSalario(new BigDecimal("1000.0"));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_salario_maior_do_que_salario_maximo() {
		funcionarioCompleto.setSalario(new BigDecimal("10000000.0"));
	}
	
	//////////////////////////////////////////////////// TESTE CARGO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_cargo(){
		funcionarioCompleto.setCargo("Suporte");
		assertEquals("Suporte", funcionarioCompleto.getCargo());
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_cargo(){
		funcionarioCompleto.setCargo("Suporte");
		assertEquals("Suporte", funcionarioCompleto.getCargo());
	}
	
	@Test
	public void deve_verificar_que_cargo_nao_sao_iguais() {
		assertThat(funcionarioCompleto.getCargo(), is(not("Teste")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_cargo_nulo() {
		funcionarioCompleto.setCargo(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_cargo_vazio() {
		funcionarioCompleto.setCargo("");
	}
	
	//////////////////////////////////////////////////// TESTE ENDERECO ////////////////////////////////////////////////////
	@Test(expected = IllegalArgumentException.class)
	public void rua_nao_deve_ser_nulo() {
		endereco1.setLogradouro(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void numero_nao_deve_ser_nulo() {
		endereco1.setNumero(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void complemento_nao_deve_ser_nulo() {
		endereco1.setComplemento(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cep_nao_deve_ser_nulo() {
		endereco1.setCep(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cidade_nao_deve_ser_nulo() {
		endereco1.setCidade(null);
	}
	
	//////////////////////////////////////////////////// TESTE EMPRESA ////////////////////////////////////////////////////
	@Test(expected = IllegalArgumentException.class)
	public void razao_social_nao_deve_ser_nulo() {
		empresa1.setRazaoSocial(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nome_fantasia_nao_deve_ser_nulo() {
		empresa1.setNomeFantasia(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cnpj_nao_deve_ser_nulo() {
		empresa1.setCnpj(null);
	}

	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_nome_data_telefone_email_cpf_endereco_salario_cargo_no_tostring() {
		endereco1.setLogradouro("Rua A");
		endereco1.setCep("62120970");
		endereco1.setCidade(new Cidade("3550308", "São Paulo", uf1));
		empresa1.setNomeFantasia("Casa do Pão");
				
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
		assertEquals(RESULTADO_ESPERADO, funcionario.toString());
	}
	
	@Test
	public void nao_deve_retornar_nome_data_telefone_email_cpf_endereco_salario_cargo_no_tostring() {
		endereco1.setLogradouro("Rua A");
		endereco1.setCep("62120970");
		endereco1.setCidade(new Cidade("3550308", "São Paulo", uf1));
		empresa1.setNomeFantasia("Bar do Zé");
				
		funcionario = new Funcionario(CPF, empresa1, NOME_FUNCIONARIO_2, DATA_ANIVERSARIO, DATA_ADMISSAO, DATA_ENCERRAMENTO_CONTRATO, telefones, emails, endereco1, SALARIO, CARGO);
		assertNotEquals(RESULTADO_ESPERADO, funcionario.toString());
	}
	
	////////////////////////////////////////////////////TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
		Funcionario f1 = new Funcionario("04731784000", empresa1);
		Funcionario f2 = new Funcionario("04731784000", empresa1);
		
	    assertEquals(f1.hashCode(), f2.hashCode());
	}

	@Test
	public void nao_devem_ter_hashcode_iguais() {
		Funcionario f1 = new Funcionario("04731784000", empresa1);
		Funcionario f2 = new Funcionario("61100746080", empresa1);
		
	    assertNotEquals(f1.hashCode(), f2.hashCode());
	}

	////////////////////////////////////////////////////TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		Funcionario f1 = new Funcionario("04731784000", empresa1);
		Funcionario f2 = new Funcionario("04731784000", empresa1);

		assertTrue(f1.equals(f2) && f2.equals(f1));
	}
	
	@Test
	public void equals_deve_retornar_false_codigo_diferente() {
		Funcionario f1 = new Funcionario("15655845032", empresa1);
		Funcionario f2 = new Funcionario("13595359003", empresa1);

		assertFalse(f1.equals(f2) && f2.equals(f1));
	}

	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		Funcionario f1 = new Funcionario("85162335029", empresa1);
		assertTrue(f1.equals(f1));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		Funcionario f1 = new Funcionario("85162335029", empresa1);
		assertFalse(f1.equals(null));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		Funcionario f1 = new Funcionario("85162335029", empresa1);
		assertFalse(f1.equals(new Object()));
	}
	
	//////////////////////////////////////////////////// TESTE AUDITORIA ////////////////////////////////////////////////////
	////////////////////////////////////////////////// TESTE NOME CRIACAO ///////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome_criacao() {
		funcionarioCompleto.setNomeUsuarioCriacao("Marcelo");
		assertThat(funcionarioCompleto.getNomeUsuarioCriacao(), is("Marcelo"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_nome_criacao_nulo() {
		funcionarioCompleto.setNomeUsuarioCriacao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_nome_criacao_vazio() {
		funcionarioCompleto.setNomeUsuarioCriacao("");
	}

	////////////////////////////////////////////////// TESTE DATA CRIACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_criacao() {
		LocalDateTime dataCriacao = LocalDateTime.of(2023, 12, 12, 12, 00);
		funcionarioCompleto.setDataCriacao(dataCriacao);
		assertEquals(funcionarioCompleto.getDataCriacao(), dataCriacao);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_data_criacao_nulo() {
		funcionarioCompleto.setDataCriacao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_criacao_acima_de_1_ano() {
		LocalDateTime dataCriacao = LocalDateTime.of(2027, 12, 12, 12, 00);
		funcionarioCompleto.setDataCriacao(dataCriacao);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_criacao_abaixo_de_1_ano() {
		LocalDateTime dataCriacao = LocalDateTime.of(2015, 12, 12, 12, 00);
		funcionarioCompleto.setDataCriacao(dataCriacao);
	}

	////////////////////////////////////////////////// TESTE IP CRIACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ip_criacao() {
		funcionarioCompleto.setIpCriacao("1.1.1.1");
		assertThat(funcionarioCompleto.getIpCriacao(), is("1.1.1.1"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ip_criacao_nulo() {
		funcionarioCompleto.setIpCriacao(null);
	}

	////////////////////////////////////////////////// TESTE NOME ALTERACAO ///////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome_alteracao() {
		funcionarioCompleto.setNomeUsuarioAlteracao("Marcelo");
		assertThat(funcionarioCompleto.getNomeUsuarioAlteracao(), is("Marcelo"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_nome_alteracao_nulo() {
		funcionarioCompleto.setNomeUsuarioAlteracao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_nome_alteracao_vazio() {
		funcionarioCompleto.setNomeUsuarioAlteracao("");
	}

	////////////////////////////////////////////////// TESTE DATA ALTERACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_alteracao() {
		funcionarioCompleto.setDataCriacao(DATA_CRIACAO);
		funcionarioCompleto.setDataAlteracao(DATA_ALTERACAO_HOJE);
	}
	
	@Test
	public void deve_aceitar_data_alteracao_iguais() {
		funcionarioCompleto.setDataCriacao(DATA_CRIACAO);
		funcionarioCompleto.setDataAlteracao(DATA_ALTERACAO_HOJE);
		assertThat(funcionarioCompleto.getDataAlteracao(), is(DATA_ALTERACAO_HOJE));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_data_alteracao_nulo() {
		funcionarioCompleto.setDataAlteracao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_alteracao_com_data_criacao_nula() {
		LocalDateTime dataAlteracao = LocalDateTime.now();
		funcionarioCompleto.setDataAlteracao(dataAlteracao);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_alteracao_anterior_a_data_criacao() {
		LocalDateTime dataCriacao = LocalDateTime.now();
		LocalDateTime dataAlteracao = LocalDateTime.of(2020, 04, 18, 12, 00);
		funcionarioCompleto.setDataCriacao(dataCriacao);
		funcionarioCompleto.setDataAlteracao(dataAlteracao);
	}

	////////////////////////////////////////////////// TESTE IP ALTERACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ip_alteracao() {
		funcionarioCompleto.setIpAlteracao("0.0.0.0");
		assertThat(funcionarioCompleto.getIpAlteracao(), is("0.0.0.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ip_alteracao_nulo() {
		funcionarioCompleto.setIpAlteracao(null);
	}

}