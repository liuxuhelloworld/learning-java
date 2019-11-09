package holding;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Collection;
import java.util.Arrays;

public class Ex11 {
	public static void displayAll(Collection c) {
		Iterator it = c.iterator();

		while (it.hasNext()) {
			System.out.println(it.next() + "");
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3));
		LinkedList<Character> ll = new LinkedList<>(Arrays.asList('a', 'b', 'c'));
		HashSet<Float> hs = new HashSet<>(Arrays.asList(1.1f, 2.2f, 3.3f));
		TreeSet<Double> ts = new TreeSet<>(Arrays.asList(1.1, 2.2, 3.3));
		LinkedHashSet<Integer> lhs = new LinkedHashSet<>(Arrays.asList(1, 2, 3));

		displayAll(al);
		displayAll(ll);
		displayAll(hs);
		displayAll(ts);
		displayAll(lhs);
	}
}
