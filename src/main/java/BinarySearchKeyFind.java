

class BinarySearchKeyFind{


//    static int binSearch(int[] a, int key) {
//        //TODO: Write - Your -
//
//       int l = 0;
//       int r = a.length-1;
//        int n = (l+r)/2;
//       while((n>=l)&&(n <= r)&&(l<r)){
//           if (a[n]==key)
//               return n;
//           else if (a[n]>key){
//               r = n-1;
//           }
//           else {
//               l = n +1;
//           }
//           n = (r+l)/2;
//       }
//        return -1;
//    }

    static int binarySearchRec(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);
        if (a[mid] == key) {
            return mid;
        } else if (key < a[mid]) {
            return binarySearchRec(a, key, low, mid - 1);
        } else {
            return binarySearchRec(a, key, mid + 1, high);
        }
    }
    static int binSearch(int[] a, int key) {
        return binarySearchRec(a, key, 0, a.length - 1);
    }

    public static void main(String []args){
        int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
        int[] inputs = {10, 49, 99, 110, 176};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("binSearch(arr, " + inputs[i]+ ") = " +  binSearch(arr, inputs[i]));
        }
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
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

    public void run() {

//        int k = 47;
//        int[] arr = {1, 10, 20, 47, 133, 155, 188, 254, 333, 385};
//        int expected = 3;
//        int output = binSearch(arr, k);
//        check(expected, output);

//        passed: binSearch([1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100],44)

//        int k = 80;
//        int[] arr = {1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100};
//        int expected = 11;
//        int output = binSearch(arr, k);
//        check(expected, output);


        int k = 12;
        int[] arr = {1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100};
        int expected = 5;
        int output = binSearch(arr, k);
        check(expected, output);

//        binSearch([1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100],12)
//

    }
//    public static void main(String[] args) {
//        new BinarySearchKeyFind().run();
//    }
}