package concurrency.corejava.bank.v4;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initial) {
        accounts = new double[n];
        Arrays.fill(accounts, initial);
    }

    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount) {
            wait();
        }

        System.out.print(Thread.currentThread());

        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d", amount, from, to);

        accounts[to] += amount;

        notifyAll();

        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }

    public synchronized double getTotalBalance() {
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
