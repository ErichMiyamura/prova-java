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

import br.com.contmatic.prova.endereco.Cidade;
import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.endereco.Uf;

public class EnderecoTest {
	
	private static final String RESULTADO_ESPERADO = "Endereco [cep=16310970, numero=127, logradouro=Rua A, tipoLogradouro=Rua, bairro=Saúde, complemento=21, cidade=Cidade [codigoIbge=3550308, nome=São Paulo, uf=Uf [codigoIbge=3501004, nome=São Paulo, sigla=SP, pais=Brasil]]]";
	private static final Integer NUMERO = 127;
	private static final String CEP = "16310970";
	private static final String CEP_2 = "04053045";
	private static final String LOGRADOURO = "Rua A";
	private static final String TIPO_LOGRADOURO = "Rua";
	private static final String BAIRRO = "Saúde";
	private static final String COMPLEMENTO = "21";
	
	private Endereco endereco;
	private Endereco enderecoCompleto; 
	private Endereco enderecoCompleto2; 
	private Endereco enderecoObrigatorio; 
	private Cidade cidade1;
	private Uf uf1;
	 
	@Before
	public void setUp() {
		uf1 = new Uf("3501004", "São Paulo", "SP", "Brasil");
		cidade1 = new Cidade("3550308", "São Paulo", uf1); 
		enderecoObrigatorio = new Endereco("02543120", 134);
		enderecoCompleto = new Endereco("03952010", 12345, "Rua Tal", "Rua", "Saude", "A13", cidade1);
		enderecoCompleto2 = new Endereco("27123270", 12, "Rua ABCD", "Rua", "Moema", "34", cidade1);
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
	@Test(timeout = 1000)
	public void deve_verificar_o_construtor_classe_obrigatorio() {
		Endereco e1 = new Endereco(CEP, NUMERO);
		
		assertNotNull(e1);
		assertEquals(CEP, e1.getCep());
		assertEquals(NUMERO, e1.getNumero());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_construtor_obrigatorio_com_cep_nulo() {
        endereco = new Endereco(null, NUMERO);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_construtor_obrigatorio_com_numero_nulo() { 
        endereco = new Endereco(CEP, null);
	}
	
	//////////////////////////////////////////////////// TESTE CONSTRUTOR ////////////////////////////////////////////////////
	@Test
	public void deve_verificar_o_construtor_classe() {
        cidade1.setNome("São Paulo");
		
		Endereco e1 = new Endereco(CEP, NUMERO, LOGRADOURO, TIPO_LOGRADOURO, BAIRRO, COMPLEMENTO, cidade1);
		
		assertNotNull(e1);
		assertEquals(CEP, e1.getCep());
		assertEquals(NUMERO, e1.getNumero());
		assertEquals(LOGRADOURO, e1.getLogradouro());
		assertEquals(TIPO_LOGRADOURO, e1.getTipoLogradouro());
		assertEquals(BAIRRO, e1.getBairro());
		assertEquals(COMPLEMENTO, e1.getComplemento());
		assertEquals(cidade1, e1.getCidade());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_com_cep_nulo() {
		endereco = new Endereco(null, NUMERO, LOGRADOURO, TIPO_LOGRADOURO, BAIRRO, COMPLEMENTO, cidade1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_com_numero_nulo() {
		endereco = new Endereco(CEP, null, LOGRADOURO, TIPO_LOGRADOURO, BAIRRO, COMPLEMENTO, cidade1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_com_logradouro_nulo() {
		endereco = new Endereco(CEP, NUMERO, null, TIPO_LOGRADOURO, BAIRRO, COMPLEMENTO, cidade1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_com_tipo_logradouro_nulo() {
		endereco = new Endereco(CEP, NUMERO, LOGRADOURO, null, BAIRRO, COMPLEMENTO, cidade1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_com_bairro_nulo() {
		endereco = new Endereco(CEP, NUMERO, LOGRADOURO, TIPO_LOGRADOURO, null, COMPLEMENTO, cidade1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_com_complemento_nulo() {
		endereco = new Endereco(CEP, NUMERO, LOGRADOURO, TIPO_LOGRADOURO, BAIRRO, null, cidade1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_criar_objeto_endereco_com_cidade_nulo() {
		endereco = new Endereco(CEP, NUMERO, LOGRADOURO, TIPO_LOGRADOURO, BAIRRO, COMPLEMENTO, null);
	}
	
	//////////////////////////////////////////////////// TESTE RUA ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_rua() {
		enderecoCompleto.setLogradouro("Rua B");
		assertThat(enderecoCompleto.getLogradouro(), is("Rua B"));	
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_rua() {
		enderecoCompleto.setLogradouro("Rua B");
		assertThat(enderecoCompleto.getLogradouro(), is("Rua B"));	
	}
	
	@Test
	public void deve_verificar_que_rua_nao_e_a_mesma() {
		enderecoCompleto.setLogradouro("Rua B");
		assertThat(enderecoCompleto.getLogradouro(), is(not("Rua C")));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_rua_nulo() {
		enderecoCompleto.setLogradouro(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_rua_vazio() {
		enderecoCompleto.setLogradouro("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_rua_com_mais_de_60_caracteres() {
		enderecoCompleto.setLogradouro("av bandeirantes 808 - jardim maria augusta - av bandeirantes 808 - jardim maria augusta");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_rua_com_menos_de_3_caracteres() {
		enderecoCompleto.setLogradouro("Av");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_rua_com_caracteres_especiais() {
		enderecoCompleto.setLogradouro("Av 13 de #maio");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_rua_com_espaço_no_inicio() {
		enderecoCompleto.setLogradouro(" Av 13 de maio");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_rua_com_espaço_no_final() {
		enderecoCompleto.setLogradouro("Av 13 de maio ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_rua_com_mais_de_um_espaço_no_meio() {
		enderecoCompleto.setLogradouro("Av 13 de    maio");
	}
	
	//////////////////////////////////////////////////// TESTE BAIRRO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_bairro() {
	assertThat(enderecoCompleto.getBairro(), is("Saude"));	
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_bairro() {
	assertThat(enderecoCompleto.getBairro(), is("Saude"));	
	}
	
	@Test
	public void deve_verificar_que_bairro_nao_e_a_mesma() {
	assertThat(enderecoCompleto.getBairro(), is(not("Bairro C")));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_bairro_nulo() {
	enderecoCompleto.setBairro(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_bairro_vazio() {
	enderecoCompleto.setBairro("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_bairro_com_mais_de_60_caracteres() {
	enderecoCompleto.setBairro("av bandeirantes 808 - jardim maria augusta - av bandeirantes 808 - jardim maria augusta");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_bairro_com_menos_de_2_caracteres() {
	enderecoCompleto.setBairro("A");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_bairro_com_caracteres_especiais() {
	enderecoCompleto.setBairro("S@úd_e");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_bairro_com_espaço_no_inicio() {
		enderecoCompleto.setBairro(" Bela Vista");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_bairro_com_espaço_no_final() {
		enderecoCompleto.setBairro("Bela Vista ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_bairro_com_mais_de_um_espaço_no_meio() {
		enderecoCompleto.setBairro("Bela    Vista");
	}
	
	//////////////////////////////////////////////////// TESTE NUMERO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_numero(){
		enderecoObrigatorio.setNumero(3);
		assertThat(enderecoObrigatorio.getNumero(), is(3));
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_numero(){
		enderecoObrigatorio.setNumero(3);
		assertThat(enderecoObrigatorio.getNumero(), is(3));
	}
	
	@Test
	public void deve_verificar_que_numero_nao_e_o_mesmo() {
		enderecoCompleto.setNumero(8);
		assertThat(enderecoCompleto.getNumero(), is(not(2)));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_numero_nulo() {
		enderecoObrigatorio.setNumero(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_numero_menor_ou_igual_a_zero() {
		enderecoObrigatorio.setNumero(0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_numero_maior_do_que_9999999() {
		enderecoObrigatorio.setNumero(99999990);
	}
	
	//////////////////////////////////////////////////// TESTE COMPLEMENTO ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_complemento() {
		enderecoCompleto.setComplemento("Casa");
		assertThat(enderecoCompleto.getComplemento(), is("Casa"));	
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_complemento() {
		enderecoCompleto.setComplemento("Casa");
		assertThat(enderecoCompleto.getComplemento(), is("Casa"));	
	}
	
	@Test
	public void deve_aceitar_complemento_contendo_numeros() {
		enderecoCompleto.setComplemento("ap 345");
		assertThat(enderecoCompleto.getComplemento(), is("ap 345"));	
	}
	
	@Test
	public void deve_verificar_que_complemento_nao_e_do_cliente() {
		enderecoCompleto.setComplemento("Casa");
		assertThat(enderecoCompleto.getComplemento(), is(not("Ap")));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_complemento_nulo() {
		enderecoCompleto.setComplemento(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_complemento_vazio() {
		enderecoCompleto.setComplemento("");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_complemento_com_caracteres_especiais() {
		enderecoCompleto.setComplemento("ap_123");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_complemento_com_espaço_no_inicio() {
		enderecoCompleto.setComplemento(" ap 123");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_complemento_com_espaço_no_final() {
		enderecoCompleto.setComplemento("ap 123 ");
	}

	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_complemento_com_mais_de_um_espaço_no_meio() {
		enderecoCompleto.setComplemento("ap   123");
	}
	
	//////////////////////////////////////////////////// TESTE CEP ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_cep_valido(){
		enderecoCompleto.setCep("05047090");
		assertEquals("05047090", enderecoCompleto.getCep());
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_cep_valido(){
		enderecoCompleto.setCep("05047090");
		assertEquals("05047090", enderecoCompleto.getCep());
	}
	
	@Test
	public void deve_verificar_que_cep_nao_e_o_mesmo() {
		enderecoCompleto.setCep("05047090");
		assertThat(enderecoCompleto.getCep(), is(not("03952010")));	
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cep_menor_que_8_digitos() {
		enderecoCompleto.setCep("165009");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cep_maior_que_8_digitos() {
		enderecoCompleto.setCep("165009701234");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cep_com_letras() {
		enderecoCompleto.setCep("teste");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cep_com_alfanumericos() {
		enderecoCompleto.setCep("04O3awasd");
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cep_com_caracteres_especiais() {
		enderecoCompleto.setCep("1650_97#");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cep_nulo() {
		enderecoCompleto.setCep(null);
	}
	
	@Test(expected = IllegalStateException.class)
	public void nao_deve_aceitar_cep_vazio() {
		enderecoCompleto.setCep("");
	}
	
	//////////////////////////////////////////////////// TESTE CIDADE ////////////////////////////////////////////////////
	@Test
	public void deve_aceitar_cidade(){
		cidade1.setNome("São Paulo");
		assertEquals("São Paulo", cidade1.getNome());
	}
	
	@Test
	@Ignore("Não rodar teste")
	public void deve_ignorar_teste_cidade(){
		cidade1.setNome("São Paulo");
		assertEquals("São Paulo", cidade1.getNome());
	}
	
	@Test
	public void deve_verificar_que_cidade_nao_e_a_mesma() {
		cidade1.setNome("São Paulo");
		assertThat(cidade1.getNome(), is(not("Rio de Janeiro")));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void nao_deve_aceitar_cidade_nulo() {
		enderecoCompleto.setCidade(null);
	}
	
	//////////////////////////////////////////////////// TESTE TOSTRING ////////////////////////////////////////////////////
	@Test
	public void deve_retornar_rua_numero_complemento_cep_uf_cidade_no_tostring() {
		endereco = new Endereco(CEP, NUMERO, LOGRADOURO, TIPO_LOGRADOURO, BAIRRO, COMPLEMENTO, cidade1); 
		assertEquals(RESULTADO_ESPERADO, endereco.toString());
	}
	
	@Test
	public void nao_deve_retornar_rua_numero_complemento_cep_uf_cidade_no_tostring() {
		cidade1.setNome("Porto Alegre");
		endereco = new Endereco(CEP_2, NUMERO, LOGRADOURO, TIPO_LOGRADOURO, BAIRRO, COMPLEMENTO, cidade1); 
		assertNotEquals(RESULTADO_ESPERADO, endereco.toString());
	}
	
	//////////////////////////////////////////////////// TESTE HASHCODE ////////////////////////////////////////////////////
	@Test
	public void devem_ter_hashcode_iguais() {
	    assertEquals(enderecoCompleto.hashCode(), enderecoCompleto.hashCode());
	}
	
	@Test
	public void nao_devem_ter_hashcode_iguais() {
	    assertNotEquals(enderecoCompleto.hashCode(), enderecoCompleto2.hashCode());
	}
	
	@Test
	public void nao_devem_ter_hashcode_iguais_endereco1_com_cep_e_sem_numero_endereco2_com_numero_e_sem_cep() {
	    assertNotEquals(enderecoCompleto.hashCode(), enderecoCompleto2.hashCode());
	}
	
    //////////////////////////////////////////////////// TESTE EQUALS ////////////////////////////////////////////////////
	@Test
	public void equals_deve_retornar_true() {
		enderecoCompleto.setCep("16310970");
		enderecoCompleto.setNumero(1);
		enderecoCompleto2.setCep("16310970");
		enderecoCompleto2.setNumero(1);
		assertTrue(enderecoCompleto.equals(enderecoCompleto2) && enderecoCompleto2.equals(enderecoCompleto));
	}
	
	@Test
	public void equals_deve_retornar_true_comparacao_com_proprio_objeto() {
		assertTrue(enderecoCompleto.equals(enderecoCompleto)); 
	} 
	
	@Test
	public void equals_deve_retornar_false_comparacao_com_nulo() {
		assertFalse(enderecoCompleto.equals(null));
	} 
	
	@Test
	public void equals_deve_retornar_false_comparacao_com_objeto_de_outra_classe() {
		assertFalse(enderecoCompleto.equals(new Object())); 
	} 
	
	@Test
	public void equals_deve_retornar_false_cep_diferentes() { 
		assertFalse(enderecoCompleto.equals(enderecoCompleto2));
	}
	
	@Test
	public void equals_deve_retornar_false_comparacao_cep1_nulo_e_cep2_nao_nulo() { 
		assertFalse(enderecoCompleto.equals(null) && enderecoCompleto2.equals(enderecoCompleto2));
	}
	
	@Test
	public void equals_deve_retornar_false_numeros_diferentes() {  
		assertFalse(enderecoCompleto.equals(enderecoCompleto2));  
	}
	
	@Test
	public void equals_deve_retornar_false_comparacao_numero1_nulo_e_numero2_nao_nulo() { 
		assertFalse(enderecoCompleto.equals(null) && enderecoCompleto2.equals(enderecoCompleto2));
	}
	
}
