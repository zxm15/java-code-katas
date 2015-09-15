package Arrays;

/**
 * Created by zxm on 6/10/15.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Analysis:
 *
 * We know how to achieve max profit using at most one transaction
 * If we could divide the two transaction somehow into the sum of A and B where they are max profit of at most one transaction before and after day i (could including day i),
 * then the global max profit would be the largest combination of A and B
 * A = maxProfit with at most one transaction ending with or before day i
 * B = maxProfit with at most one transaction starting with or after day i
 * maxProfit = sum(A + B) where i = [0, n-1]
 *
 * pseudo code
 * function getMax(price) {
 *     array left, right
 *     currProfit = 0, minPrice = A[0]
 *     //calculate left
 *     for i in (1, n-1)
 *          minPrice = min(minPrice, price[i]);
 *          left[i] = max(left[i-1], price[i] - minPrice)
 *     //calculate right
 *     maxPrice = A[n-1]
 *     for i in (n-2, 0)
 *          maxPrice = min(maxPrice, price[i])
 *          right[i] = max(right[i+1], maxPrice - price[i])
 *
 *     //iterate through 0 to n-1 day to find the largest combo
 *     gMax = 0;
 *     for i in n
 *          gMax = max(gMax, left[i] + right[i])
 *     return gMax
 * }
 */
public class BuyStockWithAtMostTwoTransactions {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //calculate left
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }
        //calcualte right
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }
        //find the max combo
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, right[i] + left[i]);
        }

        return maxProfit;
    }
}
