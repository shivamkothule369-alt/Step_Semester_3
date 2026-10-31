
import java.util.Scanner;

public class ExamScoreBandCounter {

    // Find first index where score >= low
    static int lowerBound(int[] scores, int low) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < low) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Find first index where score > high
    static int upperBound(int[] scores, int high) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= high) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        int start = lowerBound(scores, low);
        int end = upperBound(scores, high);

        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));

        sc.close();
    }
}
