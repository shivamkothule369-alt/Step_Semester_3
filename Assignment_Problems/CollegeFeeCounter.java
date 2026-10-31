

import java.util.*;

interface BusUser {
    double TRANSPORT_FEE = 12000;

    default double transportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double totalFee() {
        double total = tuition();

        if (this instanceof BusUser) {
            total += ((BusUser) this).transportFee();
        }

        return total;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    double tuition() {
        return 20000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    s = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = s.totalFee();
            total += fee;

            System.out.printf("%s: %.2f%n", s.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
