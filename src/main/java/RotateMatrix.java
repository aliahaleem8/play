public class RotateMatrix {

    private static void transpose(int m[][]) {

        for (int i = 0; i < m.length; i++) {

            for (int j = i; j < m[0].length; j++) {

                int temp = m[j][i];

                m[j][i] = m[i][j];

                m[i][j] = temp;

            }

        }

    }

    public static boolean rotateWithTranspose(int m[][]) {

        transpose(m);

        for (int i = 0; i < m[0].length; i++) {

            for (int j = 0, k = m[0].length - 1; j < k; j++, k--) {

                int temp = m[j][i];

                m[j][i] = m[k][i];

                m[k][i] = temp;

            }

        }

        return true;

    }

    public static boolean rotateRing(int[][] m) {

        int len = m.length;

        // rotate counterclockwise

        for (int i = 0; i < len / 2; i++) {

            for (int j = i; j < len - i - 1; j++) {

                int temp = m[i][j];

                // right -> top

                m[i][j] = m[j][len - 1 - i];

                // bottom -> right

                m[j][len - 1 - i] = m[len - 1 - i][len - 1 - j];

                // left -> bottom

                m[len - 1 - i][len - 1 - j] = m[len - 1 - j][i];

                // top -> left

                m[len - 1 - j][i] = temp;

            }

        }

        return true;

    }
}
