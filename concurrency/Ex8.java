package concurrency;

public class Ex8 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new LiftOff());
			t.setDaemon(true);
			t.start();
		}

		System.out.println("waiting for LiftOff");
	}
}
