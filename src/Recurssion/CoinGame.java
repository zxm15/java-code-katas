package Recurssion;

/**
 * Created by ZXM on 9/22/15.
 * You are playing the following Coin Game with your friend: given a line of coins, each time one of you take turns to move one coin to your pocket. And you can only move either the leftmost coin or the rightmost coin. Both of you are equally clever and try to maximize the values of coins in your pocket.
 * <p>
 * Write a function to compute the maximum values of coins you can get given the line of coins.
 * <p>
 * For example, given coins = [5, 3, 7, 10], the max value you can get is 15 (you choose 10 first, then your friend chooses 7, and finally you choose 5).
 * <p>
 * Note: you will take the first turn to get the coins. Moreover, to guarantee the fairness of the game, there will always be an even number of coins in the line.
 */

/**analysis
 *
 * clarification:
 * 1. all positive number in array?
 * not necessary
 * 2. if array is null or empty?
 * return 0
 * pattern matching:
 * has two options for each step, find the max one of both
 * keywords : two options, max => dp
 *
 * algo:
 * f(i,j) represents the max value first player could get from subarray of coins[i, j]
 * i <= j is a must be
 * final result f(0, n - 1)
 * f(i, j) = max(sum(i + 1, j) - f(i + 1, j) + array[i], sum(i, j - 1) - f(i, j - 1) + array[j]);
 * calculate f from bottom to up, left to right
 * sum could be calculated in pre processing, keep an array is enough sum[j] - sum[i - 1];
 * ivs => dp all zeros and sum all zeros
 *
 * pseudo code:
 * dp[n + 1], sum[n + 1]
 * for i in n
 *  sum[i] = sum[i - 1] + array[i]
 *
 * for i in n
 *  for j in [i, n]
 *      dp[j] = max(sum[j] - sum[i] - dp[j] + array[i - 1], sum[j - 1] - sum[i - 1] - dp[j - 1] + array[j - 1])
 *
 * return dp[n]
 */
public class CoinGame {

    public int findMaxValue(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int n = arr.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        int[] dp = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int a = arr[i - 1] + sum[j] - sum[i] - dp[j];
                int b = arr[j - 1] + sum[j - 1] - sum[i - 1] - dp[j - 1];
                dp[j] = Math.max(a, b);
            }
        }

        return dp[n];
    }

}

/**test
 * arr          exp     act
 * 5            5       5
 * 5,1          5       5
 */
