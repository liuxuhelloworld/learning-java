package concurrency.uncaughtexception;

public class UncaughtExceptionTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                throw new Exception("checked exception");
            } catch (Exception e) {
            }
            throw new RuntimeException("uncaught exception");
        };

        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(
            (thread, throwable) -> {
                System.out.println(thread.getName());
                throwable.printStackTrace();
            }
        );
        t.start();
        while (t.isAlive()) {
            System.out.println("alive");
        }
    }
}
