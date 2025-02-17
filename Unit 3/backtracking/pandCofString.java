import java.util.*;

class pandCofString{

    public static void recursion(ArrayList<String> sol,String s,String op){
        if (op.length()==s.length()) {
            sol.add(op);
            return;

        }
        Set<String> mp = new HashSet<>();
        for(int i=0;i<s.length();i++){
            // Skip characters that have already been used
            if (op.contains(String.valueOf(s.charAt(i)))) {
                continue; // If the character is already in 'op', skip it
            }
            String newop = op + s.charAt(i);
            recursion(sol, s, newop);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> sol = new ArrayList<>();
        String op = "";
        recursion(sol, s,op);

        for(String i : sol){
            System.out.print(i + ", ");
        }
    }
}