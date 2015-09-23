package Recurssion;

/**
 * Created by zxm on 9/23/15.
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * <p>
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * <p>
 * Note: you may assume that n is not less than 2.
 */

/**analysis
 * clarification:
 * 1. what to return when n <= 1
 * invalid argument
 *
 *
 * pattern matching:
 * keyword: max => two pointers(usually comes with sorted array or string problems), greedy(no), dp
 *
 * example:
 * n = 2, the last element could only be 1, so f(1) * 1 = product
 * n = 3, the lasat element could be 1, and 2, so max(f(1) * 2, f(2) * 1) = 2
 *
 * algo:
 * f(i) represents the max product of a list of positive integers which sums to i;
 * f(n) = final
 * f(i) = for j in (1, i -1)
 *          max(j * f(i - j));
 *
 * ivs: f(0) = 0, f(1) = 1
 *
 * order: calculate from left to right;
 *
 * complexity: O(n^2) time and O(n) space
 */
public class IntegerBreak {


    public int findMaxProductOfIntegerBreak(int n) {
        if (n <= 1) throw new IllegalArgumentException("Input must be larger than 1");
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
            if (i < n) dp[i] = Math.max(dp[i], i);
        }

        return dp[n];
    }
}
