
import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, days);
                    break;

                case "DVD":
                    item = new DVD(title, days);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title, days);
                    break;

                default:
                    continue;
            }

            double fine = item.calculateFine();
            total += fine;

            System.out.printf("%s: %.2f%n", item.title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
