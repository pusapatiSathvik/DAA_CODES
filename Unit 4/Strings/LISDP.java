package Strings;

import java.util.Arrays;
import java.util.Scanner;

class LISdp {
    public int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];  // DP array to store the length of LIS ending at each index
        int longest = 0;

        Arrays.fill(dp, 1);  // Initialize all entries to 1 as each element is an LIS of length 1 by itself

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {  // If nums[i] can be appended to the LIS ending at nums[j]
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // Update dp[i] to the maximum possible LIS length
                }
            }
            longest = Math.max(longest, dp[i]);  // Track the overall longest LIS found so far
        }

        System.out.println(Arrays.toString(dp));  // Optional: Print the dp array to see intermediate results
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Read the number of elements
        int ar[] = new int[n];  // Array to store the input elements
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();  // Read each element into the array
        }

        System.out.println(new LISdp().lengthOfLISDP(ar));  // Call the method to compute the LIS and print the result
    }
}
