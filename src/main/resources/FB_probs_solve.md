# Coding exercises

## 0 Starter Plan (Mixed Categories)

### a. Rotational Cipher [x]
Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.
Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
Example 2
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678

Hints?

Complexity
Complexity 1
We need to process every character, even if only to check whether or not it's alphanumeric, so no solution can be faster than O(n) where, n is the number of characters in the input string. Within each character processing, however, consider how you might transform it optimally.
Complexity 2
Since every character can be handled independently, we just need an O(1) operation for transforming a character into its ciphered version. In particular, we don’t want to use O(rotationFactor) steps for each character.
If your solution involves iterating through rotations one at a time (e.g. if a rotationFactor of 6 causes your code to consider transforming A to B to C to D to E to F to G without skipping directly from A to G), then you should consider how you might cut out those steps in between. If reducing the time complexity means you now use a meaningful amount of additional space, then you should consider how you might avoid using that space.

Edge cases 1
Does your code correctly handle all non-alphanumeric characters? The list of non-alphanumeric characters is harder to define, so it’s much easier to check if a character is alphanumeric rather than the other way around.
Edge cases 2
Does your code work correctly if rotationFactor is greater than 25? How about a rotationFactor of 0?

Solution Approach


Solution approach 1
Let us first note that, for alphabetic characters, any rotationFactor greater than 25 can be reduced to a factor in the range [0, 25] since rotating 26 times is the same as rotating 0 times. Similarly, when rotating a numeric character, any rotationFactor greater than 9 can be reduced to the range [0, 9]. Subtracting 26 (or 10) repeatedly is a slow way to reduce the factor, so we can instead use modular arithmetic.
In most languages, the % operator is the modulo operator. A % B returns the remainder after dividing A by B, which is the same as subtracting B repeatedly until you have a value in the range [0, B). Some languages have an explicit mod(A, B) function instead of a first-class operator.
Solution approach 2
Once we’ve reduced our factor to a small value, there are a few ways to achieve O(1) rotations per character. Some of these take additional (though constant) space such as making a series of hash tables that map an input character to a ciphered character, one for each level of rotation from 0 to 25. But instead, we can take advantage of the fact that the characters a-z, A-Z, and 0-9 all exist in a contiguous range of ASCII values. Most languages let you convert characters to and from ASCII values, and many let you perform arithmetic directly on characters. If you want to rotate ‘E’ by 5, you can simply compute 'E' + 5 = 'J'.
Solution approach 3
We must take care, however, to wrap around if we go past the last character. We don’t want to do 'Z' + 4 = '^'! We can use modular arithmetic once more to avoid this problem. Consider this pseudocode:
rotateCharacter(c, rotationFactor) {
    return ((c - 'A' + rotationFactor) % 26) + 'A';
}
c - 'A' will let us represent each letter as a number from [0, 25]. This step is necessary because the ASCII value of ‘A’ is not 0. We then add the rotation factor (and note that it isn’t actually necessary to reduce it beforehand) and then take this sum modulo 26 to get the [0, 25]-representation of the rotated character. We add ‘A’ back in at the end to translate this value back into the ASCII range of A-Z.
You can extend this code to properly handle characters in the ranges a-z and 0-9 as well.

### b. Contiguous Subarrays

### c. Pair Sums


## 1: Arrays


### a. Reverse to Make Equals


### b. Passing Yearbooks

### c. Contiguous Subarrays


## 1: Arrays


### a. Reverse to Make Equals []

Reverse to Make Equal
Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
Signature
bool areTheyEqual(int[] arr_a, int[] arr_b)
Input
All integers in array are in the range [0, 1,000,000,000].
Output
Return true if B can be made equal to A, return false otherwise.
Example
A = [1, 2, 3, 4]
B = [1, 4, 3, 2]
output = true
After reversing the subarray of B from indices 1 to 3, array B will equal array A.

### b. Passing Yearbooks []

