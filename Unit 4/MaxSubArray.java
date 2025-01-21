import java.util.*;

class MaxSubArray {
    // Greedy (Kadane's Algorithm)
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i]; // Add the current element
            if (sum > max) 
                max = sum; // Update max if the current sum is greater
            
            if (sum < 0) 
                sum = 0; // Reset sum if it becomes negative
        }

        return max;
    }

    // Dynamic Programming Approach
    public int maxSubArrayDP(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n]; // dp[i] = max subarray ending at index i

        dp[0] = arr[0];
        int max = dp[0]; // Initialize max with the first element

        for (int i = 1; i < n; i++) {
            dp[i] = arr[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0); // Either extend the subarray or start a new one
            max = Math.max(max, dp[i]); // Update the maximum sum
        }

        return max;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];

        for (int i = 0; i < n; i++) 
            ar[i] = sc.nextInt();

        MaxSubArray obj = new MaxSubArray();
        System.out.println(obj.maxSubArray(ar)); // Greedy result
        System.out.println(obj.maxSubArrayDP(ar)); // DP result
    }
}
