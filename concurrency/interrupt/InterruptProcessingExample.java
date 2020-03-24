package concurrency.interrupt;

public class InterruptProcessingExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                int i = 0;
                long sum = 0;
                while (!Thread.currentThread().isInterrupted() && i <= Integer.MAX_VALUE) {
                    sum += i++;
                    if (i % Integer.MAX_VALUE == 0) {
                        Thread.sleep(1);
                    }
                }
                System.out.println(sum);
            } catch (InterruptedException e) {
                System.out.println("interrupted exception");
            }
        };

        Thread t = new Thread(r);
        t.start();

        Thread.sleep(100);

        t.interrupt();
    }
}
