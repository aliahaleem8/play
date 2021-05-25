import com.sun.source.tree.AssertTree;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.stream.Collectors.joining;


public class FindNumInList {


    /*
     * Complete the 'findNumber' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        AtomicReference<String> response = new AtomicReference<>("NO");
        if (!arr.isEmpty()) {
            for (Integer a : arr) {
                if (a.intValue() == k) {
                    response.set("YES");
                    break;
                }
            }
        }

        return response.toString();


    }

    public static boolean containsCurses(String s, Set<String> curses){

        System.out.println(curses.toString());
//        boolean result = false;
//        curses.forEach( curse ->
//        {
//            if (s.toLowerCase().contains(curse))
//            {
//                System.out.println( true);
//            }
//
//        });

        for(String curse: curses) {
            System.out.println(curse);
            if (s.toLowerCase().contains(curse))
                return true;
        }
     //   System.out.println(false);

        return false;

    }

    int test_case_number = 1;
        public static void main(String[] args) throws IOException {
            List<Integer> list=Arrays.asList(1, 2, 3);
            System.out.println("NO".equalsIgnoreCase(FindNumInList.findNumber(list, 4)));
            System.out.println("NO".equalsIgnoreCase(FindNumInList.findNumber(list, 0)));
            System.out.println("YES".equalsIgnoreCase(FindNumInList.findNumber(list, 2)));

//            Set<String> hset = CurseWordList.CURSE_WORDS;
//            System.out.println(containsCurses(" alia is cool", hset));
//
//            System.out.println(containsCurses(" alia rooster is cool", hset));


        }



//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//                try {
//                    return bufferedReader.readLine().replaceAll("\\s+$", "");
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            })
//                    .map(String::trim)
//                    .map(Integer::parseInt)
//                    .collect(toList());
//
//            int k = Integer.parseInt(bufferedReader.readLine().trim());
//
//            String result = Result.findNumber(arr, k);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//
//            bufferedReader.close();
//            bufferedWriter.close();
//        }
}

