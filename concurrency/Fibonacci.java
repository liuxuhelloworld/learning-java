package concurrency;

public class Fibonacci implements Runnable {
    private int n;
    private int count = 0;

    public Fibonacci(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.print("Fibonacci(" + n + ")" + "[" + next() + "] ");
        }
        System.out.println();
    }

    private int next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }
}
