package br.com.contmatic.prova.utils.constantes;

public final class Regex { 
	
	private Regex() {}

	private static final String ZERO_ATE_255 = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";
 
	// REGEX
	public static final String REGEX_CODIGO = "([1-9][0-9]*)";
	public static final String REGEX_CODIGO_BARRAS = "^[0-9]{13}$";
	public static final String REGEX_CEP = "[0-9]{5}[0-9]{3}";
	public static final String REGEX_NUMEROS = "([0-9]*)";
	public static final String REGEX_DDI = "^(?:\\+)[0-9]{2}";
	public static final String REGEX_DDD = "\\d{2}";
	public static final String REGEX_IP = ZERO_ATE_255 + "\\." + ZERO_ATE_255 + "\\." + ZERO_ATE_255 + "\\." + ZERO_ATE_255;
	public static final String REGEX_CARACTER = "^([a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.']\\s?)+[a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.']$";
	public static final String REGEX_ALFANUMERICO = "^([a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.'0-9]\\s?)+[a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.'0-9]$";
	public static final String REGEX_EMAIL = "([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
}
