import java.util.*;

class MinCostClimbingStairs {
    // Recursive approach
    public int minCostRecur(int n, int[] cost) {
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    // Top-down approach with Memoization
    public int minCostMemoized(int n, int[] cost, int[] dp) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        if (dp[n] != -1) return dp[n];
        return dp[n] = cost[n] + Math.min(minCostMemoized(n - 1, cost, dp), minCostMemoized(n - 2, cost, dp));
    }

    public int minimumCost(int n, int[] cost) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize memoization array
        return Math.min(minCostMemoized(n - 1, cost, dp), minCostMemoized(n - 2, cost, dp));
    }

    // Bottom-up approach with Tabulation
    public int minCostDP(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    // Optimized Space Complexity
    public int minCostOptimized(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);

        int first = cost[0];
        int second = cost[1];
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        return Math.min(first, second);
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of stairs: ");
        int n = sc.nextInt();
        int[] ar = new int[n];
        System.out.print("Enter the cost array: ");
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();

        MinCostClimbingStairs mc = new MinCostClimbingStairs();
        System.out.println("Recursive approach: " + mc.minCostRecur(n, ar));
        System.out.println("Top-down (Memoization): " + mc.minimumCost(n, ar));
        System.out.println("Bottom-up (Tabulation): " + mc.minCostDP(ar));
        System.out.println("Optimized approach: " + mc.minCostOptimized(ar));
    }
}
