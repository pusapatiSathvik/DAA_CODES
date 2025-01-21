import java.util.*;

public class Knapsack01 {
    // Recursive Approach
    public int knapsackRecur(int[] weight, int[] profit, int W, int n) {
        if (n == 0 || W == 0) {
            return 0; // Base case: no items or no capacity
        }

        if (weight[n - 1] > W) {
            // If the weight of the current item exceeds capacity, skip it
            return knapsackRecur(weight, profit, W, n - 1);
        } else {
            // Include or exclude the item and take the maximum
            return Math.max(
                profit[n - 1] + knapsackRecur(weight, profit, W - weight[n - 1], n - 1),
                knapsackRecur(weight, profit, W, n - 1)
            );
        }
    }

    // Top-down Approach with Memoization
    public int knapsackMemo(int[] weight, int[] profit, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0; // Base case
        }

        if (dp[n][W] != -1) {
            return dp[n][W]; // Return cached result
        }

        if (weight[n - 1] > W) {
            dp[n][W] = knapsackMemo(weight, profit, W, n - 1, dp); // Skip current item
        } else {
            dp[n][W] = Math.max(
                profit[n - 1] + knapsackMemo(weight, profit, W - weight[n - 1], n - 1, dp),
                knapsackMemo(weight, profit, W, n - 1, dp)
            );
        }

        return dp[n][W];
    }

    // Bottom-up Approach with Tabulation
    public int knapsackTabulation(int[] weight, int[] profit, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    // Optimized Space Complexity
    public int knapsackSpaceOptimized(int[] weight, int[] profit, int W, int n) {
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], profit[i] + dp[w - weight[i]]);
            }
        }

        return dp[W];
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        System.out.print("Enter the weights of the items: ");
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.print("Enter the profits of the items: ");
        int[] profit = new int[n];
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        System.out.print("Enter the maximum capacity of the bag: ");
        int W = sc.nextInt();

        Knapsack01 ks = new Knapsack01();

        System.out.println("Recursive Approach: " + ks.knapsackRecur(weight, profit, W, n));

        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println("Memoized Approach: " + ks.knapsackMemo(weight, profit, W, n, dp));

        System.out.println("Tabulation Approach: " + ks.knapsackTabulation(weight, profit, W, n));

        System.out.println("Space-Optimized Approach: " + ks.knapsackSpaceOptimized(weight, profit, W, n));
    }
}
