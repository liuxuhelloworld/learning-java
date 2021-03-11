package concurrency.interrupt;

public class RunningWhenInterrupt {
    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("running");
            }
            System.out.println("interrupted");
        };

        Thread t = new Thread(r);
        t.start();
        Thread.sleep(1);
        t.interrupt();
    }
}
