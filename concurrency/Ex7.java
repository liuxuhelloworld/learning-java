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
