package holding;

import java.util.HashSet;
import java.util.Collection;

public class Ex2 {
	public static void main(String[] args) {
		Collection<Integer> c = new HashSet<>();

		for (int i = 0; i < 10; i++) {
			c.add(i);
		}

		for (Integer i : c) {
			System.out.println(i);
		}
	}
}
