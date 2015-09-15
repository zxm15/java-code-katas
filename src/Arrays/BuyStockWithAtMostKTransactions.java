package Arrays;

/**
 * Created by zxm on 6/10/15.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Analysis:
 * The first instinct is to use recursion
 * Assume f(k, i) represent the max profit of doing at most k transactions in the time range ending with day i (may not include day i in max profit)
 * Final result is f(k, n - 1)
 * Recursive relation
 * f(k, i) = max(f(k, i - 1), f(k - 1, j) + maxProfitWithAtMostOneTransactionStartingWithDay(price, j, i);
 * This calculation could be done using dynamic programming
 *
 * pseudo code:
 * function getMax(price) {
 *     int[] dp = new int[n + 1];
 *     //initial dp[0] = 0
 *     for l in (1, k)
 *      for j in (1, n-1)
 *          maxPrice = A[j]
 *          for i in (j - 1, 0)
 *              maxPrice = max(price[i], maxPrice)
 *              dp[j] = max(dp[i - 1] + maxPrice - price[i], dp[j])
 *
 * }
 *
 *
 *
 *
 */
public class BuyStockWithAtMostKTransactions {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     * Below method has time exceed limit error but it is correct
     */

    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (k <= 0 || prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] dp = new int[n + 1];
        for (int l = 1; l <= Math.min(k, n); l++) {
            for (int j = n; j >= 1; j--) {
                int maxPrice = prices[j - 1];
                for (int i = j; i >= 1; i--) {
                    maxPrice = Math.max(maxPrice, prices[i - 1]);
                    dp[j] = Math.max(dp[j], dp[i] + maxPrice - prices[i - 1]);
                }
            }
        }
        return dp[n];
    }

    public int maxProfitBetterSolution(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;

    }
}
