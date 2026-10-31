
import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    abstract int getDays();

    LocalDate calculateDueDate(LocalDate date) {
        return date.plusDays(getDays());
    }
}

class Book extends LibraryItem {
    int getDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    int getDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    int getDays() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LocalDate today = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            // Remove surrounding quotation marks
            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = switch (type) {
                case "BOOK" -> new Book();
                case "DVD" -> new DVD();
                case "MAGAZINE" -> new Magazine();
                default -> throw new IllegalArgumentException();
            };

            System.out.println(title + ": " +
                    item.calculateDueDate(today));
        }

        sc.close();
    }
}
