package br.com.contmatic.prova.utils.validacao;

import static br.com.contmatic.prova.utils.constantes.ValidacaoCnpjConstantes.MENSAGEM_CNPJ_INVALIDO;
import static br.com.contmatic.prova.utils.constantes.ValidacaoCnpjConstantes.MENSAGEM_CNPJ_NULO;
import static br.com.contmatic.prova.utils.constantes.ValidacaoCnpjConstantes.MENSAGEM_CNPJ_VAZIO;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarNulo;
import static br.com.contmatic.prova.utils.validacao.Validacao.validarVazio;

public final class ValidacaoCnpj {
	
	private static final int CONSTANTE_0 = 0;
	private static final int CONSTANTE_1 = 1;
	private static final int POSICAO_11 = 11;
	private static final int POSICAO_12 = 12;
	private static final int POSICAO_13 = 13;
	private static final int PESO_2 = 2;
	private static final int PESO_10 = 10;
	private static final int RESTO_0 = 0;
	private static final int RESTO_1 = 1;
	private static final int INICIO_DA_SEQUENCIA = 0;
	private static final int LIMITE_SEQUENCIA_PRIMEIRO_DIGITO = 11;
	private static final int LIMITE_SEQUENCIA_SEGUNDO_DIGITO = 12;
	private static final int TAMANHO_MAX_CNPJ = 14;
	private static final int POSICAO_0_TABELA_ASCII = 48;

	private ValidacaoCnpj() {
	} 

	public static boolean validarCnpj(String cnpj) {
		validarNulo(cnpj, MENSAGEM_CNPJ_NULO);
		validarVazio(cnpj, MENSAGEM_CNPJ_VAZIO);
		validarSequenciaTamanho(cnpj);
		return validarDigitos(cnpj); 
	}

	private static boolean validarDigitos(String cnpj) {
		char dig13 = validarPrimeiroDigito(cnpj);
		char dig14 = validarSegundoDigito(cnpj);

		if (isPrimeiroDigitoVerificadorValido(cnpj, dig13) && isSegundoDigitoVerificadorValido(cnpj, dig14))
			return (true);
		else
			throw new IllegalStateException(MENSAGEM_CNPJ_INVALIDO);
	}

	private static boolean isSegundoDigitoVerificadorValido(String cnpj, char dig14) {
		return dig14 == cnpj.charAt(POSICAO_13);
	}

	private static boolean isPrimeiroDigitoVerificadorValido(String cnpj, char dig13) {
		return dig13 == cnpj.charAt(POSICAO_12);
	}

	private static char validarSegundoDigito(String cnpj) {
		int soma = calcularSomatorioSegundoDigito(cnpj); 

		return calcularDigitoVerificador(soma);
	}

	private static int calcularSomatorioSegundoDigito(String cnpj) {
		int soma = CONSTANTE_0;
		int peso = PESO_2;
		for (int i = LIMITE_SEQUENCIA_SEGUNDO_DIGITO; i >= INICIO_DA_SEQUENCIA; i--) {
			int numero = (cnpj.charAt(i) - POSICAO_0_TABELA_ASCII);
			soma = soma + (numero * peso);
			peso = peso + CONSTANTE_1;
			if (peso == PESO_10)
				peso = PESO_2;
		}
		return soma;
	}

	private static char validarPrimeiroDigito(String cnpj) {
		int soma = calcularSomatorioPrimeiroDigito(cnpj);
 
		return calcularDigitoVerificador(soma);
	}

	private static char calcularDigitoVerificador(int soma) {
		int resto = soma % POSICAO_11;
		char dig13;
		if ((resto == RESTO_0) || (resto == RESTO_1))
			dig13 = '0';
		else
			dig13 = (char) ((POSICAO_11 - resto) + POSICAO_0_TABELA_ASCII);
		return dig13;
	}

	private static int calcularSomatorioPrimeiroDigito(String cnpj) {
		int soma = CONSTANTE_0;
		int peso = PESO_2 ;
		for (int i = LIMITE_SEQUENCIA_PRIMEIRO_DIGITO; i >= INICIO_DA_SEQUENCIA; i--) {
			int numero = (cnpj.charAt(i) - POSICAO_0_TABELA_ASCII);
			soma = soma + (numero * peso);
			peso = peso + CONSTANTE_1;
			if (peso == PESO_10)
				peso = PESO_2;
		}
		return soma;
	}

	private static void validarSequenciaTamanho(String cnpj) {
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999") || (cnpj.length() != TAMANHO_MAX_CNPJ))
			throw new IllegalStateException(MENSAGEM_CNPJ_INVALIDO);
	}

}