Passing Yearbooks
There are n students, numbered from 1 to n, each with their own yearbook. They would like to pass their yearbooks around and get them signed by other students.
You're given a list of n integers arr[1..n], which is guaranteed to be a permutation of 1..n (in other words, it includes the integers from 1 to n exactly once each, in some order). The meaning of this list is described below.
Initially, each student is holding their own yearbook. The students will then repeat the following two steps each minute: Each student i will first sign the yearbook that they're currently holding (which may either belong to themselves or to another student), and then they'll pass it to student arr[i-1]. It's possible that arr[i-1] = i for any given i, in which case student i will pass their yearbook back to themselves. Once a student has received their own yearbook back, they will hold on to it and no longer participate in the passing process.
It's guaranteed that, for any possible valid input, each student will eventually receive their own yearbook back and will never end up holding more than one yearbook at a time.
You must compute a list of n integers output, whose element at i-1 is equal to the number of signatures that will be present in student i's yearbook once they receive it back.
Signature
int[] findSignatureCounts(int[] arr)
Input
n is in the range [1, 100,000].
Each value arr[i] is in the range [1, n], and all values in arr[i] are distinct.
Output
Return a list of n integers output, as described above.
Example 1
n = 2
arr = [2, 1]
output = [2, 2]
Pass 1:
Student 1 signs their own yearbook. Then they pass the book to the student at arr[0], which is Student 2.
Student 2 signs their own yearbook. Then they pass the book to the student at arr[1], which is Student 1.
Pass 2:
Student 1 signs Student 2's yearbook. Then they pass it to the student at arr[0], which is Student 2.
Student 2 signs Student 1's yearbook. Then they pass it to the student at arr[1], which is Student 1.
Pass 3:
Both students now hold their own yearbook, so the process is complete.
Each student received 2 signatures.
Example 2
n = 2
arr = [1, 2]
output = [1, 1]
Pass 1:
Student 1 signs their own yearbook. Then they pass the book to the student at arr[0], which is themself, Student 1.
Student 2 signs their own yearbook. Then they pass the book to the student at arr[1], which is themself, Student 2.
Pass 2:
Both students now hold their own yearbook, so the process is complete.
Each student received 1 signature.




### c. Contiguous Subarrays []


#### Contiguous Subarrays
You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfill the following conditions:
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end on index i.

#### Signature
int[] countSubarrays(int[] arr)
Input
Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
Size N is between 1 and 1,000,000
#### Output
An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
##### Example:
arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]

Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]

#### Hints

##### Complexity

###### Complexity 1
Any solution must have time and space complexities of at least O(N) to deal with the array of N integers. A relatively simple solution considering all possible contiguous subarrays, or in fact any solution counting the valid subarrays one-by-one, would require a time complexity of at least O(N^2). However, a number of observations can allow this to be optimized down to the ideal time complexity of O(N). For example, letting L[i] be the number of valid subarrays ending at index i (useful to compute on the way to the final answer), consider how we might efficiently compute L[i] for each i from 1 to N by reusing past information rather than computing it from scratch.
###### Complexity 2
When analyzing such a solution, note that even if we’re computing N values L[1..N], and computing any single one of those values might take on the order of N steps, the overall time complexity will not necessarily be O(N^2) - we should instead consider how many steps may occur in total across all N of them in the worst case.


##### Solution approach
###### Solution approach 1
Letting L[i] be the number of valid subarrays ending at index i and R[i] be the number of valid subarrays beginning at index i, we’ll have output[i] = L[i] + R[i] - 1. Computing R[1..N] is equivalent to computing L[1..N] if a were reversed, allowing us to reduce the problem to computing L[1..N] for an array of N distinct integers.
###### Solution approach 2
We can next observe that the index of the latest element to the left of the ith element which is larger than it determines which subarrays ending at index i are valid - specifically, the ones beginning to the right of that larger element. Letting G[i] be equal to the largest index j such that j < i and a[j] > a[i] (or equal to 0 if there’s no such j), then L[i] = i - G[i]. We’ve now reduced the problem to computing these values G[1..N] for an array of N distinct integers.
###### Solution approach 3
Computing G[i] for each i from 1 to N is a promising approach, but we’ll still need to consider how to do so as efficiently as possible. We can observe that it’s not possible to compute G[i] purely based on the values of G[i-1], a[i-1], and a[i]; we may need more information about earlier a values as well, but would like to avoid simply scanning over all of them. Out of earlier indices j (such that j < i), we can consider which indices are worth considering as potential candidates for G[i] - for example, if there exists a pair of indices j and k such that j < k and a[j] < a[k], can index j ever be a candidate for G[i] for any i > k? If we can maintain information about the set of these possible candidate indices as we go through the array, it’s possible to efficiently determine the one that’s actually equal to G[i] for each i.


