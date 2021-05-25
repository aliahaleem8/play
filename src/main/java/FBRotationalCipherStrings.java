// Add any extra import statements you may need here
/*
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
Need Hints

Complexity 1
We need to process every character, even if only to check whether or not it's alphanumeric, so no solution can be faster than O(n) where, n is the number of characters in the input string. Within each character processing, however, consider how you might transform it optimally.
Complexity 2
Since every character can be handled independently, we just need an O(1) operation for transforming a character into its ciphered version. In particular, we don’t want to use O(rotationFactor) steps for each character.
If your solution involves iterating through rotations one at a time (e.g. if a rotationFactor of 6 causes your code to consider transforming A to B to C to D to E to F to G without skipping directly from A to G), then you should consider how you might cut out those steps in between. If reducing the time complexity means you now use a meaningful amount of additional space, then you should consider how you might avoid using that space.


Edge cases 1
Does your code correctly handle all non-alphanumeric characters? The list of non-alphanumeric characters is harder to define, so it’s much easier to check if a character is alphanumeric rather than the other way around.
Edge cases 2
Does your code work correctly if rotationFactor is greater than 25? How about a rotationFactor of 0?


 */

class FBRotationalCipherStrings {

    // Add any helper functions you may need here

//    char getDigitRotationalCipher(char c, int factor){
//        HashMap<Character,Integer> map = new HashMap<>();
//        for (char numC : "0123456789".toCharArray()){
//            map.put(numC, 0);
//        }
//        return c;
//    }
    char getCharRotationalCipher(char c, int factor){

        if ((c>=48)&&(c<=57)){
            //without wrapping numbers
            if ((c+(factor%10))<='9')
                return (char) (c + (factor%10));
                //must wrap numbers
            else return (char) ('0' + (factor%10)- ('9'-c +1));// (c - (10-(factor%10)));//('0'+ (61-(c+(factor%10))));
            //(factor%10)-('9'-c)+'0'
        }

        else if ((c< 65) || (c>122)){


            return c; // non-alphabet char

        }

        else if (c!=' '){ //alphabet char
            int alphabetPostion = c;
            char cPosition= 'a';
            int modBy = 26;
            if ((c>=65)&&(c<=90)){
                // if uppercase diff from 'A'
                cPosition = 'A';
            }
            if ((c>=48)&&(c<=57)){ //numbers
                cPosition = '0';
                modBy = 10;
            }
            int originalPos = c- cPosition;
            int newPosition = (originalPos + factor) % modBy ;
            char newChar = (char) (cPosition + newPosition);
            return newChar;

        }
        return c;
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        if (rotationFactor == 0) return input;
        StringBuilder output = new StringBuilder();


        for (char c : input.toCharArray()){
            output.append("" + getCharRotationalCipher(c, rotationFactor));
        }

        return output.toString();

    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here
        //worked with 0 factor and > 25



//        String input = "Zebra-493?";
//        int rotationFactor = 3;
//        String expected= "Cheud-726?";
//        String output = rotationalCipher(input, rotationFactor);
//        check(expected, output);

        String input = "abcdefghijklmNOPQRSTUVWXYZ0123456789";
        int rotationFactor = 39;
        String expected= "nopqrstuvwxyzABCDEFGHIJKLM9012345678";
        String output = rotationalCipher(input, rotationFactor);
        check(expected, output);

/*
input = abcdefghijklmNOPQRSTUVWXYZ0123456789
rotationFactor = 39
output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
Need Hints?
 */

    }

    public static void main(String[] args) {
        new FBRotationalCipherStrings().run();
    }
}