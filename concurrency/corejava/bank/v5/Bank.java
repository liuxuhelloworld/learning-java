package concurrency.corejava.bank.v5;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;
    private Object lock = new Object();

    public Bank(int n, double initial) {
        accounts = new double[n];
        Arrays.fill(accounts, initial);
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        synchronized (lock) {
            while (accounts[from] < amount) {
                lock.wait();
            }

            System.out.print(Thread.currentThread());

            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);

            accounts[to] += amount;

            lock.notifyAll();

            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        }
    }

    public double getTotalBalance() {
        synchronized (lock) {
            double sum = 0.0;

            for (double amount : accounts) {
                sum += amount;
            }

            return sum;
        }
    }

    public int size() {
        return accounts.length;
    }
}
