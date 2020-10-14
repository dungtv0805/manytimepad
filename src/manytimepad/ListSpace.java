package manytimepad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class ListSpace {
	public List<Integer> listSpace = new ArrayList<>();
	
	public ListSpace() {
		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < 83; j++) {
			list.add(j, 0);
		}
		List<Integer> listSpace = countSpace(11);
		
		int a = 0;
		int c = 0;
		for(Integer i : listSpace) {
			if(i>=6) {
				list.set(a, i);
				a++;
				c++;
			}else {
				a++;
			}
		}
	}
	
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
}
