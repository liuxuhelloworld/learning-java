package holding;

import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;

public class QueueDemo {
	public static void main(String[] args) {

		Random rand = new Random(47);

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			queue.offer(rand.nextInt(i + 10));
		}
		printQ(queue);

		Queue<Character> qc = new LinkedList<>();
		for (char c : "Brontosaurus".toCharArray()) {
			qc.offer(c);
		}
		printQ(qc);
	}

	public static void printQ(Queue queue) {
		while (queue.peek() != null) {
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}
}
