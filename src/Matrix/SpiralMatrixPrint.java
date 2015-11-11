package Matrix;

/**
 * Created by ZXM on 11/8/15.
 */
public class SpiralMatrixPrint {
    public static void spiralPrint(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = -1;
        while (m > 0 && n > 0) {
            //print top row;
            for (int k = 0; k < n; k++) {
                System.out.print(matrix[i][++j] + " ");
            }
            if (--m == 0) break;
            //rightmost col
            for (int k = 0; k < m; k++) {
                System.out.print(matrix[++i][j] + " ");
            }
            if (--n == 0) break;
            //bottom row
            for (int k = 0; k < n; k++) {
                System.out.print(matrix[i][--j] + " ");
            }
            if (--m == 0) break;
            //left most col
            for (int k = 0; k < m; k++) {
                System.out.print(matrix[--i][j] + " ");
            }
            if (--n == 0) break;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][6];
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = count++;
            }
        }

        spiralPrint(matrix);
    }
}



/**test
 * 12
 * 43
 *
 * 1234
 *
 *
 *
 */
