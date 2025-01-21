import java.util.*;

class MatrixChainMultiplication {

    // Function to compute the minimum cost of matrix chain multiplication
    public int matrixChainOrder(int[] dims) {
        int n = dims.length; // Number of matrices = n - 1
        int[][] dp = new int[n][n]; // dp[i][j] will hold the minimum cost to multiply matrices A[i] to A[j]

        // Initialize the diagonal elements of dp as 0
        // A single matrix has no multiplication cost
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Length of the chain being considered
        for (int length = 2; length < n; length++) {
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1; // End of the chain
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible splits of the chain
                for (int k = i; k < j; k++) {
                    // Cost of multiplying A[i..k] and A[k+1..j] + cost of multiplying the resulting matrices
                    int cost = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];

                    // Update the minimum cost
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // Minimum cost to multiply matrices from A[1] to A[n-1]
        return dp[1][n - 1];
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

        MatrixChainMultiplication obj = new MatrixChainMultiplication();
        int minCost = obj.matrixChainOrder(dims);

        System.out.println("Minimum cost of matrix chain multiplication: " + minCost);
    }
}
