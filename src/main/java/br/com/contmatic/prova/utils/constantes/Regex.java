package br.com.contmatic.prova.utils.constantes;

public class Regex {

	private static final String zeroAte255 = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

	// REGEX
	public static final String REGEX_CODIGO = "([1-9][0-9]*)";
	public static final String REGEX_CEP = "[0-9]{5}[0-9]{3}";
	public static final String REGEX_NUMEROS = "([0-9]*)";
	public static final String REGEX_DDI = "^(?:\\+)[0-9]{2}";
	public static final String REGEX_DDD = "\\d{2}";
	public static final String REGEX_IP = zeroAte255 + "\\." + zeroAte255 + "\\." + zeroAte255 + "\\." + zeroAte255;
	public static final String REGEX_CARACTER = "^([a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.']\\s?)+[a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.']$";
	public static final String REGEX_ALFANUMERICO = "^([a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.'0-9]\\s?)+[a-zA-ZàáâäãåèéêëėìíîïòóôöõùúûüūÀÁÂÄÃÅĖÈÉÊËÌÍÎÏÒÓÔÖÕÙÚÛÜŪ.'0-9]$";
	public static final String REGEX_EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

}
