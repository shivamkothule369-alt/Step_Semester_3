
import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {

    abstract LocalDate renewalDate(LocalDate start);
}

class Basic extends Plan {

    LocalDate renewalDate(LocalDate start) {
        return start.plusDays(30);
    }
}

class Standard extends Plan {

    LocalDate renewalDate(LocalDate start) {
        return start.plusDays(90);
    }
}

class Premium extends Plan {

    LocalDate renewalDate(LocalDate start) {
        return start.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            LocalDate start = LocalDate.parse(sc.next());

            Plan p;

            switch (type) {
                case "BASIC":
                    p = new Basic();
                    break;

                case "STANDARD":
                    p = new Standard();
                    break;

                case "PREMIUM":
                    p = new Premium();
                    break;

                default:
                    throw new IllegalArgumentException("Invalid plan");
            }

            LocalDate renewal = p.renewalDate(start);

            System.out.println(name + ": " + renewal);
        }

        sc.close();
    }
}
