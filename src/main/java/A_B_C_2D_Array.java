
public class A_B_C_2D_Array {
    public static void main(String[] args)
    {   call3DArray();
        print3DArray();
        int[][] arr1 = new int[10][20]; //x[row_index][column_index]
        arr1[0][0] = 1;

        int[][] arr = { { 1, 2 }, { 3, 4 } };

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static void print3DArray() {


                int[][][] arr = { { { 1, 2 }, { 3, 4 } },
                        { { 5, 6 }, { 7, 8 } } };

                for (int i = 0; i < 2; i++) {

                    for (int j = 0; j < 2; j++) {

                        for (int k = 0; k < 2; k++) {

                            System.out.print(arr[i][j][k] + " ");
                        }

                        System.out.println();
                    }
                    System.out.println();


        }

    }

    private static void call3DArray() {

        //int[][][] arr1 = { {{1, 2}, {3, 4}}, {{5, 6}, {7, 8}} };
        int[][][] arr1 = new int[10][20][30];
        arr1[0][0][0] = 1;

        System.out.println("arr[0][0][0] = " + arr1[0][0][0]);


        int[][][] arr = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                for (int z = 0; z < 2; z++)
                    System.out.println("arr[" + i
                            + "]["
                            + j + "]["
                            + z + "] = "
                            + arr[i][j][z]);
    }

}
