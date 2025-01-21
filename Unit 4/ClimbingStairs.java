import java.util.Scanner;

public class ClimbingStairs {

    // Recursive implementation
    public int climbStairsRecur(int n) {
        if (n <= 2) return n;
        return climbStairsRecur(n - 1) + climbStairsRecur(n - 2);
    }

    // Top-down approach - Memoization
    public int climbStairsMem(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1]; // Create a memoization array
        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n <= 2) return n; // Base case
        if (dp[n] != 0) return dp[n]; // Return cached result if available
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp); // Compute and cache result
        return dp[n];
    }

    // Bottom-up approach - Tabulation
    public int climbStairsTab(int n) {
        if (n <= 2) return n; // Base cases
        int[] dp = new int[n + 1]; // Create a dp array
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Compute dp[i]
        }
        return dp[n];
    }

    // Space-optimized bottom-up approach
    public int climbStairsOptimized(int n) {
        if (n <= 2) return n; // Base cases
        int first = 1, second = 2; // Initialize for the first two steps
        for (int i = 3; i <= n; i++) {
            int current = first + second; // Compute the current step
            first = second; // Update first to the previous second
            second = current; // Update second to the current step
        }
        return second;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of stairs: ");
        int n = sc.nextInt();

        ClimbingStairs cs = new ClimbingStairs();

        System.out.println("Recursive approach: " + cs.climbStairsRecur(n));
        System.out.println("Top-down (Memoization): " + cs.climbStairsMem(n));
        System.out.println("Bottom-up (Tabulation): " + cs.climbStairsTab(n));
        System.out.println("Optimized approach: " + cs.climbStairsOptimized(n));
    }
}
