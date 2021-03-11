package concurrency.volatiletest.v2;

public class VolatileTest {
    private volatile boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone() {
        done = true;
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();

        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
            volatileTest.setDone();
            System.out.println("Thread 1: " + volatileTest.isDone());
        };

        Runnable r2 = () -> {
            int i = 0;
            while (!volatileTest.isDone()) {
                i++;
            }
            System.out.println("Thread 2: " + volatileTest.isDone());
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
