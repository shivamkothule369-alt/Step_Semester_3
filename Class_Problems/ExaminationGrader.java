
import java.util.*;
import java.util.regex.*;

abstract class Question {
    String correct, answer;
    int points;

    Question(String correct, String answer, int points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQ extends Question {
    MCQ(String c, String a, int p) {
        super(c, a, p);
    }

    double calculateScore() {
        return correct.equals(answer) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String a, int p) {
        super(c, a, p);
    }

    double calculateScore() {
        return correct.equals(answer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String a, int p) {
        super(c, a, p);
    }

    double calculateScore() {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (answer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) return points * 0.75;
        if (count == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        // Matches quoted fields or unquoted values
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);

            ArrayList<String> data = new ArrayList<>();

            while (matcher.find()) {
                data.add(matcher.group(1) != null
                        ? matcher.group(1) : matcher.group(2));
            }

            String type = data.get(0);
            String correct = data.get(2);
            String answer = data.get(3);
            int points = Integer.parseInt(data.get(4));

            Question q = switch (type) {
                case "MCQ" -> new MCQ(correct, answer, points);
                case "TF" -> new TF(correct, answer, points);
                case "ESSAY" -> new Essay(correct, answer, points);
                default -> throw new IllegalArgumentException();
            };

            double score = q.calculateScore();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
