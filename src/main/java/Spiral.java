public class Spiral {

    public static void main(String[] args) {
        printArray(genSpiral(3));
        printArray(genSpiral(4));
        printArray(genSpiral(8));
    }

    public static void printArray(int[][] matrx) {
        for (int r = 0; r < matrx.length; r++) {       //for loop for row iteration.
            for (int c = 0; c < matrx[r].length; c++) {   //for loop for column iteration.
                System.out.print(matrx[r][c] + " ");
            }
            System.out.println(); //using this for new line to print array in matrix format.
        }

    }

    public static int[][] genSpiral(int n) {
        if (n<=0) {
            throw new IllegalArgumentException("N must be >0");
        }
        int[] dc = new int[]{1,0,-1,0};
        int[] dr = new int[]{0,1,0,-1};
        int dir = 0, val=0, r=0, c=0,limit=n*n;
        int[][] matrix = new int[n][n];
        while (val++ < limit) {
            matrix[r][c] = val;
            r += dr[dir];
            c += dc[dir];
            if (isInvalid(matrix,r, c)) {
                r-= dr[dir];
                c-=dc[dir];
                dir = (dir+1)%4;
                r+= dr[dir];
                c+= dc[dir];
            }
        }
        return matrix;
    }
    private static boolean isInvalid(int[][] m, int r, int c) {
        return r<0||c<0||r>=m.length||c>= m.length||m[r][c] != 0;
    }

}
