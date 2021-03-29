import java.util.Arrays;

public class AInitializeArrays {

    public static void main(String[] args) throws Exception {
        initializeArray();
        initializeStringArray();
    }

    public static int[] initializeArray(){
        int[] a = {1, 2, 3, 4, 3};
        int[] copy = Arrays.copyOf(a, 8);

        int[] array = new int[20];
        Arrays.setAll(array, p -> p > 9 ? 0 : p); // initializes 0-9 in array first 10 elements

        int aSize= a.length;
        for(int i = 0; i< aSize; i++){
            System.out.println(a[i]);
        }
        return a;
    }

    public int[][] initialize2DArray(){
        int[][] a = {{1, 2, 3, 4, 3}, {1,2}};
        int[][] b = new int[5][4];

        // can initialize leftmost dimension first.
        int[][] c = new int[2][];
        //before using array must initialize rest
        c[0] = new int[2];
        c[1] = new int[3];

        int aSize= a.length;
        for(int i = 0; i< aSize; i++){
            System.out.println(a[i]);
        }
        return a;
    }

    public static String[] initializeStringArray(){
        //initialize Object one dimensional array
        String[] strArr; //declaration

        strArr = new String[4]; //initialization

        String array[] = new String[] {
                "Toyota", "Mercedes", "BMW", "Volkswagen", "Skoda", "BMW" };
        Arrays.stream(array).sequential().forEach(a -> System.out.println(a));
        Arrays.stream(array).sorted().forEach(a -> System.out.println(a));
        Arrays.stream(array).distinct().forEach(a -> System.out.println(a));



        return array;
    }

    public char[] initChar(){
        char[] array = new char[] {'a', 'b', 'c'};
      //  char[] copy = ArrayUtils.clone(array);
        return array;
    }


}
