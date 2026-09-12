import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveRankingEngine
        implements Comparable<PlacementDriveRankingEngine> {

    // Encapsulated variables
    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public PlacementDriveRankingEngine(
            String name,
            double cgpa,
            int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Overloaded method 1
    static boolean isEligible(double cgpa) {

        return cgpa >= 7.0;
    }

    // Overloaded method 2
    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Calculate composite score
    private double getCompositeScore() {

        return cgpa * 10 + codingScore * 0.5;
    }

    // Sort by composite score in descending order
    @Override
    public int compareTo(PlacementDriveRankingEngine other) {

        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    static String shortlistAndRank(
            PlacementDriveRankingEngine[] candidates) {

        PlacementDriveRankingEngine[] shortlisted =
                new PlacementDriveRankingEngine[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            boolean eligible;

            // First check CGPA-only rule
            if (isEligible(candidates[i].cgpa)) {

                eligible = true;

            } else {

                // Borderline candidates
                eligible = isEligible(
                        candidates[i].cgpa,
                        candidates[i].codingScore
                );
            }

            if (eligible) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        // Remove unused positions
        shortlisted = Arrays.copyOf(shortlisted, count);

        // Sort using compareTo()
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result = result
                    + (i + 1)
                    + ". "
                    + shortlisted[i].name
                    + " ("
                    + shortlisted[i].getCompositeScore()
                    + ")";

            if (i < shortlisted.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        sc.nextLine();

        PlacementDriveRankingEngine[] candidates =
                new PlacementDriveRankingEngine[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();

            sc.nextLine();

            candidates[i] =
                    new PlacementDriveRankingEngine(
                            name,
                            cgpa,
                            codingScore
                    );
        }

        System.out.println("\nShortlisted Candidates:");

        System.out.println(
                shortlistAndRank(candidates)
        );

        sc.close();
    }
}