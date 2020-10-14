package manytimepad;

import java.util.Iterator;

public class Convert {

	public static String hexaToDecimal(String hexa) {
		String digits = "0123456789ABCDEF";
		hexa = hexa.toUpperCase();
		int val = 0;
		for (int i = 0; i < hexa.length(); i++) {

			char c = hexa.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return Integer.toString(val);
	}

	public static String hexaToDecimal2(String cipher) {

		StringBuffer cipherDecimal = new StringBuffer();

		for (int i = 0; i < cipher.length() - 2; i += 2) {
			int j = i + 2;
			String demacia = hexaToDecimal(cipher.substring(i, j));
			cipherDecimal.append(demacia);
			cipherDecimal.append(" ");
		}

		return cipherDecimal.toString();
	}
}
