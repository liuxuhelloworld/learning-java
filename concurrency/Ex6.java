package concurrency;

import java.util.Random;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex6 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			exec.execute(new Ex6Runner());
		}
		exec.shutdown();
	}
}

class Ex6Runner implements Runnable {
	private Random rand = new Random();

	public void run() {
		try {
			int t = rand.nextInt(10) + 1;

			TimeUnit.SECONDS.sleep(t);

			System.out.println("sleeped " + t + " seconds");
		} catch (InterruptedException e) {
			System.err.println("Interrupted");
		}
	}
}
