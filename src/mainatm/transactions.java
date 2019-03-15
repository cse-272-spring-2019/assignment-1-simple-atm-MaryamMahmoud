package mainatm;

public class transactions {

    private static double balance = 0.0;
    public static double amount;

    public static double getBalance() {
        return balance;
    }

    public static void deposit(double amount) {
        balance += amount;
        String amountString = Double.toString(amount);
    }

    public static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("You can't do this process");

        } else {
            balance -= amount;
            String amountString = Double.toString(amount);
        }
    }

}
