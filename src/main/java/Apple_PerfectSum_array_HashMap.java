import java.util.*;

public class Apple_PerfectSum_array_HashMap {

    public static void main(String[] args) {
       System.out.println(checkIsPerfectNumber(2));  //19
    }

    public static boolean checkIsPerfectNumber2( int input ) {
        int num = 0;
        int sum = 0;

        for (int i=1; i<input; i++){
            if (input % i ==0)
            { sum = sum + i;
            }
        }
        if (sum == input){
            return true;

        }
        return false;

    }

    public static boolean checkIsPerfectNumber3( int input ) {
        int num = 0;
        int sum = 0;

        for (int i=input%10; i>0; i=input-i){
            if (input % i ==0)
            { sum = sum + i;
            }
        }
        if (sum == input){
            return true;

        }
        return false;

    }



    public static int getSum( int i ) {

        int sum = 0;

//        while  ((sum!=1) && (i!=0) ) {
//
//            sum = ((i%10)*(i%10)) + sum;
//            i = i / 10;
//
//            System.out.println("sum: " + sum + ", i : " + i );
//
//        }

        for (int j = i%10; j!=0; i=i-i%10){
            sum = j*j +sum;
               if (sum ==1)
                   break;
        }

        return sum;

    }

    public static boolean checkIsPerfectNumber( int i ) {

        //pattern repeats so if any num/sum is equal to any within list,  it will lead to pattern
//        Map<Integer, Integer>   sumMap = new HashMap<>()  ;
        int[] a = { 4, 20, 0, 16, 36, 27, 49, 58, 64, 89, 81, 145, 25, 41, 42};

//
//        for (int j = 0; j< a.length; j++){
//            sumMap.put(a[j], 1); //added one just for sake of adding value, not using it. need O(1) retrieveal
//        }

        // check if number is in endlessLoop

        int sum = getSum(i);

        while ((sum != 1) && (sum!=4)){
            sum = getSum(sum);


        }
        if (sum ==1 ){
            return true;
        }
        else return false;

    }

}
/*
Write an algorithm to determine if a number n is a “perfect” number.
A Perfect number is a number defined by the following process: Starting with any positive integer,

replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are Perfect  numbers.
Return True if n is a Perfect  number, and False if not.

Example:
Input: 19
Output: true
Explanation:                i :19           sum :0
1*1 + 9*9 = 82               19%10 = 9       81
8*8 + 2*2 = 68
6*6 + 8*8 = 100
1*1 + 0*0 + 0*0 = 1


I : 32
3*3 + 2*2 = 6 + 4 = 10
1*1 + 0*0 = 1

i : 2

2 * 2 = 4
4 * 4 = 16
1 + 36 = 37
9 + 49 = 58

David Williamson
Ibrahim Kumek
“””
 */