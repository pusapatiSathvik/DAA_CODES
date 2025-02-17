import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartition {

    // List to store all possible palindrome partitions
    private static List<List<String>> solutions = new ArrayList<>();

    // Function to check if a given string is a palindrome
    private static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive function to find all palindrome partitions
    private static void solve(String s, int index, List<String> current) {
        // Base case: If we reach the end of the string, add the current partition to solutions
        if (index == s.length()) {
            solutions.add(new ArrayList<>(current));
            return;
        }

        // Explore all substrings starting from the current index
        for (int i = index; i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            if (isPalindrome(substring)) {
                current.add(substring); // Add the substring to the current partition
                solve(s, i + 1, current); // Recur for the remaining substring
                current.remove(current.size() - 1); // Backtrack to explore other partitions
            }
        }
    }

    // Function to find and print all palindrome partitions of the string
    public static void findPalindromePartitions(String s) {
        solutions.clear(); // Clear previous results
        solve(s, 0, new ArrayList<>()); // Start solving from index 0 with an empty partition
        System.out.println("Palindrome Partitions:");
        for (List<String> partition : solutions) {
            System.out.println(partition);
        }
    }

    // Main method to read input and find solutions
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        findPalindromePartitions(s);
        sc.close();
    }
}
