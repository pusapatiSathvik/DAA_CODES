import java.util.*;

class CountCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length <= 1 || grid[0].length <= 1) {
            return 0;
        }

        int ans = 0;
        int nrows = grid.length, ncols = grid[0].length;

        // Loop through pairs of rows
        for (int i = 0; i < nrows; i++) {
            for (int j = i + 1; j < nrows; j++) {
                int counter = 0;

                // Check each column for pairs of 1s in both rows
                for (int k = 0; k < ncols; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        ans += counter++;
                        System.out.println("i " + i + " j " + j + " k " + k + " ans " + ans + " counter " + counter);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];
        
        // Read the grid values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        // Print the count of corner rectangles
        System.out.println(new CountCornerRectangles().countCornerRectangles(grid));
    }
}
