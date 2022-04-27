package br.com.contmatic.prova.utils.validacao;

import static br.com.contmatic.prova.utils.constantes.ValidacaoCpfConstantes.MENSAGEM_CPF_INVALIDO;
import static br.com.contmatic.prova.utils.constantes.ValidacaoCpfConstantes.MENSAGEM_CPF_NULO;
import static br.com.contmatic.prova.utils.constantes.ValidacaoCpfConstantes.MENSAGEM_CPF_VAZIO;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

public final class ValidacaoCpf {
	
	private static final char CHAR_0 = '0';
	private static final int CONSTANTE_0 = 0;
	private static final int CONSTANTE_1 = 1;
	private static final int POSICAO_9 = 9; 
	private static final int POSICAO_10 = 10;
	private static final int PESO_10 = 10;
	private static final int PESO_11 = 11;
	private static final int RESTO_10 = 10;
	private static final int RESTO_11 = 11;
	private static final int INICIO_SEQUENCIA = 0;
	private static final int LIMITE_SEQUENCIA_PRIMEIRO_DIGITO = 9;
	private static final int LIMITE_SEQUENCIA_SEGUNDO_DIGITO = 10;
	private static final int TAMANHO_MAX_CPF = 11;
	private static final int POSICAO_0_TABELA_ASCII = 48;

	private ValidacaoCpf() {
	} 
	
	public static boolean validarCpf(String cpf) {
		validarNulo(cpf, MENSAGEM_CPF_NULO);
		validarVazio(cpf, MENSAGEM_CPF_VAZIO);
		validarSequenciaTamanho(cpf);
		return validarDigitos(cpf);
	}

	private static boolean validarDigitos(String cpf) { 
		char dig10 = validarPrimeiroDigito(cpf);
		char dig11 = validarSegundoDigito(cpf);

		if (isPrimeiroDigitoVerificadorValido(cpf, dig10) && isSegundoDigitoVerificadorValido(cpf, dig11))
			return true;
		else
			throw new IllegalStateException(MENSAGEM_CPF_INVALIDO);
	}

	private static boolean isSegundoDigitoVerificadorValido(String cpf, char dig11) {
		return dig11 == cpf.charAt(POSICAO_10);
	}

	private static boolean isPrimeiroDigitoVerificadorValido(String cpf, char dig10) {
		return dig10 == cpf.charAt(POSICAO_9);
	}

	private static char validarSegundoDigito(String cpf) {
		int soma = calcularSomatorioSegundoDigito(cpf);

		return calcularDigitoVerificador(soma);
	}

	private static int calcularSomatorioSegundoDigito(String cpf) {
		int soma = CONSTANTE_0;
		int peso = PESO_11;
		for (int i = INICIO_SEQUENCIA; i < LIMITE_SEQUENCIA_SEGUNDO_DIGITO; i++) {
			int numero = (cpf.charAt(i) - POSICAO_0_TABELA_ASCII);
			soma = soma + (numero * peso);
			peso = peso - CONSTANTE_1;
		}
		return soma;
	}

	private static char validarPrimeiroDigito(String cpf) {
		int soma = calcularSomatorioPrimeiroDigito(cpf);

		return calcularDigitoVerificador(soma);
	}

	private static char calcularDigitoVerificador(int soma) {
		int resto = PESO_11 - (soma % PESO_11);
		char digito;
		if ((resto == RESTO_10) || (resto == RESTO_11))
			digito = CHAR_0;
		else
			digito = (char) (resto + POSICAO_0_TABELA_ASCII); 
		return digito;
	}

	private static int calcularSomatorioPrimeiroDigito(String cpf) {
		int soma = CONSTANTE_0;
		int peso = PESO_10;
		for (int i = INICIO_SEQUENCIA; i < LIMITE_SEQUENCIA_PRIMEIRO_DIGITO; i++) { 
			int num = (cpf.charAt(i) - POSICAO_0_TABELA_ASCII);
			soma = soma + (num * peso);
			peso = peso - CONSTANTE_1;
		}
		return soma;
	}

	private static void validarSequenciaTamanho(String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != TAMANHO_MAX_CPF))
			throw new IllegalStateException(MENSAGEM_CPF_INVALIDO);
	}

}
