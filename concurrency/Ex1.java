package concurrency;

public class Ex1 {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(new Ex1Runner(i)).start();
		}
	}

}
	
class Ex1Runner implements Runnable {
	private final int id;

	public Ex1Runner(int id) {
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
