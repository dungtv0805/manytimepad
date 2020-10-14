package manytimepad;

import java.util.StringTokenizer;

public class XORCipher {
	public static String xor(String cipher1, String cipher2) {
		StringBuffer result = new StringBuffer();

		StringTokenizer st1 = new StringTokenizer(cipher1, " ");
		StringTokenizer st2 = new StringTokenizer(cipher2, " ");
		int i = 1;
		while (st1.hasMoreTokens() && st2.hasMoreTokens()) {
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = a ^ b;
			result.append(Integer.toString(c));
			result.append(" ");
			i++;
		}
//		System.out.println(i);

		return result.toString();
	}
}
