package br.com.contmatic.prova.test.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.prova.contato.Email;
import br.com.contmatic.prova.contato.Telefone;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.empresa.Funcionario;
import br.com.contmatic.prova.endereco.Endereco;

public class EmpresaTest {
	
	private static final String RESULTADO_ESPERADO = "Empresa [razaoSocial=Top Photos, nomeFantasia=Photoshop, cnpj=83699173000177, telefone=[Telefone [ddi=+55, ddd=11, numero=22334455, tipo=Comercial], Telefone [ddi=+55, ddd=11, numero=999999999, tipo=Comercial], Telefone [ddi=+55, ddd=11, numero=977775555, tipo=Comercial]], email=[Email [enderecoEmail=erich@gmail.com, tipo=null], Email [enderecoEmail=erich@gmail.com, tipo=null], Email [enderecoEmail=erich@gmail.com, tipo=null]], enderecos=[Endereco [rua=null, numero=1, complemento=null, cep=04117010, cidade=null], Endereco [rua=null, numero=2, complemento=null, cep=02728000, cidade=null], Endereco [rua=null, numero=3, complemento=null, cep=05208060, cidade=null]], funcionarios=[Funcionario [nome=Erich, dataNascimento=null, telefone=null, email=null, cpf=17255071023, endereco=null, salario=null, cargo=null, empresa=null], Funcionario [nome=Marco, dataNascimento=null, telefone=null, email=null, cpf=17255071023, endereco=null, salario=null, cargo=null, empresa=null], Funcionario [nome=João, dataNascimento=null, telefone=null, email=null, cpf=17255071023, endereco=null, salario=null, cargo=null, empresa=null], Funcionario [nome=Maria, dataNascimento=null, telefone=null, email=null, cpf=17255071023, endereco=null, salario=null, cargo=null, empresa=null]]]";
	private static final String RAZAO_SOCIAL = "Top Photos";
	private static final String RAZAO_SOCIAL_2 = "Top S. Photos LTDA.";
	private static final String NOME_FANTASIA = "Photoshop";
	private static final String NOME_FANTASIA_2 = "Photoshop LTDA.";
	private static final String CNPJ_EMPRESA = "04781062000139";
	private static final String CNPJ_EMPRESA_2 = "83699173000177";
	private static final LocalDateTime DATA_CRIACAO = LocalDateTime.of(2022, 04, 18, 12, 00);
	private static final LocalDateTime DATA_ALTERACAO_HOJE = LocalDateTime.now();
	
	private List<Telefone> telefone;
	private List<Telefone> telefone2; 
	private List<Email> email;
	private List<Email> email2;
	private List<Endereco> enderecos;
	private List<Endereco> enderecos2;
	private List<Funcionario> funcionarios;
	private List<Funcionario> funcionarios2;
	private Empresa empresa;
	private Empresa empresaObrigatorio;
	private Empresa empresaCompleto;
	private Empresa empresaCompleto2;
	
	@Before
	public void setUp() {  
		telefone = new ArrayList<Telefone>(); 
		telefone.add(new Telefone("+55", "11", "22334455", "Comercial"));
		telefone.add(new Telefone("+55", "11", "999999999", "Comercial"));
		telefone.add(new Telefone("+55", "11", "977775555", "Comercial"));
		
		email = new ArrayList<Email>();
		email.add(new Email("erich@gmail.com"));
		email.add(new Email("erich@gmail.com"));
		email.add(new Email("erich@gmail.com"));
		
		enderecos = new ArrayList<Endereco>();
		enderecos.add(new Endereco(1, "04117010"));
		enderecos.add(new Endereco(2, "02728000"));
		enderecos.add(new Endereco(3, "05208060"));
		
		funcionarios = new ArrayList<Funcionario>();
		funcionarios.add(new Funcionario("17255071023", "Erich"));
		funcionarios.add(new Funcionario("17255071023", "Marco"));
		funcionarios.add(new Funcionario("17255071023", "João"));
		funcionarios.add(new Funcionario("17255071023", "Maria"));
		
		telefone2 = new ArrayList<Telefone>();
		email2 = new ArrayList<Email>();
		enderecos2 = new ArrayList<Endereco>(); 
		funcionarios2 = new ArrayList<Funcionario>(); 
		empresaObrigatorio = new Empresa("65141186000144");
		empresaCompleto = new Empresa("Escritório de Software", "DevStyle", "79946237000110", telefone, email, enderecos, funcionarios);
		empresaCompleto2 = new Empresa("Escritório de fotos", "Top Photos", "49445772000126", telefone, email, enderecos, funcionarios);
	}
	
