import java.util.Scanner;

public class TSPDynamicProgramming {

    static final int INF = Integer.MAX_VALUE / 2; // To avoid overflow during addition
    static int n; // Number of cities
    static int[][] distance; // Distance matrix
    static int[][] dp; // DP table

    // Function to solve TSP using DP with bitmasking
    public static int tsp(int mask, int pos) {
        // If all cities are visited, return distance to start city (city 0)
        if (mask == (1 << n) - 1) {
            return distance[pos][0];
        }

        // If already computed, return the stored value
        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int minCost = INF;

        // Try visiting all unvisited cities
        for (int city = 0; city < n; city++) {
            // Check if city is unvisited in the current mask
            if ((mask & (1 << city)) == 0) {
                // Calculate cost of visiting this city
                int newCost = distance[pos][city] + tsp(mask | (1 << city), city);
                minCost = Math.min(minCost, newCost);
            }
        }

        // Store the result in dp table and return it
        dp[mask][pos] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of cities
        System.out.print("Enter the number of cities: ");
        n = sc.nextInt();

        // Input the distance matrix
        distance = new int[n][n];
        System.out.println("Enter the distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = sc.nextInt();
            }
        }

        // Initialize dp table with -1
        dp = new int[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // Solve the TSP and print the result
        int result = tsp(1, 0); // Start with city 0 and mask = 1 (only city 0 visited)
        System.out.println("The minimum cost of the tour is: " + result);
    }
}
