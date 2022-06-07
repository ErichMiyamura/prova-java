package br.com.contmatic.prova.utils.validacao;

import static java.time.LocalDate.now;
import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public final class ValidacaoData {
	
	private ValidacaoData() {
	}
	
	// VALIDAÇÃO DATAS//
	public static void validarDataFutura(LocalDate data, int intervaloMaxAnos, String mensagem) {
		final LocalDate hoje = now();
		int anoMaximo = hoje.getYear() + intervaloMaxAnos;
		if (data.getYear() > anoMaximo) {
			throw new IllegalStateException(mensagem); 
		} 
	}
	
	public static void validarDataFutura(LocalDateTime data, int intervaloMaxAnos, String mensagem) {
		final LocalDateTime agora = LocalDateTime.now();
		long anos = ChronoUnit.YEARS.between(agora, data);
		if (anos > intervaloMaxAnos) {
			throw new IllegalStateException(mensagem); 
		}
	}
	
	public static void validarDataAntiga(LocalDate data, int intervaloMaxAnos, String mensagem) {
		final LocalDate hoje = now();
		int anoMinimo = hoje.getYear() - intervaloMaxAnos;
		if (data.getYear() < anoMinimo) {
			throw new IllegalStateException(mensagem); 
		} 
	}
	
	public static void validarDataAntiga(LocalDateTime data, int intervaloMaxAnos, String mensagem) {
		final LocalDateTime agora = LocalDateTime.now();
		long anos = YEARS.between(data, agora);
		if (anos > intervaloMaxAnos) {
			throw new IllegalStateException(mensagem); 
		}
	}
	
	public static void validarDataAtual(LocalDate data, String mensagem) {
		final LocalDate dataHoje = now();
		if (data.getYear() > dataHoje.getYear() || data.getMonthValue() > dataHoje.getMonthValue() || (data.getDayOfMonth() > dataHoje.getDayOfMonth())) {
			throw new IllegalStateException(mensagem); 
		}
	}
		
	// VALIDAÇÃO DATA NASCIMENTO//
	public static void validarMaior16Anos(LocalDate dataNascimento, String mensagem) {
		if (!isMaior16Anos(dataNascimento)) {
			throw new IllegalStateException(mensagem);
		}
	}
	
	private static boolean isMaior16Anos(LocalDate dataNascimento) {
		final LocalDate hoje = now();
		int diferencaAnos = hoje.getYear() - dataNascimento.getYear();

		boolean maior16AnosCompletos = diferencaAnos > 16
				|| (diferencaAnos == 16 && dataNascimento.getMonthValue() < hoje.getMonthValue());
		boolean fez16AnosEsteMes = diferencaAnos == 16 && dataNascimento.getMonthValue() == hoje.getMonthValue()
				&& dataNascimento.getDayOfMonth() <= hoje.getDayOfMonth();

		return maior16AnosCompletos || fez16AnosEsteMes; 
	}
	
	// VALIDAÇÃO DATA DE ADMISSAO//
	public static void validarMesFuturo(LocalDate mes, int intervaloMaxMes, String mensagem) {
		final LocalDate hoje = now(); 
		int mesMaximo = hoje.getMonthValue() + intervaloMaxMes;
		if (mes.getMonthValue() > mesMaximo) {
			throw new IllegalStateException(mensagem); 
		} 
	}
	
	// VALIDAÇÃO DATA CRIACAO/ALTERACAO//
	public static void validarDataAnterior(LocalDateTime dataA, LocalDateTime dataB, String mensagem) {
		if (dataA.isBefore(dataB)) {
			throw new IllegalStateException(mensagem); 
		}
	}
	
	public static void validarDataAnterior(LocalDate data, int intervaloMaxAnos, String mensagem) {
		final LocalDate dataAgora = now();
		long anos = ChronoUnit.YEARS.between(data, dataAgora);
		if (data.isBefore(dataAgora) && anos > intervaloMaxAnos) {
			throw new IllegalStateException(mensagem); 
		}
	}
}
