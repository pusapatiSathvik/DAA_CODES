public class GoldMine {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };

        System.out.println("Maximum gold collected: " + getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int maxGold = 0;

        // Iterate over all cells
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    // Start backtracking from this cell
                    maxGold = Math.max(maxGold, collectGold(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    private static int collectGold(int[][] grid, int x, int y) {
        // Base case: Out of bounds or no gold in the cell
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }

        // Collect gold from the current cell
        int gold = grid[x][y];
        grid[x][y] = 0; // Mark the cell as visited

        // Explore all 4 directions
        int up = collectGold(grid, x - 1, y);
        int down = collectGold(grid, x + 1, y);
        int left = collectGold(grid, x, y - 1);
        int right = collectGold(grid, x, y + 1);

        // Restore the cell's gold after backtracking
        grid[x][y] = gold;

        // Return the maximum gold collected from this cell
        return gold + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
