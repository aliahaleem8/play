public class OneEditApart {

    public boolean editApart(String a, String b) {
        if (Math.abs(a.length()-b.length()) > 1)
                return false;

        int changes = 0;
        //begins with no changes captured

        for (int i =0 ; i< a.length(); i++){
            int ai = 0;
            int bi = 0;
            if (a.charAt(i)!=b.charAt(i)) {
                changes++;
                if (changes > 1) return false;
                if ((a.substring(i, a.length()-1).equals(b.substring(i+1, b.length()-1))) ||
                        (a.substring(i+1, a.length()-1).equals(b.substring(i, b.length()-1))) )
                    return true;
            }

        }


        return true;
    }

    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printBoolean(expected);
            System.out.print(" Your output: ");
            printBoolean(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        check(false, editApart("cat", "catss")); //
       // check(false, editApart("cat", "dog"));
        check(true, editApart("cat", "cats"));
        check(true, editApart("cat", "cut"));
        // check(true, editApart("cat", "cast"));
        check(true, editApart("cat", "ca"));
        check(false,  editApart("cat", "act"));
        // Add your own test cases here

    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    void printBoolean(boolean n) {
        System.out.print("[" + n + "]");
    }


    public static void main(String[] args) {


        new OneEditApart().run();
    }


}



