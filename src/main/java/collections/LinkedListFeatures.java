package collections;

import typeinfo.pets.*;

import java.util.LinkedList;

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets = new LinkedList<>(Pets.arrayList(5));

		System.out.println(pets);

		System.out.println("pets.getFirst(): " + pets.getFirst());
		System.out.println("pets.element(): " + pets.element());

		System.out.println("pets.peek(): " + pets.peek());

		System.out.println("pets.remove(): " + pets.remove());
		System.out.println("pets.removeFirst(): " + pets.removeFirst());

		System.out.println("pets.poll(): " + pets.poll());

		System.out.println(pets);

		pets.addFirst(new Rat());
		System.out.println("after addFirst(): " + pets);

		pets.offer(Pets.randomPet());
		System.out.println("after offer(): " + pets);
		
		pets.add(Pets.randomPet());
		System.out.println("after add(): " + pets);

		pets.addLast(new Hamster());
		System.out.println("after addLast(): " + pets);

		System.out.println("pets.removeLast(): " + pets.removeLast());
	}
}