## 2: Strings

### a. Rotational Cipher [x]

### b. Matching Pairs []
Matching Pairs
Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
Note: This means you must swap two characters at different indices.
Signature
int matchingPairs(String s, String t)
Input
s and t are strings of length N
N is between 2 and 1,000,000
Output
Return an integer denoting the maximum number of matching pairs
Example 1
s = "abcd"
t = "adcb"
output = 4
Explanation:
Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
Therefore, the number of matching pairs of s and t will be 4.
Example 2
s = "mno"
t = "mno"
output = 1
Explanation:
Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.

### c. Minimum Length Substrings

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

## 3. Heaps

### a. Largest Triple Products

Largest Triple Products
You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index i (between 0 and n-1, inclusive), output[i] is equal to the product of the three largest elements out of arr[0..i] (or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
Note that the three largest elements used to form any product may have the same values as one another, but they must be at different indices in arr.
Signature
int[] findMaxProduct(int[] arr)
Input
n is in the range [1, 100,000].
Each value arr[i] is in the range [1, 1,000].
Output
Return a list of n integers output[0..(n-1)], as described above.
Example 1
n = 5
arr = [1, 2, 3, 4, 5]
output = [-1, -1, 6, 24, 60]
The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.
Example 2
n = 5
arr = [2, 1, 2, 1, 2]
output = [-1, -1, 4, 4, 8]
The 3rd element of output is 2*2*1 = 4, the 4th is 2*2*1 = 4, and the 5th is 2*2*2 = 8.

### b. Magical Candy Bags
Magical Candy Bags
You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy are inside), and as soon as you finish, the bag mysteriously refills. If there were x pieces of candy in the bag at the beginning of the minute, then after you've finished you'll find that floor(x/2) pieces are now inside.
You have k minutes to eat as much candy as possible. How many pieces of candy can you eat?
Signature
int maxCandies(int[] arr, int K)
Input
1 ≤ N ≤ 10,000
1 ≤ k ≤ 10,000
1 ≤ arr[i] ≤ 1,000,000,000
Output
A single integer, the maximum number of candies you can eat in k minutes.
Example 1
N = 5
k = 3
arr = [2, 1, 7, 4, 2]
output = 14
In the first minute you can eat 7 pieces of candy. That bag will refill with floor(7/2) = 3 pieces.
In the second minute you can eat 4 pieces of candy from another bag. That bag will refill with floor(4/2) = 2 pieces.
In the third minute you can eat the 3 pieces of candy that have appeared in the first bag that you ate.
In total you can eat 7 + 4 + 3 = 14 pieces of candy.


### c.   Median Stream

Median Stream
You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index i (between 0 and n-1, inclusive), output[i] is equal to the median of the elements arr[0..i] (rounded down to the nearest integer).
The median of a list of integers is defined as follows. If the integers were to be sorted, then:
If there are an odd number of integers, then the median is equal to the middle integer in the sorted order.
Otherwise, if there are an even number of integers, then the median is equal to the average of the two middle-most integers in the sorted order.
Signature
int[] findMedian(int[] arr)
Input
n is in the range [1, 1,000,000].
Each value arr[i] is in the range [1, 1,000,000].
Output
Return a list of n integers output[0..(n-1)], as described above.
Example 1
n = 4
arr = [5, 15, 1, 3]
output = [5, 10, 5, 4]
The median of [5] is 5, the median of [5, 15] is (5 + 15) / 2 = 10, the median of [5, 15, 1] is 5, and the median of [5, 15, 1, 3] is (3 + 5) / 2 = 4.
Example 2
n = 2
arr = [1, 2]
output = [1, 1]
The median of [1] is 1, the median of [1, 2] is (1 + 2) / 2 = 1.5 (which should be rounded down to 1).

## 4. Greedy Algorithms

