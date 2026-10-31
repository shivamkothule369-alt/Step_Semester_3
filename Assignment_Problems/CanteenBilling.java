
import java.util.Scanner;

abstract class Customer {
    abstract double calculateBill(double amount);
}

class Student extends Customer {
    double calculateBill(double amount) {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    double calculateBill(double amount) {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    double calculateBill(double amount) {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            Customer c;

            switch (type) {
                case "STUDENT":
                    c = new Student();
                    break;

                case "STAFF":
                    c = new Staff();
                    break;

                case "GUEST":
                    c = new Guest();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid customer");
            }

            double bill = c.calculateBill(amount);

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
