package manytimepad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class common {
	List<String> list = new ArrayList<>();
	static List<Integer> keys = new ArrayList<>();

	public static void main(String[] args) {

		List<String> list1 = new CipherText().cipher1;

		for (int g = 0; g < 83; g++) {
			keys.add(g, 0);
		}

		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < 83; j++) {
			list.add(j, 0);
		}

		for (int j = 1; j < 11; j++) {

			List<Integer> listSpace = countSpace(j);

			int a = 0;
			int c = 0;
			for (Integer i : listSpace) {
				if (i >= 6) {
					list.set(a, i);
//				System.out.print(a + 1 + ":" + i);
//					System.out.print(a + 1 + " :" + (Integer.parseInt(list1.get(a)) ^ 32));
					keys.set(a, Integer.parseInt(list1.get(a)) ^ 32);
//					System.out.print("  ");
					a++;
					c++;
				} else {
					a++;
				}
			}

		}
		System.out.println("key: ");

		for (Integer i : keys) {
			System.out.print(i);
			System.out.print(" ");

		}
	
//		System.out.println();
//		System.out.println(new CipherText().ciphertextDecimals.get(1));
		CipherText ct = new CipherText();
		StringBuffer keysb = new StringBuffer();
		for (Integer i : keys) {
			keysb.append(Integer.toString(i));
			keysb.append(" ");
		}
		
		String key = keysb.toString();
		
		String result = XORCipher.xor(key, ct.ciphertextDecimals.get(11));
		System.out.println();
		System.out.println("target:");
		System.out.println(result);
	
		System.out.println("Result:");
		StringTokenizer st11 = new StringTokenizer(result, " ");
		while(st11.hasMoreTokens()) {
			int d = Integer.parseInt(st11.nextToken());
			char c = (char) d;
			System.out.print(c);
		}
//		System.out.println();
//		System.out.println(ct.ciphertextDecimals.get(11));


	}

	// xor dãy các ciphertext dưới dạng decimal lại với nhau và trả về chuỗi decimal
	// sau xor
	public static List<String> xorCipher(int i) {
		CipherText ct = new CipherText();
		Iterator<Integer> itr = ct.ciphertextDecimals.keySet().iterator();
		StringBuffer sb = new StringBuffer();
		List<String> result = new ArrayList<>();
		while (itr.hasNext()) {
			String st = XORCipher.xor(ct.ciphertextDecimals.get(i), ct.ciphertextDecimals.get(itr.next()));
			result.add(st);
		}
		return result;
	}

	// đếm số lượng decimal có giá trị >= 65 và <= 90. Đây là các ký tự khi xor với
	// dấu cách ra ký tự in hoa có giá trị decimal trong khoảng [65,90]
	public static List<Integer> countSpace(int i) {
		List<Integer> result = new ArrayList<>();
		for (int j = 0; j < 83; j++) {
			result.add(j, 0);
		}
		for (String s : xorCipher(i)) {

			StringTokenizer st = new StringTokenizer(s, " ");
			int a = 0;
			while (st.hasMoreTokens()) {
				Integer j = Integer.parseInt(st.nextToken());
				if (j >= 65 && j <= 90) {
					int k = result.get(a);
					result.set(a, k + 1);
					a++;
				} else {
					int k = result.get(a);
					result.set(a, k);
					a++;
				}

			}
		}

		return result;
	}

	public String solution() {
		CipherText ct = new CipherText();
		StringBuffer keysb = new StringBuffer();
		for (Integer i : keys) {
			keysb.append(Integer.toString(i));
			keysb.append(" ");
		}
		
		String key = keysb.toString();
		
		String result = XORCipher.xor(key, ct.targetCiphertext);
		return result;
	}
}
