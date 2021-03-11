package lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class LambdaUtil {
    public static void repeat(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    public static void repeat(int n, Consumer<Integer> action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

    public static void main(String[] args) {
        repeat(10, () -> System.out.println("Hello, World"));
        repeat(10, (Consumer<Integer>)(i -> System.out.println("Countdown: " + (9 - i))));
        repeat(10, (IntConsumer)(i -> System.out.println("Countdown: " + (9 - i))));
    }
}
