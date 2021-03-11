package concurrency.sequencer.v1;


public class SequenceGenerator {
    private static Long seq= 0L;

    public Long next() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        return seq = seq + 1;
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
