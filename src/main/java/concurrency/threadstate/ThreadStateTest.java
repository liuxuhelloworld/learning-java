package concurrency.threadstate;

public class ThreadStateTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        };

        Thread t = new Thread(r);
        System.out.println(t.getState());
        t.start();
        while (t.isAlive()) {
            System.out.println(t.getState());
        }
    }
}
