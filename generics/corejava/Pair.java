package generics.corejava;

import java.util.function.Supplier;

public class Pair<T> {
	private T first;
	private T second;

	public Pair() {
		first = null;
		second = null;
	}

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}

	public void setFirst(T val) {
		first = val;	
	}

	public void setSecond(T val) {
		second = val;
	}

	@Override
	public String toString() {
		return "first=" + first + ", second=" + second;
	}

	// public boolean equals(T val) { // error, clashes with Object.equals
	//	return first.equals(val) && second.equals(val);
	// }

	public static <T> Pair<T> makePair(Supplier<T> constr) {
		return new Pair<>(constr.get(), constr.get());
	}

	public static <T> Pair<T> makePair(Class<T> cl) {
		try {
			return new Pair<>(cl.getConstructor().newInstance(), cl.getConstructor().newInstance());
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean hasNulls(Pair<?> p) {
		return p.getFirst() == null || p.getSecond() == null;
	}

	public static <T> void swapHelper(Pair<T> p) {
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}

	public static void swap(Pair<?> p) {
		swapHelper(p);
	}
}
