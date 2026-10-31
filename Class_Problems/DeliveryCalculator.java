
import java.util.*;

abstract class Delivery {
    double weight, distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class Standard extends Delivery {
    Standard(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 5 + weight * 0.50 + distance * 0.10;
    }
}

class Express extends Delivery {
    Express(double w, double d) {
        super(w, d);
    }

    double calculateFee() {
        return 15 + weight + distance * 0.20;
    }
}

class International extends Delivery {
    double customsFee;

    International(double w, double d, double c) {
        super(w, d);
        customsFee = c;
    }

    double calculateFee() {
        return 25 + weight * 2 + distance * 0.50 + customsFee;
    }
}

public class DeliveryCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            Delivery d = switch (type) {
                case "STANDARD" -> new Standard(weight, distance);
                case "EXPRESS" -> new Express(weight, distance);
                case "INTERNATIONAL" ->
                    new International(weight, distance, sc.nextDouble());
                default -> throw new IllegalArgumentException();
            };

            double fee = d.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
