package Arrays;

/**
 * Created by zxm on 6/10/15.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most one transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Analysis:
 * If doing zero transaction, the max profit = 0;
 * If doing one transaction, the transaction must end with some day i.
 * then, max profit = Math.max(maxP, maxP(i)) where i = [0, n-1]
 * Could achieve above using simple dynamic programming
 * Pseudo code
 * function getMax(prices) {
 * maxProfit = 0, minPrice = A[0]
 * for i = [1, n-1]
 * minPrice = min(minPrice, A[i])
 * maxProfit = max(maxProfit, A[i] - minPrice)
 * return maxProfit
 * }
 *
 */

public class BuyStockWithAtMostOneTransaction {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
