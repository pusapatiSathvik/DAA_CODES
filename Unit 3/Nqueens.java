
import java.util.Scanner;

public class NQueenProblem {

    // Count variable to store the number of solutions
    private static int solutionCount = 0;

    // Checks if placing a queen at board[row][col] is safe
    private static boolean isSafe(int[][] board, int row, int col, int N) {
        // Check the left side of the current row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive utility to solve the N-Queens problem
    private static void solveNQUtil(int[][] board, int col, int N) {
        if (col == N) { // All queens are placed
            solutionCount++;
            return;
        }

        for (int row = 0; row < N; row++) {
            if (isSafe(board, row, col, N)) {
                board[row][col] = 1; // Place queen
                solveNQUtil(board, col + 1, N); // Recur for next column
                board[row][col] = 0; // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt(); // Input the size of the board
        int[][] board = new int[N][N]; // Initialize the board

        solutionCount = 0; // Reset solution count
        solveNQUtil(board, 0, N); // Find all solutions

        System.out.println("Number of possible solutions: " + solutionCount);
    }
}