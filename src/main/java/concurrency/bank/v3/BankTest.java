package concurrency.bank.v3;

public class BankTest {
    public static final int DELAY = 10;
    public static final int ACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        Bank bank = new Bank(ACCOUNTS, INITIAL_BALANCE);

        for (int i = 0; i < ACCOUNTS; i++) {
            int from = i;

            Runnable r = () -> {
                try {
                    while (true) {
                        int to = (int)(ACCOUNTS * Math.random());
                        //double amount = MAX_AMOUNT * 2 * Math.random(); // deadlock risk
                        double amount = MAX_AMOUNT * Math.random();
                        // bank.transfer(to, from, amount); // deadlock risk
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
