public class FirstNonRepeating {

    static char findFirstNonRepeatingChar(String text) {

        int[] frequency = new int[256];

        // Count frequency
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Find first character occurring once
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        String text = "swiss";

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                "First Non-Repeating Character: '" +
                result + "'"
            );
        }
    }
}
