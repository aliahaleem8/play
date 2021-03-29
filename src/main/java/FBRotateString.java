
import java.util.*;
// Add any extra import statements you may need here

public class FBRotateString {

    // Add any helper functions you may need here


char getCharRotationalCipher(char c , int f){
    System.out.println(c);
    return c;
}


    char getDigitRotationalCipher(char c, int factor){
        HashMap<Integer, Character> map = new HashMap<>();
        int n = 0;
        for (char c2 : "0123456789".toCharArray()){
            map.put(n, c2);
            n++;
        }
        char result = (char) ('9'-c + '0' + (factor -1));
        return result;
    }
    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here;

        // set different cases:

        StringBuilder result = new StringBuilder();
        for (char character : input.toCharArray()) {

            int num = ((character < 65) || (character > 122))? 1: -1;
            if ((character < 65) || (character > 122)) //exclude 91-96
                result.append(character);
            //[97, 122] lowercase
           //[65, 90] uppercase
            else if (character != ' ') {
                boolean isUpperCase = false;

                int originalAlphabetPosition = character - 'a';
                if ((character >=65)&& (character<=90)){
                    isUpperCase = true;
                    originalAlphabetPosition = character - 'A';
                }
                int newAlphabetPosition = (originalAlphabetPosition + rotationFactor) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                if (isUpperCase)
                    newCharacter = (char) ('A' + newAlphabetPosition);
                result.append(newCharacter);
            }    else if ((character>=48)&&(character<=57))
                result.append(getDigitRotationalCipher(character, rotationFactor));

            else {
                result.append(character);
            }
        }
        return result.toString();
    }



    //return cipher(message, 26 - (offset % 26));


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
//        String input_1 = "All-convoYs-9-be:Alert1.";
//        int rotationFactor_1 = 4;
//        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
//        String output_1 = rotationalCipher(input_1, rotationFactor_1);
//        check(expected_1, output_1);
        char in = '0';
        char out =  getDigitRotationalCipher(in, 4);
        char expected = '4';
        check("" + expected, "" + out);


        String input_1 = "--9. 1 .";
        int rotationFactor_1 = 4;
        String expected_1 = "--3. 5 .";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here
        // works for lower case
        String input_3 = "abc";
        int rotationFactor_3 = 3;
        String expected_3 = "def";
        String output_3 = rotationalCipher(input_3, rotationFactor_3);
        check(expected_3, output_3);


        //works for special characters
        String input_111 = "ll-convos--be:lert";
        int rotationFactor_111 = 4;
        String expected_111 = "pp-gsrzsw--fi:pivx";
        String output_111 = rotationalCipher(input_111, rotationFactor_111);
        check(expected_111, output_111);

//        //works
//        String input_1112 = "ll-con@vos-  -be:lert ";
//        int rotationFactor_1112 = 4;
//        String expected_1112 = "pp-gsr@zsw-  -fi:pivx ";
//        String output_1112 = rotationalCipher(input_1112, rotationFactor_1112);
//        check(expected_1112, output_1112);

        //works
        String input_1112 = "pp-gsr@zsw-  -fi:pivx ";
        int rotationFactor_1112 = -4;
        String expected_1112 = "ll-con@vos-  -be:lert ";
        String output_1112 = rotationalCipher(input_1112, rotationFactor_1112);
        check(expected_1112, output_1112);

    }

    public static void main(String[] args) {
        new FBRotateString().run();
    }

}