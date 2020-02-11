package generics.corejava;

public class DefeatCheckedExceptionTest {
    public static void main(String[] args) {
        Thread thread = new Thread(DefeatCheckedExceptionTask.asRunnable(
            () -> {
                Thread.sleep(1000);
                System.out.println("Hello, World");
                throw new Exception("check this out");
            }
        ));

        thread.start();
    }
}
