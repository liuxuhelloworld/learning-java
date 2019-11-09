package concurrency;

import java.util.concurrent.TimeUnit;

public class Ex7 {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new Daemon());
		t.setDaemon(true);
		t.start();

		System.out.println("t.isDaemon() = " + t.isDaemon());

		TimeUnit.NANOSECONDS.sleep(1);
	}
}

class Daemon implements Runnable {
	private final int THREAD_NUM = 15;

	private Thread[] t = new Thread[THREAD_NUM];

	public void run() {
		for (int i = 0; i < THREAD_NUM; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started");
		}

		for (int i = 0; i < THREAD_NUM; i++) {
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
