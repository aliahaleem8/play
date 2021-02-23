public class GoogleFindMinUnSortedArray {

    public static void main(String[] args) {
        int [] input = {2, 5, 6, 3, 10, 15, 11, -1};//{ 2, 4, 0, 7};
       // System.out.println("output: " + min(input));
        System.out.println("output: " + nthMin(input, 2));
    }

    // 2, 5, 6, 3, 10, 15, 11; m = 3
    private static int  min(int[] a) {

        int min = a[0];
        int min2 = a[1];
        for (int i = 2; i< a.length; i++){
            if(a[i]<min){
                min2 = min;
                min = a[i];
            }
            else if (a[i]<min2){
                min2 = a[i];
            }
        }
     //   System.out.println(sorted.toString());
        return min2;
    }

    private static int  nthMin(int[] a, int m) {

        int[] min = new int[m];
        // copy first few in array.
        for (int i = 0; i<m; i++){
            min [i] = a [i];
        }

        for (int i = m; i< a.length; i++){
           for (int k = 0; k < m; k++){
                if (a[i] < min[k]) {
                    // shift each mins
                    for (int j = k+1; j < m; j++) {
                        min[j] = min[j - 1];
                    }
                    min[k] = a[i];
                    break;
                }

            }
        }
        return min[m];
    }


}
