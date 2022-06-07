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
import org.junit.Ignore;
import org.junit.Test;

import br.com.contmatic.prova.endereco.Uf;

public class UfTest {
	
	private static final String RESULTADO_ESPERADO = "Uf [codigoIbge=3500907, nome=São Paulo, sigla=SP, pais=Brasil]";
	private static final String CODIGO_IBGE = "3500907";
	private static final String NOME_ESTADO = "São Paulo";
	private static final String NOME_ESTADO_2 = "Rio de Janeiro";
	private static final String SIGLA_ESTADO = "SP";
	private static final String PAIS = "Brasil";
	
	private Uf uf;
	private Uf ufCompleto;
	private Uf ufCompleto2;

	@Before 
	public void setUp() { 
		ufCompleto = new Uf("3500907", "São Paulo", "SP", "Brasil");
		ufCompleto2 = new Uf("4108106", "Flórida", "FL", "Estados Unidos");
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
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR OBRIGATORIOS ////////////////////////////////////////////////////
	@Test(timeout = 1000)
	public void deve_verificar_o_construtor_classe_obrigatorio() {
		Uf uf1 = new Uf(CODIGO_IBGE);

		assertNotNull(uf1);
		assertEquals(CODIGO_IBGE, uf1.getCodigoIbge());
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_uf_construtor_obrigatorio_com_codigo_ibge_nulo() {
		uf = new Uf(null);
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
		Uf e1 = new Uf(CODIGO_IBGE, NOME_ESTADO, SIGLA_ESTADO, PAIS);
		
		assertNotNull(e1);
		assertEquals(CODIGO_IBGE, e1.getCodigoIbge());
		assertEquals(NOME_ESTADO, e1.getNome());
		assertEquals(SIGLA_ESTADO, e1.getSigla());
		assertEquals(PAIS, e1.getPais());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_estado_com_codigo_ibge_nulo() {
		uf = new Uf(null, NOME_ESTADO, SIGLA_ESTADO, PAIS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_estado_com_nome_nulo() {
		uf = new Uf(CODIGO_IBGE, null, SIGLA_ESTADO, PAIS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_estado_com_sigla_nulo() {
		uf = new Uf(CODIGO_IBGE, NOME_ESTADO, null, PAIS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_estado_com_pais_nulo() {
		uf = new Uf(CODIGO_IBGE, NOME_ESTADO, SIGLA_ESTADO, null);
	}
	
	////////////////////////////////////////////////////TESTE NOME ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome() {
		assertThat(ufCompleto.getNome(), is("São Paulo"));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_nome() {
		assertThat(ufCompleto.getNome(), is("São Paulo"));
	}

	@Test
	public void deve_verificar_que_nome_nao_sao_iguais() {
		assertThat(ufCompleto.getNome(), is(not("Rio de Janeiro")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_nulo() {
		ufCompleto.setNome(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_vazio() {
		ufCompleto.setNome("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_contendo_numeros() {
		ufCompleto.setNome("Sa0 P4ul0");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_caracteres_especiais() {
		ufCompleto.setNome("São_Paulo");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_dever_aceitar_nome_com_mais_de_60_caracteres() {
		ufCompleto.setNome("SãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPauloSãoPaulo");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_dever_aceitar_nome_com_menos_de_3_caracteres() {
		ufCompleto.setNome("SP");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_inicio() {
		ufCompleto.setNome(" São Paulo");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_final() {
		ufCompleto.setNome("São Paulo ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_mais_de_um_espaço_no_meio() {
		ufCompleto.setNome("São   Paulo");
	}
	
	//////////////////////////////////////////////////// TESTE SIGLA ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_sigla() {
		assertThat(ufCompleto.getSigla(), is("SP"));
	}
	
	@Test
	@Ignore("Não rodar teste")	
	public void deve_ignorar_teste_sigla() {
		assertThat(ufCompleto.getSigla(), is("SP"));
	}

	@Test
	public void deve_verificar_que_sigla_nao_sao_iguais() {
		assertThat(ufCompleto.getSigla(), is(not("ES")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_sigla_nulo() {
		ufCompleto.setSigla(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_vazio() {
		ufCompleto.setSigla("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_numero() {
		ufCompleto.setSigla("M1");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_caracteres_especiais() {
		ufCompleto.setSigla("M_G");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_tamanho_menor_que_2() {
		ufCompleto.setSigla("M");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_tamanho_maior_que_2() {
		ufCompleto.setSigla("MGG");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_espaço_no_inicio() {
		ufCompleto.setSigla(" MG");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_espaço_no_final() {
		ufCompleto.setSigla("MG ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_sigla_com_mais_de_um_espaço_no_meio() {
		ufCompleto.setSigla("M  G");
	}
	
	//////////////////////////////////////////////////// TESTE PAIS ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_pais() {
		assertThat(ufCompleto.getPais(), is("Brasil"));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_pais() {
		assertThat(ufCompleto.getPais(), is("Brasil"));
	}

	@Test
	public void deve_verificar_que_pais_nao_sao_iguais() {
		assertThat(ufCompleto.getPais(), is(not("Estados Unidos")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_pais_nulo() {
		ufCompleto.setPais(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_vazio() {
		ufCompleto.setPais("");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_numero() {
		ufCompleto.setPais("Bras1l");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_caracteres_especiais() {
		ufCompleto.setPais("Br@si!");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_tamanho_menor_que_3_caracteres() {
		ufCompleto.setPais("Br");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_tamanho_maior_que_60_caracteres() {
		ufCompleto.setPais("BrasilBrasilBrasilBrasilBrasilBrasilBrasilBrasilBrasilBrasilBras");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_espaço_no_inicio() {
		ufCompleto.setSigla(" Brasil");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_espaço_no_final() {
		ufCompleto.setSigla("Brasil ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_pais_com_mais_de_um_espaço_no_meio() {
		ufCompleto.setSigla("Bra    sil");
	}
	
	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_nome_cod_ibge_uf_no_tostring() {
		uf = new Uf(CODIGO_IBGE, NOME_ESTADO, SIGLA_ESTADO, PAIS);
		assertEquals(RESULTADO_ESPERADO, uf.toString());
	}

	@Test
	public void nao_deve_retornar_nome_cod_ibge_uf_no_tostring() {
		uf = new Uf(CODIGO_IBGE, NOME_ESTADO_2, SIGLA_ESTADO, PAIS);
		assertNotEquals(RESULTADO_ESPERADO, uf.toString());
	}
	
	//////////////////////////////////////////////////// TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
		assertEquals(ufCompleto.hashCode(), ufCompleto.hashCode());
	}

	@Test
	public void nao_devem_ter_hashcode_iguais() {
		assertNotEquals(ufCompleto.hashCode(), ufCompleto2.hashCode());
	}
	
	//////////////////////////////////////////////////// TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		ufCompleto2.setNome("São Paulo");
		ufCompleto2.setPais("Brasil");
		assertTrue(ufCompleto.equals(ufCompleto2) && ufCompleto2.equals(ufCompleto));
	}

	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		assertTrue(ufCompleto.equals(ufCompleto));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		assertFalse(ufCompleto.equals(null));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		assertFalse(ufCompleto.equals(new Object()));
	}

	@Test
	public void equals_deve_retornar_false_nome_diferentes() {
		assertFalse(ufCompleto.equals(ufCompleto2));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_nome1_nulo_e_nome2_nao_nulo() {
		assertFalse(ufCompleto.equals(null) && ufCompleto2.equals(ufCompleto2));
	}

	@Test
	public void equals_deve_retornar_false_paises_diferentes() {
		assertFalse(ufCompleto.equals(ufCompleto2));
	}

	@Test
	public void equals_deve_retornar_false_comparacao_pais1_nulo_e_pais2_nao_nulo() {
		assertFalse(ufCompleto.equals(null) && ufCompleto2.equals(ufCompleto2));
	}
	
}
