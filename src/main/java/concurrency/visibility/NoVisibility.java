package concurrency.visibility;

public class NoVisibility {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {
				Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static void main(String[] args) throws Exception {
		new ReaderThread().start();

		ready = true;
		number = 42;
	}
}
