package Strings;

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String s, String abbr) {
        int i = 0, j = 0;
        int n = s.length(), m = abbr.length();
        
        while (i < n && j < m) {
            if (Character.isDigit(abbr.charAt(j))) {
                // Skip leading zeros in numbers
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                
                // Extract the full number from the abbreviation
                int num = 0;
                while (j < m && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                
                // Skip the characters in s corresponding to the number
                i += num;
            } else {
                // If characters match, move both pointers
                if (s.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        
        // If both pointers have reached the end, it is a valid abbreviation
        return i == n && j == m;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation obj = new ValidWordAbbreviation();
        
        // Test cases
        System.out.println(obj.validWordAbbreviation("internationalization", "i12iz4n"));  // true
        System.out.println(obj.validWordAbbreviation("apple", "a2e"));  // false
    }
}
