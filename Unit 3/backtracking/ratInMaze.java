import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ratInMaze {

    private static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private static char[] moves = {'L', 'U', 'R', 'D'};

    public static List<String> findsol(int[][] arr, int n) {
        List<String> paths = new ArrayList<>();
        if (arr[0][0] == 0 || arr[n - 1][n - 1] == 0) {
            // System.out.println("No paths");
            return paths;
        }
        StringBuilder path = new StringBuilder();
        solve(0, 0, path, arr, n, paths);

        // Sort the paths lexicographically before returning
        Collections.sort(paths);
        return paths;
    }

    public static void solve(int rx, int ry, StringBuilder path, int[][] arr, int n, List<String> paths) {
        // Base condition: If it reaches the bottom-right corner
        if (rx == n - 1 && ry == n - 1) {
            paths.add(path.toString());
            return;
        }

        // Mark the current cell as visited
        arr[rx][ry] = 0;

        // Explore all possible moves (Left, Up, Right, Down)
        for (int i = 0; i < 4; i++) {
            int newr = rx + dir[i][0]; // Calculate the new row
            int newc = ry + dir[i][1]; // Calculate the new column

            // Check if the new position is valid and not visited
            if (newr >= 0 && newr < n && newc >= 0 && newc < n && arr[newr][newc] == 1) {
                // Append the move to the path
                path.append(moves[i]);

                // Recur to explore the next cell
                solve(newr, newc, path, arr, n, paths);

                // Backtrack: Remove the last move
                path.deleteCharAt(path.length() - 1);
            }
        }

        // Revert the current cell back to unvisited
        arr[rx][ry] = 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) { // Row loop
            for (int j = 0; j < n; j++) { // Column loop
                arr[i][j] = sc.nextInt();
            }
        }

        List<String> paths = findsol(arr, n);

        if (paths.isEmpty()) {
            System.out.println("No paths found");
        } else {
            System.out.println("Possible paths:");
            for (String i : paths) {
                System.out.println(i);
            }
        }
    }
}
