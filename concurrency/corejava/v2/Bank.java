package concurrency.corejava.v2;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;

    private ReentrantLock bankLock = new ReentrantLock();

    public Bank(int n, double initial) {
        accounts = new double[n];
        Arrays.fill(accounts, initial);
    }

    // thread safe
    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }

        bankLock.lock();
        try {
            System.out.print(Thread.currentThread());

            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);

            accounts[to] += amount;

            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        } finally {
            bankLock.unlock();
        }

    }

    public double getTotalBalance() {
        double sum = 0.0;

        for (double amount : accounts) {
            sum += amount;
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }
}
