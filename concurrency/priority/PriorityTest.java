package concurrency.priority;

public class PriorityTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                Thread.currentThread().getName() + ", " + Thread.currentThread().getPriority());
        };

        Thread t1 = new Thread(r);
        t1.setPriority(Thread.MIN_PRIORITY);

        Thread t2 = new Thread(r);

        Thread t3 = new Thread(r);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
