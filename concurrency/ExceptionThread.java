package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExceptionThread implements Runnable {
	public void run() {
		throw new RuntimeException();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
