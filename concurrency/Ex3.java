package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Ex3 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			exec.execute(new Ex1Runner(i));
		}
		exec.shutdown();
	}

}
	
class Ex3Runner implements Runnable {
	private final int id;

	public Ex3Runner(int id) {
		this.id = id;
		System.out.println("Ex1Runner " + id + " constructed");
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Ex1Runner " + id + " run " + i);
			Thread.yield();
		}
		System.out.println("Ex1Runner " + id + " terminate");
		return ;
	}
}
