public class digits {
    public static void main(String[] args) {
        int n =2;
        String sol = "";

        solve(n,sol);
    }
    public static void solve(int n,String s){
        if (s.length() == n) {
            System.out.println(s);
            return;
        }
        if (s.isEmpty()) {
            for(int digit = 0;digit<=9;digit++){
                solve(n, s+digit);
            }
        }else{
            int ld = s.charAt(s.length()-1) - '0';

            for(int i = ld+1;i<=9;i++){
                solve(n, s+i);
            }
        }
    }
}
