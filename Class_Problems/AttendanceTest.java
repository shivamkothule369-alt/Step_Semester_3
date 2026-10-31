class AttendanceSheet {

    private String[] students;
    private int count;

    AttendanceSheet(int size) {
        students = new String[size];
        count = 0;
    }

    public void markPresent(String name) {

        // Check duplicate
        if (isPresent(name)) {
            return;
        }

        // Add student
        if (count < students.length) {
            students[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {

        for (int i = 0; i < count; i++) {

            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class AttendanceTest {
    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " +
                           sheet.getPresentCount());

        System.out.println("Ben present: " +
                           sheet.isPresent("Ben"));

        System.out.println("Chen present: " +
                           sheet.isPresent("Chen"));
    }
}