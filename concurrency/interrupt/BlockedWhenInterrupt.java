package concurrency.interrupt;

public class BlockedWhenInterrupt {
    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            try {
                System.out.println("1: " + Thread.currentThread().getState());
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println("3: " + Thread.currentThread().getState());
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(1000);

        System.out.println("2: " + t.getState());
        t.interrupt();

        Thread.sleep(1000);

        System.out.println("4: " + t.getState());
    }
}
