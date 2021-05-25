import java.util.*;
// Add any extra import statements you may need here
/*
Pair Sums
Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.

//
If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.
Signature
int numberOfWays(int[] arr, int k)
Input
n is in the range [1, 100,000].
Each value arr[i] is in the range [1, 1,000,000,000].
k is in the range [1, 1,000,000,000].
Output
Return the number of different pairs of elements which sum to k.
Example 1
n = 5
k = 6
arr = [1, 2, 3, 4, 3]
output = 2
The valid pairs are 2+4 and 3+3.
Example 2
n = 5
k = 6
arr = [1, 5, 3, 3, 3]
output = 4
There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).

Edge cases
Edge cases 1
Make sure to test with values around the maximum possible input value (one billion).
Edge cases 2
Will your solution work when all pairs sum to k? Imagine an array with 100,000 copies of k/2. What should the answer be?



Complexity 1
The straightforward solution is to test all pairs of numbers to see if they sum to k. There are n choices for the first number, and n-1 choices for the second number, for a total of O(n^2) pairs. In truth, this involves comparing each pair twice; so there are actually n * (n-1) / 2 pairs of interest. But this is still O(n^2).
Consider how we might reduce this time complexity. Clearly, we need to iterate over all of the numbers at least once, so the best possible solution is no faster than O(n). It may be the case that O(n log n) is the best we can do. Solutions with this runtime typically involve binary search, sorting, or divide and conquer. It may be necessary to use additional space to improve the time complexity.
Complexity 2
If the array is sorted, it’s possible to then solve the problem in O(n) time. The sort itself takes O(n log n) time, so that will be the overall time complexity for an optimal solution that involves sorting. It’s a good exercise to consider how we might write such a solution, but it’s possible to do better and achieve a truly O(n) solution.
Complexity 3
If we’re willing to use additional space, we can achieve O(n) time complexity at the cost of O(n) additional space. This solution involves iterating over the array once to compute some useful statistics that will then allow us to solve the problem by iterating over the array once more.


Solution approach
Solution approach 1
O(n log n) solution
We can first sort the array and then iterate inwards from the outside edges by maintaining two pointers. Consider adding the two numbers at indices 0 and n-1. If this sum is less than k, we increment the left pointer. If this sum is greater than k, we decrement the right pointer. If the sum is equal to k, then we increment a count of valid pairs and move both pointers inwards. We can repeat this process until the pointers meet.
As stated, this solution only works when all the values in the array are unique. To handle values that appear multiple times, we can consider each block of the same value as a single index in the array, but with a “weight” equal to the number of occurrences of that value. For example, if the sorted array is [1, 2, 2, 2, 3, 4, 4] and k = 6, then when our pointers are pointing at 2 and 4, we would increment our counter of valid pairs not by 1, but by 3 * 2, the weights of 2 and 4 respectively.
You must take care in one particular case: when the pointers are both pointing at a value which is exactly k/2. It’s incorrect to multiply the weight of this block by itself, since that would count pairing up some indices with themselves. If k/2 appears w times, then you must add w * (w - 1) / 2 valid pairs.
Solution approach 2
O(n) solution
Let us iterate over the array once to build a hash table that maps each number in the array to the number of times it occurs. For example, if our array is [2, 1, 3, 4, 2, 4, 2], then our hash table would look like:
{
  1: 1,
  2: 3,
  3: 1,
  4: 2,
}
Now that we have these counts, we can iterate over the array one more time. Every time we hit a value v, we can look up the number of times that k-v appears in the array since that’s the exact number that we would need to form a pair that sums to k. This method will count every pair twice, therefore we must take care to divide by 2 at the end. In addition to that, ensure that you correctly handle the same special case described in the previous solution, when v = k/2.
We can also iterate over the hash table directly instead of iterating over the array a second time. Similar to the O(n log n) solution, each value has a weight and we can multiply those weights together to count the number of valid pairs involving those values.
Either of these methods requires O(n) additional space, but this is typically a good price to pay for O(n) time complexity.




 */

class FB_0C_10_PairSums_HashTables {

    // Add any helper functions you may need here

    int numberOfWays(int[] arr, int k) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i< arr.length; i++){
            if (hm.containsKey(arr[i])){
                List<Integer> indices = new ArrayList<>(hm.get(arr[i]));
                indices.add(i);
              //  indices.add(i);
                hm.put(arr[i],indices);
            }
            else
                hm.put(arr[i], Arrays.asList(i));
            }
            System.out.println("hm: " + hm.toString());


        HashSet<String> pairs = new HashSet<>();
        hm.forEach((key,val)->{
          if (hm.containsKey(k-key)){
              pairs.add(""+ (hm.get(k-key))+","+ val);

          }
        });

        return 0;
    }

    int numberOfWay(int[] arr, int k) {

        int count = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i< arr.length; i++){
            if (hm.containsKey(k-arr[i])){
                System.out.println(arr[i] + ", " + (k-arr[i]));
                //count= count + hm.get(k-a[i]);
                count++;
                hm.put(k-arr[i], hm.get(k-arr[i])-1);


            }
            else if (hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i])+1);
                counts.put(arr[i], counts.get(arr[i])+1);

            }
            else{
                hm.put(arr[i], 1);
                counts.put(arr[i], 1);
            }
        }
        return count;

    }









    int numberOfWays2(int[] a, int k) {
        // Write your code here

    //    ArrayList<Integer> arr = new ArrayList<>();
//        for (String string: strings){
//            System.out.println(string);
//        }

        int count = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i< a.length; i++){
            if (hm.containsKey(k-a[i])){
                System.out.println(a[i] + ", " + (k-a[i]));
                //count= count + hm.get(k-a[i]);
                count++;
                hm.put(k-a[i], hm.get(k-a[i])-1);

            }
            else if (hm.containsKey(a[i])){
                hm.put(a[i], hm.get(a[i])+1);
            }
            else hm.put(a[i], 1);
        }
        return count;

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

    public void run() {
//        int k_1 = 6;
//        int[] arr_1 = {1, 2, 3, 4, 3};
//        int expected_1 = 2;
//        int output_1 = numberOfWays(arr_1, k_1);
//        check(expected_1, output_1);


        // !! gets different 3 locations fails: There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).
        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here
//
//        int arr[] = { 1, 5, 7, -1, 5 };
//        check(3, numberOfWays(arr, 6));


//        int k_3 = 10;
//        int[] arr_3 = {3, 3, 5, 6, 4, 8, 7, 7};
//        int expected_3 = 3;
//        int output_3 = numberOfWays(arr_3, k_3);
//        check(expected_3, output_3);

    }
    public static void main(String[] args) {
        new FB_0C_10_PairSums_HashTables().run();
    }
}