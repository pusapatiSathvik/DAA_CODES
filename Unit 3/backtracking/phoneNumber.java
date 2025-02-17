import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phoneNumber {
    private static Map<Character, String> map = new HashMap<>();
    
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static List<String> findsol(String s){
        List<String> res = new ArrayList<>();

        if (s.isEmpty()) {
            return res;
        }

        solve(s,0,new StringBuilder(),res);

        return res;
    }

    public static void solve(String s,int index,StringBuilder str,List<String> res){
        if (index == s.length()) {
            res.add(str.toString());
        }

        // choices
        if (index<s.length()) {
            String letters = map.get(s.charAt(index));
    
            for(int i=0;i<letters.length();i++){
                str.append(letters.charAt(i));
                solve(s, index+1, str, res);
                str.deleteCharAt(str.length()-1);
            }
            
        }
    }

    public static void main(String[] args) {
        // Test case 1: digits = "23"
        String digits1 = "23";
        List<String> result1 = findsol(digits1);
        System.out.println("Combinations for '23': " + result1);
    }
}
