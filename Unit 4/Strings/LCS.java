package Strings;

import java.util.Arrays;
import java.util.Scanner;

class LCSdp {
    /* Time Complexity: O(m * n) Space Complexity: O(m * n) */
    public static int lcs(String text1, String text2) {
        int[] dp = new int[text2.length() + 1]; // 1D DP array to store the result of subproblems
        
        for (int i = 0; i < text1.length(); i++) {
            int prev = dp[0]; // Save the previous diagonal element (dp[i-1][j-1])
            
            for (int j = 1; j < dp.length; j++) {
                int temp = dp[j]; // Save the current value of dp[j]
                
                if (text1.charAt(i) != text2.charAt(j - 1)) {
                    dp[j] = Math.max(dp[j - 1], dp[j]); // Take the maximum of the left or above cell
                } else {
                    dp[j] = prev + 1; // If characters match, extend the subsequence
                }
                
                prev = temp; // Update prev for the next iteration
            }
            
            System.out.println(Arrays.toString(dp)); // Debugging: print DP array after each row
        }
        
        return dp[dp.length - 1]; // The result is stored in dp[text2.length()]
    }

    public static void main(String args[]) {
        // Test case: 
        // text1 = "abcde", text2 = "adobe"
        // Expected LCS = "abe"
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(new LCSdp().lcs(s1, s2)); // Output the result
    }
}
