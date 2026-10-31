
import java.util.Scanner;

abstract class Vehicle {
    abstract double calculateCharge(int hours);
}

class Bike extends Vehicle {
    double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car extends Vehicle {
    double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    double calculateCharge(int hours) {
        return Math.max(hours * 50, 100);
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle v;

            switch (type) {
                case "BIKE":
                    v = new Bike();
                    break;

                case "CAR":
                    v = new Car();
                    break;

                case "TRUCK":
                    v = new Truck();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid vehicle");
            }

            double charge = v.calculateCharge(hours);

            System.out.printf("%s: %.2f%n", type, charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
