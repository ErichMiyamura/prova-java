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
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.contato.Telefone;

public class TelefoneTest {
	
	private static final String RESULTADO_ESPERADO = "Telefone [ddi=+55, ddd=11, numero=922761962, tipo=Celular]";
	private static final String DDI = "+55";
	private static final String DDD = "11";
	private static final String TELEFONE = "922761962";
	private static final String TELEFONE_2 = "955558765";
	private static final String TIPO_TELEFONE = "Celular";
	
	private Telefone telefone;
	private Telefone telefoneCompleto;
	
	@Before
	public void setUp() {
		telefoneCompleto = new Telefone("+55", "11", "22334455", "Comercial");
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
	@Test(timeout = 1000)
	public void deve_verificar_o_construtor_classe_obrigatorio() {
		Telefone t1 = new Telefone(DDI, DDD, TELEFONE);

		assertNotNull(t1);
		assertEquals(DDI, t1.getDdi());
		assertEquals(DDD, t1.getDdd());
		assertEquals(TELEFONE, t1.getNumero());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_telefone_construtor_obrigatorio_com_ddi_nulo() {
		telefone = new Telefone(null, DDD, TELEFONE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_telefone_construtor_obrigatorio_com_ddd_nulo() {
		telefone = new Telefone(DDI, null, TELEFONE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_telefone_construtor_obrigatorio_com_numero_telefone_nulo() {
		telefone = new Telefone(DDI, DDD, null);
	}

	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
		Telefone t1 = new Telefone(DDI, DDD, TELEFONE, TIPO_TELEFONE);

		assertNotNull(t1);
		assertEquals(DDI, t1.getDdi());
		assertEquals(DDD, t1.getDdd());
		assertEquals(TELEFONE, t1.getNumero());
		assertEquals(TIPO_TELEFONE, t1.getTipo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_telefone_construtor_com_ddi_nulo() {
		telefone = new Telefone(null, DDD, TELEFONE, TIPO_TELEFONE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_telefone_construtor_com_ddd_nulo() {
		telefone = new Telefone(DDI, null, TELEFONE, TIPO_TELEFONE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_telefone_construtor_com_numero_telefone_nulo() {
		telefone = new Telefone(DDI, DDD, null, TIPO_TELEFONE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_telefone_construtor_com_tipo_telefone_nulo() {
		telefone = new Telefone(DDI, DDD, TELEFONE, null);
	}
	
	//////////////////////////////////////////////////// TESTE DDI ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ddi() {
		telefoneCompleto.setDdi("+55");
		assertThat(telefoneCompleto.getDdi(), is("+55"));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_ddi() {
		telefoneCompleto.setDdi("+55");
		assertThat(telefoneCompleto.getDdi(), is("+55"));
	}

	@Test
	public void deve_verificar_que_ddi_nao_sao_iguais() {
		assertThat(telefoneCompleto.getDdi(), is(not("+70")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddi_nulo() {
		telefoneCompleto.setDdi(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddi_vazio() {
		telefoneCompleto.setDdi("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddi() {
		telefoneCompleto.setDdi("+2");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddi_com_caracteres() {
		telefoneCompleto.setDdi("+55ab");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddi_com_caracteres_especiais() {
		telefoneCompleto.setDdi("!55@#$");
	}
	
	////////////////////////////////////////////////////TESTE DDD ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ddd() {
		telefoneCompleto.setDdd("11");
		assertThat(telefoneCompleto.getDdd(), is("11"));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_ddd() {
		telefoneCompleto.setDdd("11");
		assertThat(telefoneCompleto.getDdd(), is("11"));
	}

	@Test
	public void deve_verificar_que_ddd_nao_sao_iguais() {
		assertThat(telefoneCompleto.getDdd(), is(not("70")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ddd_nulo() {
		telefoneCompleto.setDdd(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddd_vazio() {
		telefoneCompleto.setDdd("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddd() {
		telefoneCompleto.setDdd("2");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddd_com_caracteres() {
		telefoneCompleto.setDdd("11ab");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_ddd_com_caracteres_especiais() {
		telefoneCompleto.setDdd("!55@#$");
	}
	
	//////////////////////////////////////////////////// TESTE TELEFONE ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_telefone() {
		telefoneCompleto.setNumero("988932333");
		assertThat(telefoneCompleto.getNumero(), is("988932333"));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_telefone() {
		telefoneCompleto.setNumero("988932333");
		assertThat(telefoneCompleto.getNumero(), is("988932333"));
	}

	@Test
	public void deve_verificar_que_telefone_nao_sao_iguais() {
		assertThat(telefoneCompleto.getNumero(), is(not("999999999")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_telefone_nulo() {
		telefoneCompleto.setNumero(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_telefone_vazio() {
		telefoneCompleto.setNumero("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_telefone() {
		telefoneCompleto.setNumero("11988");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_telefone_com_caracteres() {
		telefoneCompleto.setNumero("9889323ab");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_telefone_com_caracteres_especiais() {
		telefoneCompleto.setNumero("9889323!@#");
	}

	//////////////////////////////////////////////////// TESTE TIPO TELEFONE ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_tipo_telefone() {
		assertThat(telefoneCompleto.getTipo(), is("Comercial"));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_tipo_telefone() {
		assertThat(telefoneCompleto.getTipo(), is("Comercial"));
	}

	@Test
	public void deve_verificar_que_tipo_telefone_nao_sao_iguais() {
		telefoneCompleto.setTipo("Pessoal");
		assertThat(telefoneCompleto.getTipo(), is(not("Comercial")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_tipo_telefone_nulo() {
		telefoneCompleto.setTipo(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_tipo_telefone_vazio() {
		telefoneCompleto.setTipo("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_telefone_contendo_numeros() {
		telefoneCompleto.setTipo("Comercial123");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_telefone_com_caracteres_especiais() {
		telefoneCompleto.setTipo("Comercial@&*");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_telefone_com_mais_de_60_caracteres() {
		telefoneCompleto.setTipo("Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal Pessoal");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_telefone_com_menos_de_3_caracteres() {
		telefoneCompleto.setTipo("Pe");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_telefone_com_espaço_no_inicio() {
		telefoneCompleto.setTipo(" Pessoal");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_telefone_com_espaço_no_final() {
		telefoneCompleto.setTipo("Pessoal ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_tipo_telefone_com_mais_de_um_espaço_no_meio() {
		telefoneCompleto.setTipo("Pes  soal");
	}
	 
	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_telefone_no_tostring() {
		telefone = new Telefone(DDI, DDD, TELEFONE, TIPO_TELEFONE);
		assertEquals(RESULTADO_ESPERADO, telefone.toString());
	}

	@Test
	public void nao_deve_retornar_telefone_no_tostring() {
		telefone = new Telefone(DDI, DDD, TELEFONE_2, TIPO_TELEFONE);
		assertNotEquals(RESULTADO_ESPERADO, telefone.toString());
	}

	//////////////////////////////////////////////////// TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
		Telefone t1 = new Telefone("+55", "17", "911113333");
		Telefone t2 = new Telefone("+55", "17", "911113333");
		assertEquals(t1.hashCode(), t2.hashCode());
	}

	@Test
	public void nao_devem_ter_hashcode_iguais() {
		Telefone t1 = new Telefone("+55", "17", "911113333");
		Telefone t2 = new Telefone("+65", "90", "911119999");
		assertNotEquals(t1.hashCode(), t2.hashCode());
	}
	
	////////////////////////////////////////////////////TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		Telefone t1 = new Telefone("+55", "17", "911113333");
		Telefone t2 = new Telefone("+55", "17", "911113333");
		assertTrue(t1.equals(t2) && t2.equals(t1));
	}
	
	@Test
	public void equals_deve_retornar_false_somente_ddi_diferentes() {
		Telefone t1 = new Telefone("+55", "17", "911113333");
		Telefone t2 = new Telefone("+65", "90", "911119999");  
		assertFalse(t1.equals(t2) && t2.equals(t1));
	}

	@Test
	public void equals_deve_retornar_false_somente_dds_diferentes() {
		Telefone t1 = new Telefone("+55", "17", "911113333");
		Telefone t2 = new Telefone("+55", "90", "911119999");  
		assertFalse(t1.equals(t2) && t2.equals(t1));
	}
	
	@Test
	public void equals_deve_retornar_false_somente_numero_diferentes() {
		Telefone t1 = new Telefone("+55", "17", "911113333");
		Telefone t2 = new Telefone("+55", "17", "922229999");  
		assertFalse(t1.equals(t2) && t2.equals(t1));
	}

	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		Telefone t1 = new Telefone("+90", "90", "911119999");
		assertTrue(t1.equals(t1));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		Telefone t1 = new Telefone("+45", "34", "911119999");
		assertFalse(t1.equals(null));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		Telefone t1 = new Telefone("+48", "67", "911119999");
		assertFalse(t1.equals(new Object()));
	}

}