### a. Slow Sums

       Suppose we have a list of N numbers, and repeat the following operation until we're left with only a single number: Choose any two numbers and replace them with their sum. Moreover, we associate a penalty with each operation equal to the value of the new number, and call the penalty for the entire list as the sum of the penalties of each operation.
       For example, given the list [1, 2, 3, 4, 5], we could choose 2 and 3 for the first operation, which would transform the list into [1, 5, 4, 5] and incur a penalty of 5. The goal in this problem is to find the worst possible penalty for a given input.
       Signature:
       int getTotalTime(int[] arr)
       Input:
       An array arr containing N integers, denoting the numbers in the list.
       Output format:
       An int representing the worst possible total penalty.
       Constraints:
       1 ≤ N ≤ 10^6
       1 ≤ Ai ≤ 10^7, where *Ai denotes the ith initial element of an array.
       The sum of values of N over all test cases will not exceed 5 * 10^6.
       Example
       arr = [4, 2, 1, 3]
       output = 26
       First, add 4 + 3 for a penalty of 7. Now the array is [7, 2, 1]
       Add 7 + 2 for a penalty of 9. Now the array is [9, 1]
       Add 9 + 1 for a penalty of 10. The penalties sum to 26.

### b. Element Swapping

Element Swapping
Given a sequence of n integers arr, determine the lexicographically smallest sequence which may be obtained from it after performing at most k element swaps, each involving a pair of consecutive elements in the sequence.
Note: A list x is lexicographically smaller than a different equal-length list y if and only if, for the earliest index at which the two lists differ, x's element at that index is smaller than y's element at that index.
Signature
int[] findMinArray(int[] arr, int k)
Input
n is in the range [1, 1000].
Each element of arr is in the range [1, 1,000,000].
k is in the range [1, 1000].
Output
Return an array of n integers output, the lexicographically smallest sequence achievable after at most k swaps.
Example 1
n = 3
k = 2
arr = [5, 3, 1]
output = [1, 5, 3]
We can swap the 2nd and 3rd elements, followed by the 1st and 2nd elements, to end up with the sequence [1, 5, 3]. This is the lexicographically smallest sequence achievable after at most 2 swaps.
Example 2
n = 5
k = 3
arr = [8, 9, 11, 2, 1]
output = [2, 8, 9, 11, 1]
We can swap [11, 2], followed by [9, 2], then [8, 2].


### c. Seating Arrangements

Seating Arrangements
There are n guests attending a dinner party, numbered from 1 to n. The ith guest has a height of arr[i-1] inches.
The guests will sit down at a circular table which has n seats, numbered from 1 to n in clockwise order around the table. As the host, you will choose how to arrange the guests, one per seat. Note that there are n! possible permutations of seat assignments.
Once the guests have sat down, the awkwardness between a pair of guests sitting in adjacent seats is defined as the absolute difference between their two heights. Note that, because the table is circular, seats 1 and n are considered to be adjacent to one another, and that there are therefore n pairs of adjacent guests.
The overall awkwardness of the seating arrangement is then defined as the maximum awkwardness of any pair of adjacent guests. Determine the minimum possible overall awkwardness of any seating arrangement.
Signature
int minOverallAwkwardness(int[] arr)
Input
n is in the range [3, 1000].
Each height arr[i] is in the range [1, 1000].
Output
Return the minimum achievable overall awkwardness of any seating arrangement.
Example
n = 4
arr = [5, 10, 6, 8]
output = 4
If the guests sit down in the permutation [3, 1, 4, 2] in clockwise order around the table (having heights [6, 5, 8, 10], in that order), then the four awkwardnesses between pairs of adjacent guests will be |6-5| = 1, |5-8| = 3, |8-10| = 2, and |10-6| = 4, yielding an overall awkwardness of 4. It's impossible to achieve a smaller overall awkwardness.


## 5. Trees

### a. Number of Visible Nodes

### b. Nodes in a Subtree



## 6. Recursion

### a. Encrypted Words
### b. Change in a Foreign Currency


## 7.Search
### a. Revenue Milestones
### b. 1 Billion Users



## 8. Sorting


### a. Balanced Split

