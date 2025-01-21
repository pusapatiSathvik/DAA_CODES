import java.util.Scanner;

class OBSTDP {
    public int minSearchCostBST(int[] keys, int[] freq, int n) {
        int[][] cost = new int[n][n];

        // Base case: Single key cost is its frequency
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        // Fill the table for ranges of increasing size
        for (int len = 2; len <= n; len++) { // len is the range size
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Calculate sum of frequencies for range [i...j]
                int freqSum = 0;
                for (int k = i; k <= j; k++) {
                    freqSum += freq[k];
                }

                // Try every key as root and calculate cost
                for (int r = i; r <= j; r++) {
                    int leftCost = (r > i) ? cost[i][r - 1] : 0;
                    int rightCost = (r < j) ? cost[r + 1][j] : 0;
                    int totalCost = leftCost + rightCost + freqSum;

                    cost[i][j] = Math.min(cost[i][j], totalCost);
                }
            }
        }

        return cost[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++) keys[i] = sc.nextInt();
        for (int i = 0; i < n; i++) freq[i] = sc.nextInt();

        OBSTDP obst = new OBSTDP();
        System.out.println(obst.minSearchCostBST(keys, freq, n));
    }
}
