import java.util.*;

public class sudokuSolver {

    public static boolean solveSudoku(char[][] board) {
        return solve(0, 0, board);
    }

    private static boolean solve(int row, int col, char[][] board) {
        // If we reach the last row and column, the board is solved
        if (row == 9) {
            return true;
        }

        // Move to the next row if we are at the end of the current row
        if (col == 9) {
            return solve(row + 1, 0, board);
        }

        // If the cell is already filled, move to the next cell
        if (board[row][col] != '.') {
            return solve(row, col + 1, board);
        }

        // Try placing digits 1-9
        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num; // Place the number
                if (solve(row, col + 1, board)) { // Recurse to the next cell
                    return true;
                }
                board[row][col] = '.'; // Backtrack
            }
        }

        return false; // No valid placement
    }

    private static boolean isSafe(char[][] board, int row, int col, char num) {
        // Check the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static List<String> convertBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Original Board:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("\nSolved Board:");
            printBoard(board);
        } else {
            System.out.println("\nNo solution exists!");
        }
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
