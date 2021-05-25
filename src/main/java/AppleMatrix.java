import static java.lang.Math.min;
//diagonally all elements match down and right
public class AppleMatrix {

    public static void main(String[] args) {

        //int[][] matrix = new int[4][4];

        //is valid
        int[][] matrix3 = { { 3, 2, 1, 7 },
                            { 4, 3, 2, 1 },
                            { 5, 4, 3, 2 },
                            { 7, 5, 4, 3 } };
        //is invalid

//        int[][] matrix3 ={ { 3, 2, 1, 7 },
//            { 9, 11, 5, 4 },
//            { 6, 0, 13, 17 },
//            { 7, 21, 14, 15 } };


        for (int i = 0; i < matrix3.length; i++)
        {
            // length returns number of rows
            for (int j = 0; j < matrix3[i].length; j++)
            {       int t = matrix3[i][j];
                    int x = 0;

                     while (((i+x) < matrix3.length) && ((j+x) < matrix3[0].length)) {
                        if (t!=(matrix3[i+x][j+x]))
                            System.out.println(false); // return false;
                         x++;

                    }
            }


        }
        System.out.println(true); //return true;
    }
}
