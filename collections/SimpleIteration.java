package collections;

import typeinfo.pets.*;

import java.util.List;
import java.util.Iterator;

public class SimpleIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(12);

		Iterator<Pet> it = pets.iterator();
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();

		for (Pet p : pets) {
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();

		it = pets.iterator();
		for (int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		System.out.println(pets);
	}
}
