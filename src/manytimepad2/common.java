package manytimepad2;

import java.util.ArrayList;

public class common {
	public static void main(String[] args) {
		CipherText ct = new CipherText();
		Key key = new Key();
		System.out.println();
		for(int i = 0; i < 83; i++) {
			int a = key.key.get(i);
			int b = ct.listTargetCipherText.get(i);
			int c = a ^ b;
			char e = (char) c;
			System.out.print(e);
		}
		
		for(Integer i : key.key) {
			System.out.print(i);
			System.out.print( " ");
		}
	}

}
