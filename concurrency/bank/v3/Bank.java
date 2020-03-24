package concurrency.bank.v3;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;

    private Lock bankLock;
    private Condition sufficientFunds;

    public Bank(int n, double initial) {
        accounts = new double[n];
        Arrays.fill(accounts, initial);

        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }

            System.out.print(Thread.currentThread());

            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);

            accounts[to] += amount;

            sufficientFunds.signalAll();
        } finally {
            bankLock.unlock();
        }

        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }

    public double getTotalBalance() {
        bankLock.lock();
        try {
            double sum = 0.0;

            for (double amount : accounts) {
                sum += amount;
            }

            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }
}
