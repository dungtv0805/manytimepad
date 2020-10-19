package manytimepad;

import java.util.ArrayList;

public class common {
	public static void main(String[] args) {
		CipherText ct = new CipherText();
		Key key = new Key();

		for (int i = 0; i < 83; i++) {
			int a = key.key.get(i);
			int b = ct.listTargetCipherText.get(i);
			int c = a ^ b;
			char e = (char) c;
			System.out.print(e);
		}

	}

}