	@After 
	public void tearDown() { 
		System.out.println("After"); 
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
	@Test
	public void deve_verificar_o_construtor_classe_obrigatorio() {
		Empresa emp1 = new Empresa(CNPJ_EMPRESA);
		
		assertNotNull(emp1);
		assertEquals(CNPJ_EMPRESA, emp1.getCnpj());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_construtor_obrigatorio_com_cnpj_nulo() {
		empresa = new Empresa(null);
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
		Empresa e1 = new Empresa(RAZAO_SOCIAL, NOME_FANTASIA, CNPJ_EMPRESA, telefone, email, enderecos, funcionarios);
		
		assertNotNull(e1);
		assertEquals(RAZAO_SOCIAL, e1.getRazaoSocial());
		assertEquals(NOME_FANTASIA, e1.getNomeFantasia());
		assertEquals(CNPJ_EMPRESA, e1.getCnpj());
		assertEquals(telefone, e1.getTelefone());
		assertEquals(email, e1.getEmail());
		assertEquals(enderecos, e1.getEnderecos());
		assertEquals(funcionarios, e1.getFuncionarios());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_com_razao_social_nulo() {
		empresa = new Empresa(null, NOME_FANTASIA, CNPJ_EMPRESA, telefone, email, enderecos, funcionarios);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_com_nome_fantasia_nulo() {
		empresa = new Empresa(RAZAO_SOCIAL, null, CNPJ_EMPRESA, telefone, email, enderecos, funcionarios);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_com_cnpj_nulo() {
		empresa = new Empresa(RAZAO_SOCIAL, NOME_FANTASIA, null, telefone, email, enderecos, funcionarios);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_com_telefone_nulo() {
		empresa = new Empresa(RAZAO_SOCIAL, NOME_FANTASIA, CNPJ_EMPRESA, null, email, enderecos, funcionarios);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_com_email_nulo() {
		empresa = new Empresa(RAZAO_SOCIAL, NOME_FANTASIA, CNPJ_EMPRESA, telefone, null, enderecos, funcionarios);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_com_endereco_nulo() {
		empresa = new Empresa(RAZAO_SOCIAL, NOME_FANTASIA, CNPJ_EMPRESA, telefone, email, null, funcionarios);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_empresa_com_funcionario_nulo() {
		empresa = new Empresa(RAZAO_SOCIAL, NOME_FANTASIA, CNPJ_EMPRESA, telefone, email, enderecos, null);
	}
	
	//////////////////////////////////////////////////// TESTE RAZAO SOCIAL ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_razao_social() {
		empresaCompleto.getRazaoSocial();
		assertThat(empresaCompleto.getRazaoSocial(), is("Escritório de Software"));	
	}
	
	@Test
	public void deve_verificar_que_razao_social_nao_e_o_da_mesma_empresa() {
		empresaCompleto.getRazaoSocial();
		assertThat(empresaCompleto.getRazaoSocial(), is(not("Escritório de fotos")));	
	}
	
	@Test
	public void deve_aceitar_razao_social_que_contem_ponto() {
		empresaCompleto.setRazaoSocial(RAZAO_SOCIAL_2);
		assertThat(empresaCompleto.getRazaoSocial(), is(RAZAO_SOCIAL_2));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_razao_social_nulo() {
		empresaCompleto.setRazaoSocial(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_vazio() {
		empresaCompleto.setRazaoSocial("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_contendo_numeros() {
		empresaCompleto.setRazaoSocial("Top123");
		assertThat(empresa.getRazaoSocial(), is("Top123"));	
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_com_caracteres_especiais() {
		empresaCompleto.setRazaoSocial("Top@&*");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_com_mais_de_60_caracteres() {
		empresaCompleto.setRazaoSocial("Top PhotosTop PhotosTop PhotosTop PhotosTop PhotosTop PhotosTop Photos");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_com_menos_de_3_caracteres() {
		empresaCompleto.setRazaoSocial("To");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_com_espacos_no_inicio() {
		empresaCompleto.setRazaoSocial(" Top Photos");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_com_espacos_no_final() {
		empresaCompleto.setRazaoSocial("Top Photos ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_razao_social_com_mais_de_um_espaco_no_meio() {
		empresaCompleto.setRazaoSocial("Top    Photos");
	}
	
	//////////////////////////////////////////////////// TESTE NOME FANTASIA ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome_fantasia() {
		empresaCompleto.getNomeFantasia();
		assertThat(empresaCompleto.getNomeFantasia(), is("DevStyle"));	
	}
	
	@Test
	public void deve_verificar_que_nome_fantasia_nao_e_o_da_mesma_empresa() {
		empresaCompleto.getNomeFantasia();
		assertThat(empresaCompleto.getNomeFantasia(), is(not("Top Photos")));	
	}
	
	@Test
	public void deve_aceitar_nome_fantasia_que_contem_ponto() {
		empresaCompleto.setNomeFantasia(NOME_FANTASIA_2);
		assertThat(empresaCompleto.getNomeFantasia(), is(NOME_FANTASIA_2));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_fantasia_nulo() {
		empresaCompleto.setNomeFantasia(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_vazio() {
		empresaCompleto.setNomeFantasia("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_contendo_numeros() {
		empresaCompleto.setNomeFantasia("Top123");
		assertThat(empresa.getNomeFantasia(), is("Top123"));	
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_com_caracteres_especiais() {
		empresaCompleto.setNomeFantasia("Top@&*");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_com_mais_de_60_caracteres() {
		empresaCompleto.setNomeFantasia("Top PhotosTop PhotosTop PhotosTop PhotosTop PhotosTop PhotosTop Photos");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_com_menos_de_3_caracteres() {
		empresaCompleto.setNomeFantasia("To");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_com_espacos_no_inicio() {
		empresaCompleto.setNomeFantasia(" Top Photos");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_com_espacos_no_final() {
		empresaCompleto.setNomeFantasia("Top Photos ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_fantasia_com_mais_de_um_espaco_no_meio() {
		empresaCompleto.setNomeFantasia("Top     Photos");
	}

	//////////////////////////////////////////////////// TESTE CNPJ ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_se_e_o_mesmo_cnpj() {
		empresaObrigatorio.setCnpj("50449092000160");
		assertEquals(empresaObrigatorio, empresaObrigatorio);	
	}
	
	@Test
	public void deve_aceitar_cnpj_valido(){
		empresaObrigatorio.setCnpj("65680711000108");
		assertThat(empresaObrigatorio.getCnpj(), is("65680711000108")); 
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_com_digito_verificador_1_invalido(){
		empresaObrigatorio.setCnpj("69251819000198");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_com_digito_verificador_2_invalido(){
		empresaObrigatorio.setCnpj("69251819000129");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cnpj_nulo() {
		empresaObrigatorio.setCnpj(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_vazio() {
		empresaObrigatorio.setCnpj("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_com_mais_de_quatorze_numeros() {
		empresaObrigatorio.setCnpj("385806380001113");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_com_menos_de_quatorze_numeros() {
		empresaObrigatorio.setCnpj("57745588");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_zeros() {
		empresaObrigatorio.setCnpj("00000000000000");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_1() {
		empresaObrigatorio.setCnpj("11111111111111");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_2() {
		empresaObrigatorio.setCnpj("22222222222222");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_3() {
		empresaObrigatorio.setCnpj("33333333333333");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_4() {
		empresaObrigatorio.setCnpj("44444444444444");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_5() {
		empresaObrigatorio.setCnpj("55555555555555");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_6() {
		empresaObrigatorio.setCnpj("66666666666666");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_7() {
		empresaObrigatorio.setCnpj("77777777777777");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_8() {
		empresaObrigatorio.setCnpj("88888888888888");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cnpj_somente_com_9() {
		empresaObrigatorio.setCnpj("99999999999999");
	}
	
	//////////////////////////////////////////////////// TESTE LISTA TELEFONE ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_lista_de_telefone_com_tamanho_3() {
		telefone2.add(new Telefone("+55", "11", "988932333"));
		telefone2.add(new Telefone("+55", "11", "999999999"));
		telefone2.add(new Telefone("+55", "11", "977775555"));
		
		empresaCompleto.setTelefone(telefone2);
		assertNotNull(empresaCompleto.getTelefone());
		assertEquals(3, empresaCompleto.getTelefone().size());
	}
	
	@Test
	public void deve_aceitar_lista_de_telefone_com_tamanho_4() {
		for (int i = 0; i < 4; i++) {
			telefone2.add(new Telefone("+55", "22", "985936133"));
		}
		empresaCompleto.setTelefone(telefone2);
		
		assertNotNull(empresaCompleto.getTelefone());
		assertEquals(4, empresaCompleto.getTelefone().size());
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_lista_de_telefone_nulo() {
		empresaCompleto.setTelefone(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_telefone_com_tamanho_menor_que_2() {
		telefone2.add(new Telefone("+55", "22", "985936133"));
		empresaCompleto.setTelefone(telefone2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_telefone_com_tamanho_maior_que_4() {
		for (int i = 0; i <= 5; i++) {
			telefone2.add(new Telefone("+55", "22", "985936133"));
		}
		empresaCompleto.setTelefone(telefone2);
	}
	
	//////////////////////////////////////////////////// TESTE LISTA EMAIL ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_lista_de_email_com_tamanho_2() {
		email2.add(new Email("erich@gmail.com"));
		email2.add(new Email("erich@gmail.com"));

		empresaCompleto.setEmail(email2);
		assertNotNull(empresaCompleto.getEmail());
		assertEquals(2, empresaCompleto.getEmail().size());
	}

	@Test
	public void deve_aceitar_lista_de_email_com_tamanho_3() {
		for (int i = 0; i < 3; i++) {
			email2.add(new Email("erich@gmail.com"));
		}
		empresaCompleto.setEmail(email2);
		assertNotNull(empresaCompleto.getEmail());
		assertEquals(3, empresaCompleto.getEmail().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_lista_de_email_nulo() {
		empresaCompleto.setEmail(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_email_com_tamanho_menor_que_2() {
		email2.add(new Email("erich@gmail.com"));
		empresaCompleto.setEmail(email2);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_email_com_tamanho_maior_que_3() {
		for (int i = 0; i <= 5; i++) {
			email2.add(new Email("erich@gmail.com"));
		}
		empresaCompleto.setEmail(email2);
	}
	 
	//////////////////////////////////////////////////// TESTE LISTA ENDERECO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_lista_de_enderecos_com_tamanho_3() {
		enderecos2.add(new Endereco(1, "04117010"));
		enderecos2.add(new Endereco(2, "02728000"));
		enderecos2.add(new Endereco(3, "05208060"));
		
		empresaCompleto.setEnderecos(enderecos);
		assertNotNull(empresaCompleto.getEnderecos());
		assertEquals(3, empresaCompleto.getEnderecos().size());
	}
	
	@Test
	public void deve_aceitar_lista_de_enderecos_com_tamanho_5() {
		for (int i = 0; i < 5; i++) {
			enderecos2.add(new Endereco(1, "04117010"));
		}
		empresaCompleto.setEnderecos(enderecos2);
		
		assertNotNull(empresaCompleto.getEnderecos());
		assertEquals(5, empresaCompleto.getEnderecos().size());
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_lista_de_enderecos_nulo() {
		empresaCompleto.setEnderecos(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_enderecos_com_tamanho_menor_que_2() {
		enderecos2.add(new Endereco(3, "05208060"));
		empresaCompleto.setEnderecos(enderecos2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_enderecos_com_tamanho_maior_que_5() {
		for (int i = 0; i <= 5; i++) {
			enderecos2.add(new Endereco(1, "04117010"));
		}
		empresaCompleto.setEnderecos(enderecos2);
	}
	
	//////////////////////////////////////////////// TESTE LISTA FUNCIONARIO ////////////////////////////////////////////////
	@Test
	public void deve_aceitar_lista_de_funcionarios_com_tamanho_4() {
		funcionarios2.add(new Funcionario("17255071023", "João"));
		funcionarios2.add(new Funcionario("17255071023", "João"));
		funcionarios2.add(new Funcionario("17255071023", "João"));
		funcionarios2.add(new Funcionario("17255071023", "João"));
		
		empresaCompleto.setFuncionarios(funcionarios2);
		assertNotNull(empresaCompleto.getFuncionarios());
		assertEquals(4, empresaCompleto.getFuncionarios().size());
	}
	
	@Test
	public void deve_aceitar_lista_de_funcionarios_com_tamanho_50() {
		for (int i = 0; i < 50; i++) {
			funcionarios2.add(new Funcionario("17255071023", "João"));
		}
		empresaCompleto.setFuncionarios(funcionarios2);
		
		assertNotNull(empresaCompleto.getFuncionarios());
		assertEquals(50, empresaCompleto.getFuncionarios().size());
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_lista_de_funcionarios_nulo() {
		empresaCompleto.setFuncionarios(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_funcionarios_com_tamanho_menor_que_4() {
		funcionarios2.add(new Funcionario("17255071023", "João"));
		funcionarios2.add(new Funcionario("17255071023", "João"));
		funcionarios2.add(new Funcionario("17255071023", "João"));
		
		empresaCompleto.setFuncionarios(funcionarios2);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_lista_de_funcionarios_com_tamanho_maior_que_50() {
		for (int i = 0; i <= 50; i++) {
			funcionarios2.add(new Funcionario("17255071023", "João"));
		}
		empresaCompleto.setFuncionarios(funcionarios2);
	} 
	
	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_cod_razao_social_nome_fantasia_cnpj_telefone_email_endereco_funcionario_no_tostring() {
		empresa = new Empresa(RAZAO_SOCIAL, NOME_FANTASIA, CNPJ_EMPRESA_2, telefone, email, enderecos, funcionarios); 
		System.out.println(empresa);
		assertEquals(RESULTADO_ESPERADO, empresa.toString());
	}
	
	@Test
	public void nao_deve_retornar_cod_razao_social_nome_fantasia_cnpj_telefone_email_endereco_funcionario_no_tostring() {
		empresa = new Empresa(RAZAO_SOCIAL_2, NOME_FANTASIA_2, CNPJ_EMPRESA_2, telefone, email, enderecos, funcionarios);
		assertNotEquals(RESULTADO_ESPERADO, empresa.toString());
	}
	
	////////////////////////////////////////////////////TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
	    assertEquals(empresaCompleto.hashCode(), empresaCompleto.hashCode());
	}

	@Test
	public void nao_devem_ter_hashcode_iguais() {
	    assertNotEquals(empresaCompleto.hashCode(), empresaCompleto2.hashCode());
	}

	//////////////////////////////////////////////////// TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		empresaCompleto.setCnpj("29179111000199");
		empresaCompleto2.setCnpj("29179111000199");
		assertTrue(empresaCompleto.equals(empresaCompleto2) && empresaCompleto2.equals(empresaCompleto));
	}
	
	@Test
	public void equals_deve_retornar_false() {
		empresaCompleto.setCnpj("29179111000199");
		empresaCompleto2.setCnpj("83699173000177");
		assertFalse(empresaCompleto.equals(empresaCompleto2) && empresaCompleto2.equals(empresaCompleto));
	}
	
	@Test
	public void equals_deve_retornar_false_codigo_diferente() {
		empresaCompleto.setCnpj("29179111000199");
		empresaCompleto2.setCnpj("83699173000177");
		assertFalse(empresaCompleto.equals(empresaCompleto2) && empresaCompleto2.equals(empresaCompleto));
	}

	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		empresaCompleto.setCnpj("83699173000177");
		assertTrue(empresaCompleto.equals(empresaCompleto));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		empresaCompleto.setCnpj("29179111000199");
		assertFalse(empresaCompleto.equals(null));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		empresaCompleto.setCnpj("29179111000199");
		assertFalse(empresaCompleto.equals(new Object()));
	}
	
	//////////////////////////////////////////////////// TESTE AUDITORIA ////////////////////////////////////////////////////
	////////////////////////////////////////////////// TESTE NOME CRIACAO ///////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome_criacao() {
		empresaCompleto.setNomeUsuarioCriacao("Marcelo");
	assertThat(empresaCompleto.getNomeUsuarioCriacao(), is("Marcelo"));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_nome_criacao_nulo() { 
		empresaCompleto.setNomeUsuarioCriacao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_nome_criacao_vazio() {
		empresaCompleto.setNomeUsuarioCriacao("");
	}
	
	////////////////////////////////////////////////// TESTE DATA CRIACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_criacao() {
		LocalDateTime dataCriacao = LocalDateTime.of(2023, 12, 12, 12, 00);
		empresaCompleto.setDataCriacao(dataCriacao);
		assertEquals(empresaCompleto.getDataCriacao(), dataCriacao);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_data_criacao_nulo() {
		empresaCompleto.setDataCriacao(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_criacao_acima_de_1_ano() {
		LocalDateTime dataCriacao = LocalDateTime.of(2027, 12, 12, 12, 00);
		empresaCompleto.setDataCriacao(dataCriacao);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_criacao_abaixo_de_1_ano() {
		LocalDateTime dataCriacao = LocalDateTime.of(2015, 12, 12, 12, 00);
		empresaCompleto.setDataCriacao(dataCriacao);
	}
	
	////////////////////////////////////////////////// TESTE IP CRIACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ip_criacao() {
		empresaCompleto.setIpCriacao("1.1.1.1");
		assertThat(empresaCompleto.getIpCriacao(), is("1.1.1.1"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ip_criacao_nulo() { 
		empresaCompleto.setIpCriacao(null);
	}
	
	////////////////////////////////////////////////// TESTE NOME ALTERACAO ///////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome_alteracao() {
		empresaCompleto.setNomeUsuarioAlteracao("Marcelo");
		assertThat(empresaCompleto.getNomeUsuarioAlteracao(), is("Marcelo"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_nome_alteracao_nulo() {
		empresaCompleto.setNomeUsuarioAlteracao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_nome_alteracao_vazio() {
		empresaCompleto.setNomeUsuarioAlteracao("");
	}
	
	////////////////////////////////////////////////// TESTE DATA ALTERACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_alteracao() {
		empresaCompleto.setDataCriacao(DATA_CRIACAO);
		empresaCompleto.setDataAlteracao(DATA_ALTERACAO_HOJE);
	}

	// TODO ver se esse teste deve existir, conforme a validacao de pre requisito que fizemos
//	@Test(expected = IllegalArgumentException.class)
//	public void nao_deve_aceitar_data_alteracao_nulo() {
//		empresaCompleto.setDataAlteracao(null);
//	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_alteracao_com_data_criacao_nula() {
		LocalDateTime dataAlteracao = LocalDateTime.now();
		empresaCompleto.setDataAlteracao(dataAlteracao);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_alteracao_anterior_a_data_criacao() {
		LocalDateTime dataCriacao = LocalDateTime.now();
		LocalDateTime dataAlteracao = LocalDateTime.of(2020, 04, 18, 12, 00);
		empresaCompleto.setDataCriacao(dataCriacao);
		empresaCompleto.setDataAlteracao(dataAlteracao);
	}
	
	////////////////////////////////////////////////// TESTE IP ALTERACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ip_alteracao() {
		empresaCompleto.setIpCriacao("0.0.0.0");
		assertThat(empresaCompleto.getIpCriacao(), is("0.0.0.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ip_alteracao_nulo() {
		empresaCompleto.setIpCriacao(null);
	}
	
}
