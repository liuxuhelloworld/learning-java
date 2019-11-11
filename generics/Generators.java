package generics;

import java.util.Collection;
import java.util.ArrayList;
import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;

public class Generators {
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
		for (int i = 0; i < n; i++) {
			coll.add(gen.next());
		}

		return coll;
	}

	public static void main(String[] args) {
		Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
		for (Coffee c : coffee) {
			System.out.println(c);
		}

		Collection<Integer> fibonacci = fill(new ArrayList<Integer>(), new FibonacciGenerator(), 12);
		for (int i : fibonacci) {
			System.out.print(i + ", ");
		}
	}
}
