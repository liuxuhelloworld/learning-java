package generics;

public class TaskTest {
    public static void main(String[] args) {
        Thread thread = new Thread(Task.asRunnable(
            () -> {
                Thread.sleep(1000);
                System.out.println("Hello, World");
                throw new Exception("check this out");
            }
        ));

        thread.start();
    }
}
