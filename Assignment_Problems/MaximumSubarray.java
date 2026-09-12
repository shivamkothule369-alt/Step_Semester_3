import java.util.Scanner;

public class MaximumSubarray {

    static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Decide whether to start new or continue old subarray
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            }
            else {
                currentSum = nums[i];
            }

            // Update maximum sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Maximum Subarray Sum: "
                + maxSubArray(nums));

        sc.close();
    }
}