Balanced Split
Given an array of integers (which may include repeated integers), determine if there's a way to split the array into two subsequences A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly smaller than all of the integers in B.
Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
Signature
bool balancedSplitExists(int[] arr)
Input
All integers in array are in the range [0, 1,000,000,000].
Output
Return true if such a split is possible, and false otherwise.
Example 1
arr = [1, 5, 7, 1]
output = true
We can split the array into A = [1, 1, 5] and B = [7].
Example 2
arr = [12, 7, 6, 7, 6]
output = false
We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the requirement that all integers in A are smaller than all integers in B.


### b. Counting Triangles


## 9. Stacks

### a. Balance Brackets []

## 10. Hash Tables

### a. Pair Sums

## 11. Queues

### a. Queue Removals

Queue Removals
You're given a list of n integers arr, which represent elements in a queue (in order from front to back). You're also given an integer x, and must perform x iterations of the following 3-step process:
Pop x elements from the front of queue (or, if it contains fewer than x elements, pop all of them)
Of the elements that were popped, find the one with the largest value (if there are multiple such elements, take the one which had been popped the earliest), and remove it
For each one of the remaining elements that were popped (in the order they had been popped), decrement its value by 1 if it's positive (otherwise, if its value is 0, then it's left unchanged), and then add it back to the queue
Compute a list of x integers output, the ith of which is the 1-based index in the original array of the element which had been removed in step 2 during the ith iteration.
Signature
int[] findPositions(int[] arr, int x)
Input
x is in the range [1, 316].
n is in the range [x, x*x].
Each value arr[i] is in the range [1, x].
Output
Return a list of x integers output, as described above.
Example
n = 6
arr = [1, 2, 2, 3, 4, 5]
x = 5
output = [5, 6, 4, 1, 2]
The initial queue is [1, 2, 2, 3, 4, 5] (from front to back).
In the first iteration, the first 5 elements are popped off the queue, leaving just [5]. Of the popped elements, the largest one is the 4, which was at index 5 in the original array. The remaining elements are then decremented and added back onto the queue, whose contents are then [5, 0, 1, 1, 2].
In the second iteration, all 5 elements are popped off the queue. The largest one is the 5, which was at index 6 in the original array. The remaining elements are then decremented (aside from the 0) and added back onto the queue, whose contents are then [0, 0, 0, 1].
In the third iteration, all 4 elements are popped off the queue. The largest one is the 1, which had the initial value of 3 at index 4 in the original array. The remaining elements are added back onto the queue, whose contents are then [0, 0, 0].
In the fourth iteration, all 3 elements are popped off the queue. Since they all have an equal value, we remove the one that was popped first, which had the initial value of 1 at index 1 in the original array. The remaining elements are added back onto the queue, whose contents are then [0, 0].
In the final iteration, both elements are popped off the queue. We remove the one that was popped first, which had the initial value of 2 at index 2 in the original array.

## 12. Graphs

### a. Minimizing Permutations
Minimizing Permutations
In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N, denoted as (a_1, a_2, ..., a_N). You want to rearrange the elements of the permutation into increasing order, repeatedly making the following operation:
Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
Your goal is to compute the minimum number of such operations required to return the permutation to increasing order.
Signature
int minOperations(int[] arr)
Input
Array arr is a permutation of all integers from 1 to N, N is between 1 and 8
Output
An integer denoting the minimum number of operations required to arrange the permutation in increasing order
Example
If N = 3, and P = (3, 1, 2), we can do the following operations:
Select (1, 2) and reverse it: P = (3, 2, 1).
Select (3, 2, 1) and reverse it: P = (1, 2, 3).
output = 2


## 13. Linked Lists

### a. Reverse Operations
Reverse Operations
You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
The goal of this question is: given a resulting list, determine the original order of the elements.
Implementation detail:
You must use the following definition for elements in the linked list:
class Node {
    int data;
    Node next;
}
Signature
Node reverse(Node head)
Constraints
1 <= N <= 1000, where N is the size of the list
1 <= Li <= 10^9, where Li is the ith element of the list
Example
Input:
N = 6
list = [1, 2, 8, 9, 12, 16]
Output:
[1, 8, 2, 9, 16, 12]