package manytimepad2;

public class Converter {

	// chuyển ký hexa đầu vào thành decimal, do giới hạn kiểu nên hàm này chỉ chuyển
	// 2 ký tự đầu vào thành decimal
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

	// chuyển chuỗi các ký tự hexa của ciphertext đầu vào thành chuỗi các ký tự
	// decimal
	public static String hexaToDecimal2(String cipher) {
		StringBuffer cipherDecimal = new StringBuffer();

		for (int i = 0; i < cipher.length() - 2; i += 2) {
			int j = i+2;
			String decimal = hexaToDecimal(cipher.substring(i, j));
			cipherDecimal.append(decimal);
			cipherDecimal.append(" ");
		}
		return cipherDecimal.toString();
	}
}
