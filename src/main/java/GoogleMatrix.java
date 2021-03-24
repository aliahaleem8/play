import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GoogleMatrix {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] m = { { 1, 2, 3, 4 },
                     { 2, 1, 4, 3 },
                    { 3, 4, 1, 2 },
                    { 4, 3, 2, 1 } };

        int[][] m2 = { { 2, 2, 2, 2 },
                { 2, 3, 2, 3 },
                { 2, 2, 2, 3 },
                { 2, 2, 2, 2 } };

        int[][] m3 = { { 2, 2, 2, 2 },
                { 2, 3, 2, 3 },
                { 2, 2, 2, 3 },
                { 2, 2, 2, 2 } };

        int count = 3; // scanner.nextInt();

        for (int a = 0; a< count ; a++) {
            System.out.print("Case #" + count + ": ");
            generateMatrixVestigiumTrace(m);
        }

    }

    private static void generateMatrixVestigiumTrace(int[][] m) {
        // int[][] m = getMatrixFromInput();
        int n = m.length;
        int sum_r = 0;
        int sum_c = 0;
        int diag_sum = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> hc = new HashMap<Integer, Integer>();
            for (int j = 0; j < n; j++) {
                if (!hc.containsValue(m[i][j]))
                    hc.put(j,m[i][j]);
                else sum_c++;

                if (i == j)
                    diag_sum = diag_sum + m[i][j];
                HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
                if (!hm.containsValue(m[i][j])) {
                    hm.put(i, m[i][j]);
                }
                else
                    sum_r++;

            }
        }
        System.out.println("Diagonal sum: " + diag_sum + ", Repeats row: " + sum_r + ", Repeats col: " + sum_c);
        System.out.println("Case #1: " + diag_sum + " " + sum_r + " " + sum_c);
    }

    private static int[][] getMatrixFromInput() {

      //  int count =  scanner.nextInt();

      //  for (int a = 0; a< count ; a++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                System.out.println(arrRowItems.toString())  ;
                for (int j = 0; j < n; j++) {
                    int arrItem = Integer.parseInt(arrRowItems[j]);
                    System.out.println(arrItem);
                    arr[i][j] = arrItem;
                }
            }

       // }

        scanner.close();
        return arr;
    }
}

/*



Input



3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3

  Output
Case #1: 4 0 0
Case #2: 9 4 4
Case #3: 8 0 2


 */