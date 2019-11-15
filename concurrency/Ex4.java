package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Ex4 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			exec.execute(new Fibonacci(i + 10));
		}
		exec.shutdown();
		System.out.println("waiting...");
	}
}
