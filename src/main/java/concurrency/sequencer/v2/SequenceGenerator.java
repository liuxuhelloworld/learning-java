package concurrency.sequencer.v2;

import java.util.concurrent.atomic.AtomicLong;

public class SequenceGenerator {
    private static AtomicLong seq= new AtomicLong();

    public Long next() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        return seq.incrementAndGet();
    }

    public static void main(String[] args) {
        SequenceGenerator generator = new SequenceGenerator();

        Runnable r1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(generator.next());
            }
        };

        Runnable r2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(generator.next());
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
