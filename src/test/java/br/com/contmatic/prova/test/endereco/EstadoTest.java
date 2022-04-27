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

import br.com.contmatic.prova.endereco.Estado;

public class EstadoTest {
	
	private static final String RESULTADO_ESPERADO = "Estado [nome=São Paulo, sigla=SP, pais=Brasil]";
	private static final String NOME_ESTADO = "São Paulo";
	private static final String NOME_ESTADO_2 = "Rio de Janeiro";
	private static final String SIGLA_ESTADO = "SP";
	private static final String PAIS = "Brasil";
	
	private Estado estado;
	private Estado estadoCompleto;
	private Estado estadoCompleto2;

	@Before 
	public void setUp() { 
		estadoCompleto = new Estado("São Paulo", "SP", "Brasil");
		estadoCompleto2 = new Estado("Flórida", "FL", "Estados Unidos");
	}
	
	@After 
	public void tearDown() {
		System.out.println("After");
	}
	
	@BeforeClass 
	public static void setUpClass() { 
		System.out.println("Before Class");
	}
	
	@AfterClass 
	public static void tearDownClass() {
		System.out.println("After Class");
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
		Estado e1 = new Estado(NOME_ESTADO, SIGLA_ESTADO, PAIS);
		
		assertNotNull(e1);
		assertEquals(NOME_ESTADO, e1.getNome());
		assertEquals(SIGLA_ESTADO, e1.getSigla());
		assertEquals(PAIS, e1.getPais());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_estado_com_nome_nulo() {
		estado = new Estado(null, SIGLA_ESTADO, PAIS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_estado_com_sigla_nulo() {
		estado = new Estado(NOME_ESTADO, null, PAIS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_estado_com_pais_nulo() {
		estado = new Estado(NOME_ESTADO, SIGLA_ESTADO, null);
	}
	
	////////////////////////////////////////////////////TESTE NOME ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome() {
		assertThat(estadoCompleto.getNome(), is("São Paulo"));
	}

	@Test
	public void deve_verificar_que_nome_nao_sao_iguais() {
		assertThat(estadoCompleto.getNome(), is(not("Rio de Janeiro")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_nulo() {
		estadoCompleto.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_vazio() {
		estadoCompleto.setNome("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_contendo_numeros() {
		estadoCompleto.setNome("Sa0 P4ul0");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_caracteres_especiais() {
		estadoCompleto.setNome("São_Paulo");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_dever_aceitar_nome_com_mais_de_60_caracteres() {
		estadoCompleto.setNome("SãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPaulo");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_dever_aceitar_nome_com_menos_de_3_caracteres() {
		estadoCompleto.setNome("SP");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_inicio() {
		estadoCompleto.setNome(" São Paulo");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_final() {
		estadoCompleto.setNome("São Paulo ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_mais_de_um_espaço_no_meio() {
		estadoCompleto.setNome("São   Paulo");
	}
	
	//////////////////////////////////////////////////// TESTE SIGLA ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_sigla() {
		assertThat(estadoCompleto.getSigla(), is("SP"));
	}

	@Test
	public void deve_verificar_que_sigla_nao_sao_iguais() {
		assertThat(estadoCompleto.getSigla(), is(not("ES")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_sigla_nulo() {
		estadoCompleto.setSigla(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_vazio() {
		estadoCompleto.setSigla("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_numero() {
		estadoCompleto.setSigla("M1");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_caracteres_especiais() {
		estadoCompleto.setSigla("M_G");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_tamanho_menor_que_2() {
		estadoCompleto.setSigla("M");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_tamanho_maior_que_2() {
		estadoCompleto.setSigla("MGG");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_espaço_no_inicio() {
		estadoCompleto.setSigla(" MG");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_espaço_no_final() {
		estadoCompleto.setSigla("MG ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_mais_de_um_espaço_no_meio() {
		estadoCompleto.setSigla("M  G");
	}
	
	//////////////////////////////////////////////////// TESTE PAIS ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_pais() {
		assertThat(estadoCompleto.getPais(), is("Brasil"));
	}

	@Test
	public void deve_verificar_que_pais_nao_sao_iguais() {
		assertThat(estadoCompleto.getPais(), is(not("Estados Unidos")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_pais_nulo() {
		estadoCompleto.setPais(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_vazio() {
		estadoCompleto.setPais("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_numero() {
		estadoCompleto.setPais("Bras1l");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_caracteres_especiais() {
		estadoCompleto.setPais("Br@si!");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_tamanho_menor_que_3_caracteres() {
		estadoCompleto.setPais("Br");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_tamanho_maior_que_60_caracteres() {
		estadoCompleto.setPais("BrasilBrasilBrasilBrasilBrasilBrasilBrasilBrasilBrasilBrasilBras");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_espaço_no_inicio() {
		estadoCompleto.setSigla(" Brasil");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_espaço_no_final() {
		estadoCompleto.setSigla("Brasil ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_mais_de_um_espaço_no_meio() {
		estadoCompleto.setSigla("Bra    sil");
	}
	
	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_nome_cod_ibge_uf_no_tostring() {
		estado = new Estado(NOME_ESTADO, SIGLA_ESTADO, PAIS);
		assertEquals(RESULTADO_ESPERADO, estado.toString());
	}

	@Test
	public void nao_deve_retornar_nome_cod_ibge_uf_no_tostring() {
		estado = new Estado(NOME_ESTADO_2, SIGLA_ESTADO, PAIS);
		assertNotEquals(RESULTADO_ESPERADO, estado.toString());
	}
	
	//////////////////////////////////////////////////// TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
		assertEquals(estadoCompleto.hashCode(), estadoCompleto.hashCode());
	}

	@Test
	public void nao_devem_ter_hashcode_iguais() {
		assertNotEquals(estadoCompleto.hashCode(), estadoCompleto2.hashCode());
	}
	
	//////////////////////////////////////////////////// TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		estadoCompleto2.setNome("São Paulo");
		estadoCompleto2.setPais("Brasil");
		assertTrue(estadoCompleto.equals(estadoCompleto2) && estadoCompleto2.equals(estadoCompleto));
	}

	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		assertTrue(estadoCompleto.equals(estadoCompleto));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		assertFalse(estadoCompleto.equals(null));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		assertFalse(estadoCompleto.equals(new Object()));
	}

	@Test
	public void equals_deve_retornar_false_nome_diferentes() {
		assertFalse(estadoCompleto.equals(estadoCompleto2));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_nome1_nulo_e_nome2_nao_nulo() {
		assertFalse(estadoCompleto.equals(null) && estadoCompleto2.equals(estadoCompleto2));
	}

	@Test
	public void equals_deve_retornar_false_paises_diferentes() {
		assertFalse(estadoCompleto.equals(estadoCompleto2));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_pais1_nulo_e_pais2_nao_nulo() {
		assertFalse(estadoCompleto.equals(null) && estadoCompleto2.equals(estadoCompleto2));
	}
	
}
