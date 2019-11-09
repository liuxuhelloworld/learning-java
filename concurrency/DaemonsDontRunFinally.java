package concurrency;

import java.util.concurrent.TimeUnit;

public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();

		TimeUnit.MILLISECONDS.sleep(100);
	}
}

class ADaemon implements Runnable {
	public void run() {
		try {
			System.out.println("starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("exiting via InterruptedException");
		} finally {
			System.out.println("this should not be run");
		}
	}
}
