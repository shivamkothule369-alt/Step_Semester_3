
import java.util.*;

abstract class Travel {
    double distance;

    static final double BOOKING_FEE = 50;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double totalFare() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel t;

            switch (mode) {
                case "BUS":
                    t = new Bus(distance);
                    break;

                case "TRAIN":
                    t = new Train(distance);
                    break;

                case "FLIGHT":
                    t = new Flight(distance);
                    break;

                default:
                    continue;
            }

            System.out.printf("%s: %.2f%n",
                    mode, t.totalFare());
        }

        sc.close();
    }
}
