package br.com.contmatic.prova.utils.validacao;

import java.math.BigDecimal;
import java.util.List;

public final class Validacao {

	private Validacao() {
	}
	
//	public static void main(String[] args) {
//        String string1 = "Erich";
//        String string2 = " Erich";
//        String string3 = "Erich ";
//        String string4 = "Erich     Erich";
//        
//        validaEspacosString(string1);
//        validaEspacosString(string2);
//        validaEspacosString(string3);
//        validaEspacosString(string4);
//    }
//    
//    private static String validaEspacosString(String string) {
//        if (string == null) {
//            System.out.println("tá errado!");
//            return "errado";
//        }
//        
//        String string2;
//        string2 = string;
//        if (!string.trim().equals(string2)) {
//            
//            System.out.println("tá errado!");
//            return "errado";
//        }
//        
//        String string3;
//        string3 = string;
//        if (!string.trim().equals(string3)) {
//            
//            System.out.println("tá errado!");
//            return "errado";
//        }
//        
//        String string4;
//        string4 = string.replaceAll("\s+"," ");
//        if (!string.trim().equals(string4)) {
//            
//            System.out.println("tá errado!");
//            return "errado";
//        }
//        
//        System.out.println("tá certo :) !");
//        return string;
//    }
	
	// VALIDAÇÃO NULO //
	public static void validarNulo(Object campo, String mensagem) {
		if (campo == null) {
			throw new IllegalArgumentException(mensagem);
		}
	} 
	
	/**
	 * Metodo de validacao de atributo que seja um pré-requisito para outro atributo
	 * @param campo
	 * @param mensagem
	 */
	public static void validarPreRequisitoNulo(Object campo, String mensagem) {
		if (campo == null) {
			throw new IllegalStateException(mensagem);
		}
	} 

	// VALIDAÇÃO VAZIO //
	public static void validarVazio(String campoStr, String mensagem) {
		if (campoStr.isEmpty()) {
			throw new IllegalStateException(mensagem);
		} 
	}

	// VALIDAÇÃO TAMANHO CARACTERES //
	public static void validarTamanhoString(String campoStr, int tamanhoMinimo, int tamanhoMaximo, String mensagem) {
		if (campoStr.length() < tamanhoMinimo || campoStr.length() > tamanhoMaximo) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	// VALIDAÇÃO TAMANHO TELEFONE //
		public static void validarTamanhoTelefone(String campoStr, int tamanhoMinimo, int tamanhoMaximo, String mensagem) {
			if (campoStr.length() < tamanhoMinimo || campoStr.length() > tamanhoMaximo) {
				throw new IllegalStateException(mensagem);
			}
		}
	
	// VALIDAÇÃO CARACTER //
	public static void validarCaracter(String campoStr, String regex, String mensagem) {
		if (!campoStr.matches(regex)) {
			throw new IllegalStateException(mensagem);
		}
	}

	// VALIDAÇÃO ALFANUMERICO //
	public static void validarAlfanumerico(String campoStr, String regex, String mensagem) {
		if (!campoStr.matches(regex)) {
			throw new IllegalStateException(mensagem);
		} 
	}

	// VALIDAÇÃO REGEX //
	public static void validarRegex(String campoStr, String regex, String mensagemRegex) {
		if (!campoStr.matches(regex)) {
			throw new IllegalStateException(mensagemRegex); 
		}
	}
	
	// VALIDAÇÃO NUMEROS //
	public static void validarTamanhoNumeroInteiro(Integer campo, int tamanhoMinimo, int tamanhoMaximo, String mensagem) {
		if (campo < tamanhoMinimo || campo > tamanhoMaximo) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	public static void validarTamanhoNumeroDecimal(BigDecimal campo, float tamanhoMinimo, float tamanhoMaximo, String mensagem) {
		if (campo.floatValue() < tamanhoMinimo || campo.floatValue() > tamanhoMaximo) {
			throw new IllegalStateException(mensagem);
		}
	}
	 
	// VALIDAÇÃO LISTA //
	public static void validarTamanhoLista(List<?> list, int tamanhoMinimo, int tamanhoMaximo, String mensagem) {
		if (list.size() < tamanhoMinimo || list.size() > tamanhoMaximo) {
			throw new IllegalStateException(mensagem);
		}
	}
}
