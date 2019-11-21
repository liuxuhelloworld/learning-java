package collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.Random;

public class SortedSetOfInteger {
	public static void main(String[] args) {
		Random rand = new Random(47);

		Set<Integer> intset = new TreeSet<>();

		for (int i = 0; i < 10000; i++) {
			intset.add(rand.nextInt(300));
		}

		System.out.println(intset);
	}
}
