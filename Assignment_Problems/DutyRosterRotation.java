
import java.util.Scanner;
import java.util.Arrays;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, int k) {

        int n = names.length;
        k = k % n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        int k = sc.nextInt();

        String[] result = rotateRoster(names, k);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
