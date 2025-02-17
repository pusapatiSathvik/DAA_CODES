import java.util.Scanner;

public class kSwaps {

    public static String findsol(String s,int keys){
        if (s == null || s.isEmpty()) {
            return "0";
        }
        StringBuilder ans = new StringBuilder(s);
        StringBuilder str = new StringBuilder(s);
        solve(str,keys,0,ans);
        return ans.toString();

    }

    public static void solve(StringBuilder str,int k,int start,StringBuilder ans){
        // base case
        if (k==0 || start == str.length()) {
            return;
        }

        char maxchar = getMaxChar(str,start);

        for(int i=start+1;i<str.length();i++){

            if (str.charAt(start) < str.charAt(i) && str.charAt(i) == maxchar) {

                swap(str,start,i);

                if (str.toString().compareTo(ans.toString()) > 0) {
                    ans.setLength(0);
                    ans.append(str);
                }

                solve(str, k-1, start+1, ans);

                swap(str,start,i);
            }
        }
        solve(str, k, start+1, ans);
    }



    public  static void swap(StringBuilder str,int start,int i){
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(start));
        str.setCharAt(start, temp);
    }

    public static char getMaxChar(StringBuilder str,int start){
        char max = str.charAt(start);
        for(int i=start+1;i<str.length();i++){
            if (str.charAt(i) > max) {
                max =str.charAt(i);
            }
        }
        return max;
    }


    public static void main(String args[]){
        // kSwaps obj = new PcString();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();

        String ans = findsol(s,k);

        if (ans == "0") {
            System.out.println("not valid");
        }else{
            System.out.println(ans);
        }
    }
    
}
