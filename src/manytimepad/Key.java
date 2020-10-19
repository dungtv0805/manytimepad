package manytimepad;

import java.util.ArrayList;
import java.util.List;

public class Key {
	List<Integer> key = new ArrayList<>();

	public Key() {
		for (int i = 0; i < 83; i++) {
			this.key.add(i, 0);
		}
		CipherText ct = new CipherText();
		
		int a = 0;
		for (ArrayList<Integer> listNumberOfSpace : ct.numberOfSpace) {

			int b = 0;
			for (Integer i : listNumberOfSpace) {
				if (i >= 7) {
//					int a = ct.listTargetCipherText.get(b);
//					int c = a ^ 32;
//					key.set(b, c);
					int c = ct.listCipherTextDecimal.get(a).get(b);
					int d = c ^ 32;
					key.set(b, d);
					b++;
				} else {
					b++;
				}
			}
			a++;
		}
	}
}
