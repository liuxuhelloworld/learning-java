package collections;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class Statistics {
	public static void main(String[] args) {
		Random rand = new Random(47);

		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < 10000; i++) {
			int v = rand.nextInt(20);

			Integer freq = m.get(v);

			m.put(v, freq == null ? 1 : freq + 1);
		}

		System.out.println(m);
	}
}
