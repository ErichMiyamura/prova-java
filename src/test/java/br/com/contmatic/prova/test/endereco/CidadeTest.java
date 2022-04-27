package br.com.contmatic.prova.test.endereco;

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

import br.com.contmatic.prova.endereco.Cidade;
import br.com.contmatic.prova.endereco.Estado;

public class CidadeTest {
	
	private static final String RESULTADO_ESPERADO = "Cidade [nome=São Paulo, codigoIbge=1234567, estado=Estado [nome=São Paulo, sigla=SP, pais=Brasil]]";
	private static final String NOME_CIDADE = "São Paulo";
	private static final String NOME_CIDADE_2 = "Porto Alegre";
	private static final String CODIGO_IBGE = "1234567";
	
	private Cidade cidade;
	private Cidade cidadeCompleto;
	private Estado estado1;

	@Before
	public void setUp() {
		estado1 = new Estado("São Paulo", "SP", "Brasil");
		cidadeCompleto = new Cidade("Porto Alegre", "4314902", estado1);
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
		Cidade c1 = new Cidade(CODIGO_IBGE);

		assertNotNull(c1);
		assertEquals(CODIGO_IBGE, c1.getCodigoIbge());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_cidade_construtor_obrigatorio_com_codigo_ibge_nulo() {
		cidade = new Cidade(null);
	}

	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
		Cidade c1 = new Cidade(NOME_CIDADE, CODIGO_IBGE, estado1);

		assertNotNull(c1);
		assertEquals(NOME_CIDADE, c1.getNome());
		assertEquals(CODIGO_IBGE, c1.getCodigoIbge());
		assertEquals(estado1, c1.getEstado());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_cidade_com_nome_nulo() {
		cidade = new Cidade(null, CODIGO_IBGE, estado1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_cidade_com_codigo_ibge_nulo() {
		cidade = new Cidade(NOME_CIDADE, null, estado1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_cidade_com_estado_nulo() {
		cidade = new Cidade(NOME_CIDADE, CODIGO_IBGE, null);
	}

	//////////////////////////////////////////////////// TESTE NOME ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome() {
		cidadeCompleto.setNome("Porto Alegre");
		assertThat(cidadeCompleto.getNome(), is("Porto Alegre"));
	}

	@Test
	public void deve_verificar_que_nome_nao_sao_iguais() {
		assertThat(cidadeCompleto.getNome(), is(not("São Paulo")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_nulo() {
		cidadeCompleto.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_vazio() {
		cidadeCompleto.setNome("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_contendo_numeros() {
		cidadeCompleto.setNome("Sa0 P4ul0");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_caracteres_especiais() {
		cidadeCompleto.setNome("São_Paulo");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_mais_de_60_caracteres() {
		cidadeCompleto.setNome("SãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPaulo");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_menos_de_3_caracteres() {
		cidadeCompleto.setNome("SP");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_inicio() {
		cidadeCompleto.setNome(" São Paulo");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_final() {
		cidadeCompleto.setNome("São Paulo ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_mais_de_um_espaço_no_meio() {
		cidadeCompleto.setNome("São    Paulo");
	}

	//////////////////////////////////////////////////// TESTE COD IBGE ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_codigo_ibge() {
		cidadeCompleto.setCodigoIbge("1934567");
		assertThat(cidadeCompleto.getCodigoIbge(), is("1934567"));
	}
	
	@Test
	public void deve_verificar_que_codigo_ibge_nao_sao_iguais() {
		assertThat(cidadeCompleto.getCodigoIbge(), is(not("1934567")));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_codigo_ibge_com_menos_de_7_digitos() {
		cidadeCompleto.setCodigoIbge("12345");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_codigo_ibge_com_mais_de_7_digitos() {
		cidadeCompleto.setCodigoIbge("12345123451234512345");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_codigo_ibge_contendo_letras() {
		cidadeCompleto.setCodigoIbge("123teste");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_codigo_ibge_contendo_caracteres_especiais() {
		cidadeCompleto.setCodigoIbge("123_12313");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_codigo_ibge_nulo() {
		cidadeCompleto.setCodigoIbge(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_codigo_ibge_vazio() {
		cidadeCompleto.setCodigoIbge("");
	}

	//////////////////////////////////////////////////// TESTE ESTADO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_estado(){
	assertEquals("São Paulo", estado1.getNome());
	}
	
	@Test
	public void deve_verificar_que_estado_nao_e_o_mesmo() {
	assertThat(estado1.getNome(), is(not("Rio de Janeiro")));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_estado_nulo() {
		cidadeCompleto.setEstado(null);
	}

	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_nome_cod_ibge_uf_no_tostring() {
		cidade = new Cidade(NOME_CIDADE, CODIGO_IBGE, estado1);
		assertEquals(RESULTADO_ESPERADO, cidade.toString());
	}

	@Test
	public void nao_deve_retornar_nome_cod_ibge_uf_no_tostring() {
		cidade = new Cidade(NOME_CIDADE_2, CODIGO_IBGE, estado1);
		assertNotEquals(RESULTADO_ESPERADO, cidade.toString());
	}

	//////////////////////////////////////////////////// TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
		Cidade c1 = new Cidade("3545704");
		Cidade c2 = new Cidade("3545704");
		assertEquals(c1.hashCode(), c2.hashCode());
	} 

	@Test
	public void nao_devem_ter_hashcode_iguais() {
		Cidade c1 = new Cidade("1234587");
		Cidade c2 = new Cidade("9234587");
		assertNotEquals(c1.hashCode(), c2.hashCode());
	}
	
	//////////////////////////////////////////////////// TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		Cidade c1 = new Cidade("1234587");
		Cidade c2 = new Cidade("1234587");
		assertTrue(c1.equals(c2) && c2.equals(c1));
	}

	@Test
	public void equals_deve_retornar_false() {
		Cidade c1 = new Cidade("1234587");
		Cidade c2 = new Cidade("9234587");
		assertFalse(c1.equals(c2) && c2.equals(c1));
	}

	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		Cidade c1 = new Cidade("1234587"); 
		assertTrue(c1.equals(c1));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		Cidade c1 = new Cidade("1234587"); 
		assertFalse(c1.equals(null));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		Cidade c1 = new Cidade("1234587");
		assertFalse(c1.equals(new Object()));
	}
	
} 
