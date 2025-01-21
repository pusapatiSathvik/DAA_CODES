package Strings;

import java.util.Scanner;

class CountSubstrings {
    public int countLetters(String s) {
        int sum = 1;  // Initialize with 1 to count the first character's substring
        int count = 1;  // Initialize the count for the first character
        
        // Start loop from index 1 as we are comparing characters i and i-1
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // If current and previous characters are the same, increment count
                count++;
            } else {
                // If different, reset count to 1 for the new character
                count = 1;
            }
            
            // Add the count of substrings for the current sequence of identical characters
            sum += count;
        }
        
        return sum;  // Return the total count of valid substrings
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();  // Input the string from the user
        System.out.println(new CountSubstrings().countLetters(s));  // Print the result
        sc.close();  // Close the scanner resource
    }
}
