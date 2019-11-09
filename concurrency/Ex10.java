package concurrency;

import java.util.ArrayList;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Callable;

public class Ex10 {
	public static void main(String[] args) {
		Ex10Fibonacci fib = new Ex10Fibonacci();

		try {
			for (int i = 0; i < 3; i++) {
				System.out.println(fib.runTask(i + 10).get());
			}
		} catch (InterruptedException e) {
			System.out.println(e);
			return ;
		} catch (ExecutionException e) {
			System.out.println(e);
		} finally {
			fib.exec.shutdown();
		}
	}
}

class Ex10Fibonacci implements Callable<Integer> {
	private int n;

	ExecutorService exec = Executors.newSingleThreadExecutor();

	public Future<Integer> runTask(int n) {
		this.n = n;
		return exec.submit(this);
	}

	public Integer call() {
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += fib(i);
		}

		return sum;
	}


	private int fib(int n) {
		if (n < 2) {
			return 1;
		}

		return fib(n - 2) + fib(n - 1);
	}
}
