import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrayCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        List<Integer> result = generateGrayCode(n);
        System.out.println("Gray Code Sequence for n = " + n + ": " + result);
        sc.close();
    }

    public static List<Integer> generateGrayCode(int n) {
        List<Integer> grayCode = new ArrayList<>();
        grayCode.add(0); // Base case: 0-bit Gray Code

        for (int i = 0; i < n; i++) {
            int size = grayCode.size();
            // Reflect the current sequence
            for (int j = size - 1; j >= 0; j--) {
                grayCode.add(grayCode.get(j) | (1 << i));
            }
        }

        return grayCode;
    }
}
