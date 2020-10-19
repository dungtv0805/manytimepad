package manytimepad2;

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
	public Map<Integer, String> ciphertextDecimal = new HashMap<>();
	public List<ArrayList<Integer>> listCipherTextDecimal = new ArrayList<>();
	public List<ArrayList<String>> listCipherXor = new ArrayList<>();
	public List<ArrayList<Integer>> numberOfSpace = new ArrayList<>();
	public List<Integer> listTargetCipherText = new ArrayList<>();

	public CipherText() {
		// ciphertexts and ciphertextDecimal
		File file = new File("C:\\Users\\Hello World\\eclipse-workspace\\manytimepad2\\src\\ciphertext.txt");

		try {
			Scanner scanner = new Scanner(file);
			int i = 0;
			while (scanner.hasNextLine()) {
				String s = scanner.nextLine();
				ciphertexts.put(i, s);
				i++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Iterator<Integer> iterator = this.ciphertexts.keySet().iterator();

		int k = 0;
		while (iterator.hasNext()) {
			int i = iterator.next();
			String s = this.ciphertexts.get(i).substring(0, 166);
			this.ciphertexts.put(i, s);
			this.ciphertextDecimal.put(i, Converter.hexaToDecimal2(s));
			k++;
		}

		for (int i = 0; i < k; i++) {
			String cipher1 = this.ciphertextDecimal.get(i);
			ArrayList<String> list = new ArrayList<>();
			for (int j = 0; j < k; j++) {
				String cipher2 = this.ciphertextDecimal.get(j);
				String resultXor = xor(cipher1, cipher2);
				list.add(resultXor);
			}
			this.listCipherXor.add(list);
		}

		for (int i = 0; i < 11; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < 83; j++) {
				list.add(j, 0);
			}
			this.numberOfSpace.add(list);
		}
		int q = 0;
		for (ArrayList<String> list : listCipherXor) {
			for (String s : list) {
				StringTokenizer st = new StringTokenizer(s, " ");
				int a = 0;
				while (st.hasMoreElements()) {
					Integer b = Integer.parseInt(st.nextToken());
					if (b >= 65 && b <= 90) {
						int c = this.numberOfSpace.get(q).get(a);
						this.numberOfSpace.get(q).set(a, c + 1);
						a++;
					} else {
						int c = this.numberOfSpace.get(q).get(a);
						this.numberOfSpace.get(q).set(a, c);
						a++;
					}
				}
			}
			q++;
		}

		for (int i = 0; i < 11; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < 83; j++) {
				list.add(j, 0);
			}
			this.listCipherTextDecimal.add(list);
		}

		Iterator<Integer> iterator2 = this.ciphertextDecimal.keySet().iterator();
		while (iterator2.hasNext()) {
			for (ArrayList<Integer> list : this.listCipherTextDecimal) {
				int i = iterator2.next();
				StringTokenizer st = new StringTokenizer(this.ciphertextDecimal.get(i), " ");
				int a = 0;
				while (st.hasMoreTokens()) {
					list.set(a, Integer.parseInt(st.nextToken()));
					a++;
				}
			}
		}
		
		StringTokenizer st = new StringTokenizer(this.ciphertextDecimal.get(10), " ");
		while (st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			listTargetCipherText.add(a);
			
		}

	}

	public static String xor(String cipher1, String cipher2) {
		StringBuffer result = new StringBuffer();
		StringTokenizer st1 = new StringTokenizer(cipher1, " ");
		StringTokenizer st2 = new StringTokenizer(cipher2, " ");
		while (st1.hasMoreTokens() && st2.hasMoreElements()) {
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = a ^ b;
			result.append(c);
			result.append(" ");
		}
		return result.toString();
	}
}
