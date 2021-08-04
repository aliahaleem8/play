

import java.io.*;
        import java.util.*;
// Add any extra import statements you may need here


public class FB_2C_MinLenSubStrings_Strings {

    // Add any helper functions you may need here
//
//[dcbefebce]
//            [fd]
//
//            1. d  (any of fd belongs? & !end of s1? &!end of s2) yes --> min = currentIndex (0)
//    2. c (any of remaining f belongs? ) no
//    3.  b
//    4. e ef
//    5. f ... yes  --> max = currentIndex (5)

    int minLengthSubstring(String s, String t) {
        // Write your code here

        int nS = 0;
        int min = -1;
        int max = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i<t.length(); i++){
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i))+1);
              //  System.out.println(t.charAt(i) + ", " + map.get(t.charAt(i)));
            }
            else  map.put(t.charAt(i), 1);
        }
        int newMin=s.length()+1;
        while( (!map.isEmpty()) && nS<s.length()){
            if (map.containsKey(s.charAt(nS))){
                if (min<0) {
                    min = nS;
                } else {
                    max = nS;
                }
                if(map.get(s.charAt(nS))>1)
                    map.put(t.charAt(nS), map.get(t.charAt(nS))-1);
                else if (map.containsKey(s.charAt(nS))) {
                    map.remove(s.charAt(nS));
                }
                //else do nothing.. have too many characters of this letter
            }
            else if (min>0)
                newMin = minLengthSubstring(s.substring(nS), t);

            nS++;
        }

        min = ((max-min)+1);
        if (max >0)
            return getmin(newMin, min);
        else return -1; //not found
    }

     int getmin(int n, int m){

        if (n>m) return m;
        else return n;
    }









    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() throws IOException {
//        String s_1 = "dcbefebce";
//        String t_1 = "fd";
//        int expected_1 = 5;
//        int output_1 = minLengthSubstring(s_1, t_1);
//        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd"; //c 7, b 3, f 2, a 1, e 2, d 3
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

//        bfbeadbccfea b  b  a  e e  cdd ccc //  c 1, b 0, f 0, a 0, e 0, d 0

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new FB_2C_MinLenSubStrings_Strings().run();
    }
}

/*
Minimum Length Substrings
You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
Signature
int minLengthSubstring(String s, String t)
Input
s and t are non-empty strings that contain less than 1,000,000 characters each
Output
Return the minimum length of the substring of s. If it is not possible, return -1
Example
s = "dcbefebce"
t = "fd"'
output = 5
Explanation:
Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
 */