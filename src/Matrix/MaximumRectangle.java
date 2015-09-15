package Matrix;

import java.util.Stack;

/**
 * Created by zxm on 6/9/15.
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 * logic:
 * 1. For each submatrix ending with row i, convert it to a histogram.
 * 2. Calculate each histogram's largest area
 * 3 return the global max area
 * Pseudo code:
 *  function findMaxRec(matrix) {
 *      height[], m = matrix.length, n = matrix[0].length;
 *      for i in m
 *          height = calculateHeight(matrix, i);
 *          maxArea = max(maxArea, calculateArea(height);
 *      return maxArea
 *  }
 */
public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[] height = new int[n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            //calculate height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j] += 1;
            }
            maxArea = Math.max(maxArea, calculateHistogram(height));

        }
        return maxArea;
    }

    public int calculateHistogram(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            //when the right bar is smaller than left bar, pop left bar and calculate the area with its height
            while (stack.peek() != -1 && height[i] < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        //calculate the rectangle with height remaining in the stack
        while (stack.peek() != -1) {
            int h = height[stack.pop()];
            int w = height.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);

        }
        return maxArea;
    }
}
