import java.util.Arrays;

public class L5 {

    static int[] rotateArray(int[] nums, int k) {

        // Reduce k if it is greater than array length
        k = k % nums.length;

        int[] newArray = new int[nums.length];

        // Calculate new position of every element
        for (int i = 0; i < nums.length; i++) {

            int newIndex = (i + k) % nums.length;

            newArray[newIndex] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(result));
    }
}