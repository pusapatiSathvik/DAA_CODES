import java.util.*;

class MatrixChainMultiplication_top {

    // Recursive function to calculate the minimum cost
    private int matrixChainMemo(int[] dims, int i, int j, int[][] dp) {
        // Base case: single matrix or invalid range
        if (i == j) {
            return 0;
        }

        // If the result is already computed, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = Integer.MAX_VALUE;

        // Try all possible splits and take the minimum
        for (int k = i; k < j; k++) {
            int cost = matrixChainMemo(dims, i, k, dp) +
                       matrixChainMemo(dims, k + 1, j, dp) +
                       dims[i - 1] * dims[k] * dims[j];

            dp[i][j] = Math.min(dp[i][j], cost);
        }

        return dp[i][j];
    }

    public int matrixChainOrder(int[] dims) {
        int n = dims.length;
        int[][] dp = new int[n][n]; // Memoization table

        // Initialize the memoization table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive function
        return matrixChainMemo(dims, 1, n - 1, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of matrices:");
        int n = sc.nextInt(); // Number of matrices

        int[] dims = new int[n + 1]; // Dimensions of the matrices

        System.out.println("Enter the dimensions:");
        for (int i = 0; i <= n; i++) {
            dims[i] = sc.nextInt();
        }

        MatrixChainMultiplication_top obj = new MatrixChainMultiplication_top();
        int minCost = obj.matrixChainOrder(dims);

        System.out.println("Minimum cost of matrix chain multiplication: " + minCost);
    }
}
