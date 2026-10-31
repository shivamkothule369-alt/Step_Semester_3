class Locker {

    private final int lockerNumber;
    private String code;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public void changeCode(String currentCode, String newCode) {

        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Wrong current code");
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerTest {
    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");

        l.changeCode("0000", "9999");
    }
}