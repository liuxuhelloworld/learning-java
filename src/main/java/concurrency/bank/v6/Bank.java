package concurrency.bank.v6;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {
    private final double[] accounts;
    private BlockingQueue<TransferCommand> queue = new LinkedBlockingQueue<>();

    public Bank(int n, double initial) {
        accounts = new double[n];
        Arrays.fill(accounts, initial);

        initStart();
    }

    public void initStart() {
        Runnable r = () -> {
            try {
                while (true) {
                    TransferCommand command = queue.take();

                    int from = command.getFrom();
                    int to = command.getTo();
                    double amount = command.getAmount();

                    if (accounts[from] < amount) {
                        return;
                    }

                    System.out.print(Thread.currentThread());

                    accounts[from] -= amount;
                    System.out.printf(" %10.2f from %d to %d", amount, from, to);

                    accounts[to] += amount;

                    System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(r).start();
    }

    public void transfer(TransferCommand command) throws InterruptedException {
        queue.put(command);
    }

    /**
     * thread safe
     */
    public void transfer(int from, int to, double amount) throws InterruptedException {

        TransferCommand command = new TransferCommand();
        command.setFrom(from);
        command.setTo(to);
        command.setAmount(amount);

        queue.put(command);
    }

    /**
     * thread safe
     */
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
