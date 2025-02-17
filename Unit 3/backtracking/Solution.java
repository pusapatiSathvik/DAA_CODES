import java.util.*;

public class Solution {

    // Recursive function to solve the problem
    public void solve(StringBuilder str, int k, int start, StringBuilder ans) {
        if (k == 0 || start == str.length() - 1) {
            return;
        }

        // Find the maximum character in the substring starting from 'start'
        char maxChar = getMaxChar(str, start);

        // Try swapping each character with the current start position
        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(start) < str.charAt(i) && str.charAt(i) == maxChar) {
                // Swap the characters
                swap(str, start, i);

                // Update the answer if the current string is greater
                if (str.toString().compareTo(ans.toString()) > 0) {
                    ans.setLength(0);  // Clear the previous value of ans
                    ans.append(str);   // Set the new maximum string
                }

                // Recur for the remaining swaps
                solve(str, k - 1, start + 1, ans);

                // Backtrack by swapping the characters back
                swap(str, start, i);
            }
        }

        // Try solving the problem without swapping the current position
        solve(str, k, start + 1, ans);
    }

    // Helper function to get the maximum character in the substring starting from index 'start'
    private char getMaxChar(StringBuilder str, int start) {
        char maxChar = str.charAt(start);
        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(i) > maxChar) {
                maxChar = str.charAt(i);
            }
        }
        return maxChar;
    }

    // Helper function to swap two characters in the StringBuilder
    private void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    // Function to find the largest number after k swaps
    public String findMaximumNum(String str, int k) {
        StringBuilder ans = new StringBuilder(str);  // To store the largest number
        StringBuilder strBuilder = new StringBuilder(str);  // Mutable string
        solve(strBuilder, k, 0, ans);
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "1234567";  // Example input
        int k = 4;  // Example number of swaps
        String result = solution.findMaximumNum(str, k);
        System.out.println("Largest number after " + k + " swaps: " + result);
    }
}
