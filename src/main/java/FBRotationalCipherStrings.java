// Add any extra import statements you may need here


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