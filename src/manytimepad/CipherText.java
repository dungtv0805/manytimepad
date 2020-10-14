package manytimepad;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class CipherText {
	public Map<Integer, String> ciphertexts = new HashMap<>();
	
	public Map<Integer, String> ciphertextDecimals	= new HashMap<>();
	
	public List<String> cipher1 = new ArrayList<>();
	public List<String> cipher2 = new ArrayList<>();
	public List<String> cipher3 = new ArrayList<>();
	public List<String> cipher4 = new ArrayList<>();
	public List<String> cipher5 = new ArrayList<>();
	public List<String> cipher6 = new ArrayList<>();
	public List<String> cipher7 = new ArrayList<>();
	public List<String> cipher8 = new ArrayList<>();
	public List<String> cipher9 = new ArrayList<>();
	public List<String> cipher10 = new ArrayList<>();
	public List<String> cipher11 = new ArrayList<>();
	
	
	public String targetCiphertext;

	public CipherText() {
		File file = new File("C:\\Users\\Hello World\\eclipse-workspace\\manytimepad\\src\\ciphertext.txt");

		try {
			Scanner scanner = new Scanner(file);
			int i = 1;
			while (scanner.hasNextLine()) {
				this.ciphertexts.put(i, scanner.nextLine());
				i++;
			}

			scanner.close();
			this.targetCiphertext = ciphertexts.get(10);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Iterator<Integer> iterator = this.ciphertexts.keySet().iterator();

		while (iterator.hasNext()) {
			int j = iterator.next();
			this.ciphertexts.put(j, ciphertexts.get(j).substring(0, 166));
			this.ciphertextDecimals.put(j, Convert.hexaToDecimal2(this.ciphertexts.get(j)));
		}
		
		create();
		
	}

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
	
	public void create() {
		StringBuffer cipherDecimal = new StringBuffer();
		String cipher1 = this.ciphertextDecimals.get(1);
		StringTokenizer st = new StringTokenizer(cipher1, " ");
		while(st.hasMoreTokens()) {
			this.cipher1.add(st.nextToken());
		}
	}

	
//	public void CipherText

}
