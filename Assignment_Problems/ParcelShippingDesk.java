
import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double charge();
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class Fragile extends Standard implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    @Override
    double charge() {
        return super.charge() + 50;
    }

    public double insurance() {
        return value * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();

            Parcel p;

            switch (type) {
                case "STANDARD":
                    p = new Standard(w, v);
                    break;
                case "EXPRESS":
                    p = new Express(w, v);
                    break;
                case "FRAGILE":
                    p = new Fragile(w, v);
                    break;
                default:
                    continue;
            }

            double charge = p.charge();
            double insurance = 0;

            if (p instanceof Insurable) {
                insurance = ((Insurable) p).insurance();
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
