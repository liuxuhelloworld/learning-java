package collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class Ex14 {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		addMiddle(list, arr);
		System.out.println(list);
	}

	public static void addMiddle(LinkedList<Integer> list, Integer[] arr) {
		for (Integer x : arr) {
			ListIterator<Integer> it = list.listIterator(list.size() / 2);
			it.add(x);
		}
	}
}
