class PiggyBank {

    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        savings = savings + amount;
    }

    public void withdraw(double amount) {
        if (amount <= savings) {
            savings = savings - amount;
        } else {
            System.out.println("Withdrawal rejected");
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}

public class PiggyBankTest {
    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}