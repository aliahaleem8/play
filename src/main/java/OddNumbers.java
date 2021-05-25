import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;


class OddNumbers {

    /*
     * Complete the 'oddNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static List<Integer> oddNumbers(int l, int r) {
        // Write your code here
        List<Integer> oddNumList = new ArrayList<>();

        // bad inputs : return empty list to not crash
        if ((l> r)||(l<1)||(r<1))
            return Collections.emptyList();

        if (l==r)
        {   if ((l%2)!=0){
            oddNumList.add(l);
            return oddNumList;
        }
        else
            return Collections.emptyList();
        }

        // l < r
        int start = l;
        if ((l%2)==0){
            //if left most number is even, iterate + 1 other one and add to list
            start = l+1;
        }
        while (start <= r){
            oddNumList.add(start);
            start+=2;
        }
        return oddNumList;


    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = OddNumbers.oddNumbers(l, r);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}