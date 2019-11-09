package concurrency;

import java.util.concurrent.TimeUnit;

public class Daemons {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Daemon());
		t.setDaemon(true);
		t.start();

		System.out.println("t.isDaemon() = " + t.isDaemon());

		TimeUnit.SECONDS.sleep(1);
	}
}

class Daemon implements Runnable {
	private Thread[] t = new Thread[10];

	public void run() {
		for (int i = 0; i < 10; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started");
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon());
		}

		while (true) {
			Thread.yield();
		}
	}
}

class DaemonSpawn implements Runnable {
	public void run() {
		while (true) {
			Thread.yield();
		}
	}
}
