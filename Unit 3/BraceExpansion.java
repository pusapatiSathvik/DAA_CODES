import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BraceExpansion {
    public static void main(String[] args) {
        String expression = "{a,b}c{d,e}f";
        List<String> result = expand(expression);
        System.out.println(result); // Output: [acdf, acef, bcdf, bcef]
    }

    public static List<String> expand(String expression) {
        // Parse the expression into groups
        List<List<String>> groups = parseExpression(expression);

        // List to store the final combinations
        List<String> result = new ArrayList<>();

        // Backtrack to generate all combinations
        backtrack(groups, 0, new StringBuilder(), result);

        // Sort the result lexicographically
        Collections.sort(result);

        return result;
    }

    private static List<List<String>> parseExpression(String expression) {
        List<List<String>> groups = new ArrayList<>();
        int i = 0;

        while (i < expression.length()) {
            if (expression.charAt(i) == '{') {
                // Parse a group inside braces
                int j = i + 1;
                while (j < expression.length() && expression.charAt(j) != '}') {
                    j++;
                }
                String group = expression.substring(i + 1, j);
                String[] options = group.split(",");
                List<String> groupList = new ArrayList<>();
                for (String option : options) {
                    groupList.add(option);
                }
                groups.add(groupList);
                i = j + 1; // Move past the closing brace
            } else {
                // Parse a single character
                groups.add(List.of(String.valueOf(expression.charAt(i))));
                i++;
            }
        }

        return groups;
    }

    private static void backtrack(List<List<String>> groups, int index, StringBuilder current, List<String> result) {
        if (index == groups.size()) {
            // Base case: All groups processed
            result.add(current.toString());
            return;
        }

        // Recursive case: Add one option from the current group
        for (String option : groups.get(index)) {
            current.append(option);
            backtrack(groups, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
