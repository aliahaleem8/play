public class AmazonFindAllWordsInString {
}
//    int test_case_number = 1;
//    void check(String expected, String output) {
//        boolean result = (expected.equals(output));
//        char rightTick = '\u2713';
//        char wrongTick = '\u2717';
//        if (result) {
//            System.out.println(rightTick + " Test #" + test_case_number);
//        }
//        else {
//            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
//            printString(expected);
//            System.out.print(" Your output: ");
//            printString(output);
//            System.out.println();
//        }
//        test_case_number++;
//    }
//    void printString(String str) {
//        System.out.print("[\"" + str + "\"]");
//    }
//
//    public void run() {
//        String input_1 = "All-convoYs-9-be:Alert1.";
//        int rotationFactor_1 = 4;
//        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
//        String output_1 = rotationalCipher(input_1, rotationFactor_1);
//        check(expected_1, output_1);
//
//        String input_2 = "abcdZXYzxy-999.@";
//        int rotationFactor_2 = 200;
//        String expected_2 = "stuvRPQrpq-999.@";
//        String output_2 = rotationalCipher(input_2, rotationFactor_2);
//        check(expected_2, output_2);
//
//        // Add your own test cases here
//        //worked with 0 factor and > 25
//
//        // failed:
//        // String input = "8 1 ";
//        //   int rotationFactor = 4;
//        //    String expected= "2 5 ";
//
//
//        printCharValue('A');
//        printCharValue('Z');
//
//        printCharValue('a');
//        printCharValue('z');
//
//        printCharValue('0');
//        printCharValue('9');
//
//
//
//        String input = "Zebra-493?";
//        int rotationFactor = 3;
//        String expected= "Cheud-726?";
//        String output = rotationalCipher(input, rotationFactor);
//        check(expected, output);
//
//
//
//    }
//
//    public static void main(String[] args) {
//        new FB_0A_2A_RotationalCipher_Strings().run();
//    }
//}