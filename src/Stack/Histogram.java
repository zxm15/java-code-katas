package Stack;

import java.util.Stack;

/**
 * Created by zxm on 6/26/15.
 */
public class Histogram {
    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
     */
    /**
     * observation: for the largeset rectangle, its height must aligh with some height of a bar in the histogram
     * the mission is to find the largest rectangle with height of each bar, the biggest one is the result
     * Brute force method takes O(n^2) time and O(1) space since find ith bar left and right bourndaries take o(n) time
     * Optimize the process of finding left and right boundary in O(1) time for each bar
     * Draw a graph, analyzing a specific situation and ask yourself how you store information to achieve O(1) time
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[stack.peek()] > height[i]) {
                int h = height[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }

        //calculcate the largest rect formed by bars left in stack
        while (stack.peek() != -1) {
            int h = height[stack.pop()];
            int w = height.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }

        return maxArea;
    }
}
