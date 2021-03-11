package concurrency.interrupt;

public class InterruptProcessingExample2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                int i = 0;
                long sum = 0;
                while (i <= Integer.MAX_VALUE) {
                    sum += i++;
                    System.out.println(i + ", " + sum);
                    Thread.sleep(1);
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
