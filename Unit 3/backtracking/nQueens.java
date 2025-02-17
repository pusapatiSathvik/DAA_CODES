import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class nQueens {

    public static List<List<String>> findsol(int n) {
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> solboards = new ArrayList<>();
        solve(0, solboards, board, n);
        return solboards;
    }

    public static void solve(int col, List<List<String>> solboards, char[][] board, int n) {
        // Base case: If all queens are placed
        if (col == n) {
            solboards.add(convert(board)); // Convert char[][] to List<String> and store it
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q'; // Place the queen
                solve(col + 1, solboards, board, n); // Recurse for the next column
                board[row][col] = '.'; // Backtrack: Remove the queen
            }
        }
    }

    // Convert char[][] board to List<String>
    public static List<String> convert(char[][] board) {
        List<String> sol = new ArrayList<>();
        for (char[] row : board) {
            sol.add(new String(row));
        }
        return sol;
    }

    // Check if it's safe to place a queen at board[row][col]
    public static boolean isSafe(char[][] board, int row, int col, int n) {
        int i, j;

        // Check the left side of the current row
        for (i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check the lower-left diagonal
        for (i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        List<List<String>> sols = findsol(n);

        // Print the solutions
        System.out.println("Number of solutions: " + sols.size());
        for (List<String> sol : sols) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println(); // Blank line between solutions
        }
        // change representation

        for (List<String> sol : sols) {
            int[] representation = new int[sol.size()]; // Create array of size 'n'
            int r = 0; // Row counter
            for (String s : sol) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'Q') { // Compare character directly
                        representation[i] = r; // Assign row index to column 'i'
                    }
                }
                r++;
            }
            System.out.println(Arrays.toString(representation)); // Print the representation
        }

    }
}
