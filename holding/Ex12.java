package holding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Ex12 {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		Collections.addAll(list1, 1, 2, 3, 4, 5);

		List<Integer> list2 = new ArrayList<>();
		Collections.addAll(list2, 6, 7, 8, 9, 10);

		ListIterator<Integer> it1 = list1.listIterator();

		while (it1.hasNext()) {
			it1.next();
		}


		while (it1.hasPrevious()) {
			list2.add(it1.previous());
		}

		System.out.println(list1);
		System.out.println(list2);
	}
}
