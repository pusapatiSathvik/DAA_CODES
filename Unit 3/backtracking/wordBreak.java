import java.util.*;

public class wordBreak {

    // List to store all valid sentences
    private static List<String> solutions = new ArrayList<>();

    // Function to perform backtracking and find all valid sentences
    private static void solve(String s, int index, Set<String> dict, List<String> current) {
        // Base case: If we reach the end of the string, join the current words and add to solutions
        if (index == s.length()) {
            solutions.add(String.join(" ", current));
            return;
        }

        // Explore all possible substrings starting from the current index
        for (int i = index + 1; i <= s.length(); i++) {
            String word = s.substring(index, i);
            if (dict.contains(word)) {
                current.add(word);  // Add the current word to the list
                solve(s, i, dict, current);  // Recur for the remaining substring
                current.remove(current.size() - 1);  // Backtrack
            }
        }
    }

    // Function to find all possible sentences formed by words in the dictionary
    public static List<String> wordBreak(String s, List<String> dictList) {
        solutions.clear();  // Clear previous results
        Set<String> dict = new HashSet<>(dictList);  // Convert list to set for faster lookups
        solve(s, 0, dict, new ArrayList<>());  // Start solving from index 0
        return solutions;
    }

    public static void main(String[] args) {
        // Test case: s = "catsanddog", dict = ["cats", "cat", "and", "sand", "dog"]
        String s = "catsanddog";
        List<String> dictList = Arrays.asList("cats", "cat", "and", "sand", "dog");
        List<String> result = wordBreak(s, dictList);

        System.out.println("Possible sentences:");
        for (String sentence : result) {
            System.out.println(sentence);
        }
    }
}
