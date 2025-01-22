import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        String word = "pep";
        List<String> abbreviations = generateAbbreviations(word);

        // Print the results
        for (String abbreviation : abbreviations) {
            System.out.println(abbreviation);
        }
    }

    public static List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(word, 0, "", 0, result);
        return result;
    }

    private static void backtrack(String word, int pos, String current, 
                                  int count, List<String> result) {
        // Base case: If we reach the end of the word
        if (pos == word.length()) {
            // Append the remaining count (if any) to the result
            if (count > 0) {
                current += count;
            }
            result.add(current);
            return;
        }

        // Case 1: Abbreviate the current character (increment count)
        backtrack(word, pos + 1, current, count + 1, result);

        // Case 2: Include the current character (append the count first if > 0)
        backtrack(word, pos + 1, current + (count > 0 ? count : "") + 
                  word.charAt(pos), 0, result);
    }
}
