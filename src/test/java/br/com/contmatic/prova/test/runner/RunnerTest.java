package br.com.contmatic.prova.test.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.prova.test.contato.EmailTest;
import br.com.contmatic.prova.test.contato.TelefoneTest;
import br.com.contmatic.prova.test.empresa.EmpresaTest;
import br.com.contmatic.prova.test.empresa.FuncionarioTest;
import br.com.contmatic.prova.test.empresa.ProdutoTest;
import br.com.contmatic.prova.test.endereco.CidadeTest;
import br.com.contmatic.prova.test.endereco.EnderecoTest;
import br.com.contmatic.prova.test.endereco.UfTest;

@RunWith(Suite.class)
@SuiteClasses(
		{EmpresaTest.class, 
		EnderecoTest.class, 
		FuncionarioTest.class, 
		ProdutoTest.class, 
		CidadeTest.class, 
		UfTest.class, 
		EmailTest.class, 
		TelefoneTest.class})
public final class RunnerTest { 
	
	private RunnerTest() {
	}
 
}
