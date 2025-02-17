import java.util.*;

public class grayCode {

    // Function to generate Gray Code sequence
    public static List<Integer> findGrayCode(int n) {
        // Initialize the result list with starting value 0
        List<Integer> result = new ArrayList<>();
        result.add(0);

        // Keeps track of numbers already added to the sequence
        Set<Integer> isPresent = new HashSet<>();
        isPresent.add(0);

        // Start the backtracking process
        solve(0, result, n, isPresent);

        return result;
    }

    // Backtracking function
    public static boolean solve(int current, List<Integer> result, int n, Set<Integer> isPresent) {
        // Base case: if we have generated all 2^n numbers, return true
        if (result.size() == (1 << n)) { // (1 << n) = 2^n
            return true;
        }

        // Try toggling each bit
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i); // Toggle the i-th bit
            if (!isPresent.contains(next)) { // Check if the number is not already in the sequence
                isPresent.add(next);
                result.add(next);

                // Recursive call to continue building the sequence
                if (solve(next, result, n, isPresent)) {
                    return true; // If a valid sequence is found, stop further recursion
                }

                // Backtracking step
                isPresent.remove(next);
                result.remove(result.size() - 1);
            }
        }

        return false; // Return false if no valid sequence can be found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Read number of bits
        List<Integer> grayCodeSequence = findGrayCode(N);

        // Print the generated Gray Code sequence
        System.out.println(grayCodeSequence);
    }
}
