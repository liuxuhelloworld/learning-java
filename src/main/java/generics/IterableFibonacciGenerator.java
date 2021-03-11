package generics;

import java.util.Iterator;

public class IterableFibonacciGenerator extends FibonacciGenerator implements Iterable<Integer> {
	private int n;

	public IterableFibonacciGenerator(int n) {
		this.n = n;
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public boolean hasNext() {
				return n > 0;
			}

			public Integer next() {
				n--;
				return IterableFibonacciGenerator.this.next();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (int i : new IterableFibonacciGenerator(18)) {
			System.out.println(i);
		}
	}
}
