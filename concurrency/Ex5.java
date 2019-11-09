package concurrency;

import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;

public class Ex5 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();

		ArrayList<Future<Integer>> results = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			results.add(exec.submit(new Fibonacci(i + 10)));
		}

		for (Future<Integer> fi : results) {
			try {
				System.out.println(fi.get());
			} catch (InterruptedException e) {
				System.out.println(e);
				return ;
			} catch (ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
		}
	}
}

class Fibonacci implements Callable<Integer> {
	private int n;
	private int count = 0;

	public Fibonacci(int n) {
		this.n = n;
	}

	public Integer call() {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += next();
		}

		return sum;
	}

	private int next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2) {
			return 1;
		}

		return fib(n - 2) + fib(n - 1);
	}
}
