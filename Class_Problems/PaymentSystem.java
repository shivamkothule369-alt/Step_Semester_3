
import java.util.*;

abstract class Payment {
    abstract double calculate(double amount);
}

class Card extends Payment {
    double calculate(double amount) {
        return amount * 1.02;
    }
}

class Wallet extends Payment {
    double calculate(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer extends Payment {
    double calculate(double amount) {
        return amount;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment p = switch (type) {
                case "CARD" -> new Card();
                case "WALLET" -> new Wallet();
                case "BANKTRANSFER" -> new BankTransfer();
                default -> throw new IllegalArgumentException();
            };

            double result = p.calculate(amount);
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
