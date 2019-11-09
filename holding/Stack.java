package holding;

import java.util.LinkedList;

public class Stack<T> {
	private LinkedList<T> s = new LinkedList<>();

	public void push(T ele) {
		s.addFirst(ele);
	}

	public T peek() {
		return s.getFirst();
	}

	public T pop() {
		return s.removeFirst();
	}

	public boolean empty() {
		return s.isEmpty();
	}

	public String toString() {
		return s.toString();
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();

		for (String v : "my dog has fleas".split(" ")) {
			s.push(v);
		}

		while (!s.empty()) {
			System.out.println(s.pop() + " ");
		}
	}
}
