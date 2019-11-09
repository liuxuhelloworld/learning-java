package holding;

import typeinfo.pets.*;

import java.util.ListIterator;
import java.util.List;

public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(8);

		ListIterator<Pet> it = pets.listIterator();

		System.out.println(pets);

		while (it.hasNext()) {
			System.out.print(it.next() + "," + it.nextIndex() + "," + it.previousIndex() + ";");
		}
		System.out.println();

		while (it.hasPrevious()) {
			System.out.print(it.previous().id() + " ");
		}
		System.out.println();
		
		it = pets.listIterator(3);
		while (it.hasNext()) {
			it.next();
			it.set(Pets.randomPet());
		}
		System.out.println(pets);
	}
}
