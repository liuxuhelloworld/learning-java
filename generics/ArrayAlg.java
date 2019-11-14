package generics;

import java.util.Arrays;
import java.util.List;

public class ArrayAlg {
	public static Pair<String> minmax(String[] a) {
		if (a == null || a.length == 0) {
			return null;
		}

		String min = a[0];
		String max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (min.compareTo(a[i]) > 0) {
				min = a[i];
			}
			if (max.compareTo(a[i]) < 0) {
				max = a[i];
			}
		}

		return new Pair<String>(min, max);
	}

	public static <T> T getMiddle(T... a) {
		Arrays.sort(a);
		return a[a.length / 2];
	}
}
