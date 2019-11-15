package concurrency;

public class Ex2 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(new Fibonacci(i + 10));
			t.start();
		}
		System.out.println("waiting...");
	}
}
