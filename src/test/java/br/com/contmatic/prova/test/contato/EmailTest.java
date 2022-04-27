package br.com.contmatic.prova.test.contato;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.prova.contato.Email;

public class EmailTest {
	
	private static final String RESULTADO_ESPERADO = "Email [enderecoEmail=joaomaria@outlook.com, tipo=Pessoal]";
	private static final String EMAIL = "joaomaria@outlook.com";
	private static final String EMAIL_2 = "cleiton@outlook.com";
	private static final String TIPO_EMAIL = "Pessoal";
	
	private Email email;
	private Email emailCompleto;
	
	@Before
	public void setUp() {
		emailCompleto = new Email("erich@hotmail.com", "Comercial");
	}
 
	@After
	public void tearDown() {
	}

	@BeforeClass
	public static void setUpClass() { 
	}

	@AfterClass
	public static void tearDownClass() {
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR OBRIGATORIO ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe_obrigatorio() {
		Email e1 = new Email(EMAIL);

		assertNotNull(e1);
		assertEquals(EMAIL, e1.getEndereco());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_email_construtor_obrigatorio_com_endereco_email_nulo() {
		email = new Email(null);
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
		Email e1 = new Email(EMAIL, TIPO_EMAIL);

		assertNotNull(e1);
		assertEquals(EMAIL, e1.getEndereco());
		assertEquals(TIPO_EMAIL, e1.getTipo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_email_construtor_com_endereco_email_nulo() {
		email = new Email(null, TIPO_EMAIL);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_email_construtor_com_tipo_email_nulo() {
		email = new Email(EMAIL, null);
	}
	
	//////////////////////////////////////////////////// TESTE EMAIL ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_email() {
		emailCompleto.setEndereco("anamaria_123@gmail.com");
		assertThat(emailCompleto.getEndereco(), is("anamaria_123@gmail.com"));
	}

	@Test
	public void deve_verificar_que_email_nao_sao_iguais() {
		assertThat(emailCompleto.getEndereco(), is(not("gg@outlook.com")));
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_email() {
		emailCompleto.setEndereco("@gmail.123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_email_nulo() {
		emailCompleto.setEndereco(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_email_vazio() {
		emailCompleto.setEndereco("");
	}
	
	//////////////////////////////////////////////////// TESTE TIPO EMAIL ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_tipo_email() {
		assertThat(emailCompleto.getTipo(), is("Comercial"));
	}

	@Test
	public void deve_verificar_que_tipo_email_nao_sao_iguais() {
		emailCompleto.setTipo("Pessoal");
		assertThat(emailCompleto.getTipo(), is(not("Comercial")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_tipo_email_nulo() {
		emailCompleto.setTipo(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_tipo_email_vazio() {
		emailCompleto.setTipo("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_email_contendo_numeros() {
		emailCompleto.setTipo("Comercial123");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_email_com_caracteres_especiais() {
		emailCompleto.setTipo("Comercial@&*");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_email_com_mais_de_60_caracteres() {
		emailCompleto.setTipo("Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_email_com_menos_de_3_caracteres() {
		emailCompleto.setTipo("Pe");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_email_com_espaço_no_inicio() {
		emailCompleto.setTipo(" Pessoal");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_email_com_espaço_no_final() {
		emailCompleto.setTipo("Pessoal ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_email_com_mais_de_um_espaço_no_meio() {
		emailCompleto.setTipo("Pes  soal");
	}
	
	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_email_no_tostring() {
		email = new Email(EMAIL, TIPO_EMAIL);
		assertEquals(RESULTADO_ESPERADO, email.toString());
	}

	@Test
	public void nao_deve_retornar_email_no_tostring() {
		email = new Email(EMAIL_2, TIPO_EMAIL);
		assertNotEquals(RESULTADO_ESPERADO, email.toString());
	}

	//////////////////////////////////////////////////// TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
		Email e1 = new Email("erich@gmail.com");
		Email e2 = new Email("erich@gmail.com");
		assertEquals(e1.hashCode(), e2.hashCode());
	}

	@Test
	public void nao_devem_ter_hashcode_iguais() {
		Email e1 = new Email("erich@gmail.com");
		Email e2 = new Email("maria@gmail.com");
		assertNotEquals(e1.hashCode(), e2.hashCode());
	}
	
	//////////////////////////////////////////////////// TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		Email e1 = new Email("erich@gmail.com");
		Email e2 = new Email("erich@gmail.com");
		assertTrue(e1.equals(e2) && e2.equals(e1));
	}

	@Test
	public void equals_deve_retornar_false() {
		Email e1 = new Email("erich@gmail.com");
		Email e2 = new Email("maria@gmail.com");
		assertFalse(e1.equals(e2) && e2.equals(e1));
	}

	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		Email e1 = new Email("erich@gmail.com");
		assertTrue(e1.equals(e1));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		Email e1 = new Email("erich@gmail.com");
		assertFalse(e1.equals(null));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		Email e1 = new Email("erich@gmail.com");
		assertFalse(e1.equals(new Object()));
	}
	
}
