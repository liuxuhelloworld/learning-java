package concurrency.corejava;

import concurrency.corejava.v5.Bank;

public class BankTest {
    public static final int DELAY = 10;
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        var bank = new Bank(NACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < NACCOUNTS; i++) {
            int from = i;

            Runnable r = () -> {
                try {
                    while (true) {
                        int to = (int)(NACCOUNTS * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(from, to, amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                }
            };
            new Thread(r).start();
        }
    }
}
