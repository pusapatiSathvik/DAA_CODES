package Strings;

class LRS {
    public int longestRepeatingSubstring(String s) {
        int n = s.length();  // Length of the input string
        // Iterate over possible lengths of substrings starting from (n-1) to 1
        for (int len = (n - 1); len >= 1; len--) {
            HashSet<String> set = new HashSet<>();  // To store seen substrings
            // Generate substrings of the current length 'len'
            for (int i = 0; i <= (n - len); i++) {
                String subs = s.substring(i, i + len);  // Get substring starting at index i
                System.out.println(subs);  // Debug: Print the current substring
                if (set.contains(subs)) {  // If the substring has been seen before
                    return len;  // Return the length of the repeating substring
                }
                set.add(subs);  // Add the current substring to the set
            }
        }
        return 0;  // Return 0 if no repeating substring is found
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);  // Input scanner
        String s = sc.next();  // Read input string
        System.out.println(new LRS().longestRepeatingSubstring(s));  // Print result
    }
}
