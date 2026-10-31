
import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return Math.min(2 + distance * 0.10, 10);
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + distance * 0.15;
    }
}

class Metro extends Transport {
    double peakHourFactor;

    Metro(double distance, double factor) {
        super(distance);
        peakHourFactor = factor;
    }

    double calculateFare() {
        return (1.50 + distance * 0.20) * peakHourFactor;
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport t = switch (type) {
                case "BUS" -> new Bus(distance);
                case "TRAIN" -> new Train(distance);
                case "METRO" ->
                    new Metro(distance, sc.nextDouble());
                default -> throw new IllegalArgumentException();
            };

            double fare = t.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
