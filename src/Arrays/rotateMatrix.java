package Arrays;

/**
 * Created by ZXM on 5/28/15.
 */
public class rotateMatrix {
    public static void rotateMatrix(int[][] matrix) {
        if (matrix == null) return;
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        int step = n - 1;
        for (int i = 0; i < n / 2; i++) {
            int row = i;
            int col = i;
            for (int j = 0; j < step; j++) {
                int temp = matrix[row][col + j];
                matrix[row][col + j] = matrix[row + step - j][col];
                matrix[row + step - j][col] = matrix[row + step][col + step - j ];
                matrix[row + step][col + step - j] = matrix[row + j][col + step];
                matrix[row + j][col + step] = temp;
            }
            step -= 2;
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] createSqaureMatrix(int size) {
        int n = size;
        int[][] matrix = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = count++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = createSqaureMatrix(4);
        printMatrix(matrix);
        rotateMatrix(matrix);
        printMatrix(matrix);

    }

}
