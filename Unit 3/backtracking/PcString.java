import java.util.*;
public class PcString {


    private Set<String> sols = new HashSet<>();

    public void findSol(String s){

        if (s==null || s.isEmpty()) {
            System.out.println("null or empty");
            return;
        }
        char[] chars = s.toCharArray();
        backtrack(chars,0);
    }

    public void backtrack(char[] chars,int index){
        if (isSolved(chars,index)) {
            sols.add(new String(chars));
            return;
        }

        for(int i = index; i<chars.length; i++){

            swap(chars,index,i);

            backtrack(chars, index+1);

            swap(chars,index,i);
        }

    }

    public void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public boolean isSolved(char[] chars,int index){
        // if (index == chars.length) {
        //     return true;
        // }
        // return false;

        return index == chars.length;
    }


    public static void main(String args[]){
        PcString obj = new PcString();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        obj.findSol(s);

        for(String i : obj.sols){
            System.out.println(i + " ");
        }

        System.out.println(obj.sols.size());
    }

    
}
