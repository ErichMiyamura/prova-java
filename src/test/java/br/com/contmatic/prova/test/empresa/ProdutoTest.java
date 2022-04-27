package br.com.contmatic.prova.test.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.prova.empresa.Produto;

public class ProdutoTest {
	
	private static final String RESULTADO_ESPERADO = "Produto [cod=12345678, nome=Computador, valor=1699.99]";
	private static final String COD = "12345678";
	private static final String NOME_PRODUTO = "Computador";
	private static final String NOME_PRODUTO_2 = "Mouse D.";
	private static final BigDecimal VALOR = new BigDecimal("4999.99");
	private static final BigDecimal VALOR_PRODUTO = new BigDecimal("1699.99");
	private static final LocalDateTime DATA_CRIACAO = LocalDateTime.of(2022, 04, 18, 12, 00);
	private static final LocalDateTime DATA_ALTERACAO_HOJE = LocalDateTime.now();
	
	private Produto produto; 
	private Produto produtoCompleto; 
	private Produto produtoCompleto2; 
	private Produto produtoObrigatorio; 
	
	@Before 
	public void setUp() { 
		produtoCompleto = new Produto("35503089", "Teclado", new BigDecimal("200.0"));
		produtoCompleto2 = new Produto("12399999", "Mouse", new BigDecimal("50.0"));
		produtoObrigatorio = new Produto("14775120");
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
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR OBRIGATORIO ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe_obrigatorio() {
		Produto p1 = new Produto(COD);
		
		assertNotNull(p1);
		assertEquals(COD, p1.getCodigo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_produto_construtor_obrigatorio_com_cod_nulo() {
		produto = new Produto(null);
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
		Produto p1 = new Produto(COD, NOME_PRODUTO, VALOR);
		
		assertNotNull(p1);
		assertEquals(COD, p1.getCodigo());
		assertEquals(NOME_PRODUTO, p1.getNome());
		assertEquals(VALOR, p1.getValor());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_produto_com_cod_nulo() {
		produto = new Produto(null, NOME_PRODUTO, VALOR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_produto_com_nome_nulo() {
		produto = new Produto(COD, null, VALOR);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_produto_com_valor_nulo() {
		produto = new Produto(COD, NOME_PRODUTO, null);
	}
	
	//////////////////////////////////////////////////// TESTE CODIGO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_cod_com_tamanho_min_8_digitos() {
		produtoObrigatorio.setCodigo("12345678");
	}
	
	@Test
	public void deve_aceitar_cod_com_tamanho_max_14_digitos() {
		produtoObrigatorio.setCodigo("12345678901234");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cod_com_menos_de_8_digitos() {
		produtoObrigatorio.setCodigo("12345");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cod_com_mais_de_14_digitos() {
		produtoObrigatorio.setCodigo("12345123451234512345");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_letras() {
		produtoObrigatorio.setCodigo("123teste");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_caracteres_especiais() {
		produtoObrigatorio.setCodigo("123_12313");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_cod_nulo() {
		produtoObrigatorio.setCodigo(null);
	}
	
	//////////////////////////////////////////////////// TESTE NOME ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome() {
		produtoCompleto.setNome("Sistema Loja");
		assertThat(produtoCompleto.getNome(), is("Sistema Loja"));
	}

	@Test
	public void deve_verificar_que_nome_nao_sao_iguais() {
		assertThat(produtoCompleto.getNome(), is(not("Gestão")));
	}
	
	@Test
	public void deve_aceitar_nome_que_contem_ponto() {
		produtoCompleto.setNome(NOME_PRODUTO_2);
		assertThat(produtoCompleto.getNome(), is(NOME_PRODUTO_2));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_nome_nulo() {
		produtoCompleto.setNome(null);
	}
	
	@Test(expected = IllegalStateException.class) 
	public void nao_deve_aceitar_nome_vazio() {
		produtoCompleto.setNome("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_dever_aceitar_nome_com_mais_de_60_caracteres() {
		produtoCompleto.setNome("Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja Loja ");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_dever_aceitar_nome_com_menos_de_3_caracteres() {
		produtoCompleto.setNome("Lo");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_inicio() {
		produtoCompleto.setNome(" Loja");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_espaço_no_final() {
		produtoCompleto.setNome("Loja ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_nome_com_mais_de_um_espaço_no_meio() {
		produtoCompleto.setNome("Lo   ja");
	}
	
	//////////////////////////////////////////////////// TESTE VALOR ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_valor() {
		produtoCompleto.setValor(new BigDecimal("3000.0"));
		assertThat(produtoCompleto.getValor(), is(new BigDecimal("3000.0")));
	}

	@Test
	public void deve_verificar_que_valores_nao_sao_iguais() {
		assertThat(produtoCompleto.getValor(), is(not(new BigDecimal("1000.0"))));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_valor_nulo() {
		produtoCompleto.setValor(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_valor_menor_ou_igual_a_zero() {
		produtoCompleto.setValor(new BigDecimal("0.0"));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_valor_menor_do_que_valor_minimo() {
		produtoCompleto.setValor(new BigDecimal("5.0"));
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_valor_maior_do_que_valor_maximo() {
		produtoCompleto.setValor(new BigDecimal("10000000.0"));
	}
	
	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_cod_nome_valor_no_tostring() {
		produto = new Produto(COD, NOME_PRODUTO, VALOR_PRODUTO); 
		System.out.println(produto);
		assertEquals(RESULTADO_ESPERADO, produto.toString());
	}
	
	@Test
	public void nao_deve_retornar_cod_nome_valor_no_tostring() {
		produto = new Produto(COD, NOME_PRODUTO_2, VALOR_PRODUTO); 		
		assertNotEquals(RESULTADO_ESPERADO, produto.toString());
	}
	
	//////////////////////////////////////////////////// TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
		produtoCompleto.setCodigo("12345876");
	    assertEquals(produtoCompleto.hashCode(), produtoCompleto.hashCode());
	}
	
	@Test
	public void nao_devem_ter_hashcode_iguais() {
		produtoCompleto.setCodigo("12345876");
		produtoCompleto2.setCodigo("92345876");
		
	    assertNotEquals(produtoCompleto.hashCode(), produtoCompleto2.hashCode());
	}
	
	////////////////////////////////////////////////////TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		produtoCompleto.setCodigo("12345876");
		produtoCompleto2.setCodigo("12345876");
		
		assertTrue(produtoCompleto.equals(produtoCompleto2) && produtoCompleto2.equals(produtoCompleto));
	}
	
	@Test
	public void equals_deve_retornar_false_codigo_diferente() {
		produtoCompleto.setCodigo("12345876");
		produtoCompleto2.setCodigo("92345876");
		
		assertFalse(produtoCompleto.equals(produtoCompleto2) && produtoCompleto2.equals(produtoCompleto));
	} 
	
	@Test 
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		produtoCompleto.setCodigo("12345876");
		assertTrue(produtoCompleto.equals(produtoCompleto));
	} 
	
	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		produtoCompleto.setCodigo("12345876");
		assertFalse(produtoCompleto.equals(null));
	} 
	
	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		produtoCompleto.setCodigo("12345876");
		assertFalse(produtoCompleto.equals(new Object())); 
	} 
	
	//////////////////////////////////////////////////// TESTE AUDITORIA ////////////////////////////////////////////////////
	////////////////////////////////////////////////// TESTE NOME CRIACAO ///////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome_criacao() {
		produtoCompleto.setNomeUsuarioCriacao("Marcelo");
		assertThat(produtoCompleto.getNomeUsuarioCriacao(), is("Marcelo"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_nome_criacao_nulo() {
		produtoCompleto.setNomeUsuarioCriacao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_nome_criacao_vazio() {
		produtoCompleto.setNomeUsuarioCriacao("");
	}

	////////////////////////////////////////////////// TESTE DATA CRIACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_criacao() {
		LocalDateTime dataCriacao = LocalDateTime.of(2023, 12, 12, 12, 00);
		produtoCompleto.setDataCriacao(dataCriacao);
		assertEquals(produtoCompleto.getDataCriacao(), dataCriacao);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_data_criacao_nulo() {
		produtoCompleto.setDataCriacao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_criacao_acima_de_1_ano() {
		LocalDateTime dataCriacao = LocalDateTime.of(2027, 12, 12, 12, 00);
		produtoCompleto.setDataCriacao(dataCriacao);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_criacao_abaixo_de_1_ano() {
		LocalDateTime dataCriacao = LocalDateTime.of(2015, 12, 12, 12, 00);
		produtoCompleto.setDataCriacao(dataCriacao);
	}

	////////////////////////////////////////////////// TESTE IP CRIACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ip_criacao() {
		produtoCompleto.setIpCriacao("1.1.1.1");
		assertThat(produtoCompleto.getIpCriacao(), is("1.1.1.1"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ip_criacao_nulo() {
		produtoCompleto.setIpCriacao(null);
	}

	////////////////////////////////////////////////// TESTE NOME ALTERACAO ///////////////////////////////////////////////////
	@Test
	public void deve_aceitar_nome_alteracao() {
		produtoCompleto.setNomeUsuarioAlteracao("Marcelo");
		assertThat(produtoCompleto.getNomeUsuarioAlteracao(), is("Marcelo"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_ter_nome_alteracao_nulo() {
		produtoCompleto.setNomeUsuarioAlteracao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_ter_nome_alteracao_vazio() {
		produtoCompleto.setNomeUsuarioAlteracao("");
	}

	////////////////////////////////////////////////// TESTE DATA ALTERACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_data_alteracao() {
		produtoCompleto.setDataCriacao(DATA_CRIACAO);
		produtoCompleto.setDataAlteracao(DATA_ALTERACAO_HOJE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_data_alteracao_nulo() {
		produtoCompleto.setDataAlteracao(null);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_alteracao_com_data_criacao_nula() {
		LocalDateTime dataAlteracao = LocalDateTime.now();
		produtoCompleto.setDataAlteracao(dataAlteracao);
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_data_alteracao_anterior_a_data_criacao() {
		LocalDateTime dataCriacao = LocalDateTime.now();
		LocalDateTime dataAlteracao = LocalDateTime.of(2020, 04, 18, 12, 00);
		produtoCompleto.setDataCriacao(dataCriacao);
		produtoCompleto.setDataAlteracao(dataAlteracao);
	}

	////////////////////////////////////////////////// TESTE IP ALTERACAO //////////////////////////////////////////////////
	@Test
	public void deve_aceitar_ip_alteracao() {
		produtoCompleto.setIpCriacao("0.0.0.0");
		assertThat(produtoCompleto.getIpCriacao(), is("0.0.0.0"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_ip_alteracao_nulo() {
		produtoCompleto.setIpCriacao(null);
	}

}
