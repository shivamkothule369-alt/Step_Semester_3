class PasswordChecker {

    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {

        int length = password.length();

        if (length < 6) {
            return "Weak";
        } 
        else if (length <= 9) {
            return "Medium";
        } 
        else {
            return "Strong";
        }
    }
}

public class PasswordTest {
    public static void main(String[] args) {

        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println(pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println(pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghijkl");
        System.out.println(pc3.getStrength());
    }
}
