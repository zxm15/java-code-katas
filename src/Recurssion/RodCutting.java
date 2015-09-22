package Recurssion;
import java.util.Arrays;
/**
 * Created by ZXM on 9/22/15.
 * Given a rod of length n inches and a table of prices p for different lengths of rod (p[0] is the price for rod of length 1 inch, p[1] is the price for rod of length 2 inches, ..., p[n - 1] is the price for rod of n inches), determine the maximum revenue you can get by cutting the rod and selling them according to the prices p.
 * <p>
 * For example, given p = [2, 2, 3], we know n is 3 and the maximum profit is 6 (3 = 1 + 1 + 1); given p = [1, 2, 7], n is also 3 but the maximum profit changes to 7 (3 = 3, no cutting is needed).
 */

/**analysis
 * clarification
 * 1. could the price contains negtive value
 * yes
 * 2. if input is null or empty
 * return 0
 *
 * pattern matching
 * keywords: find max => two pointers(no), greedy(not working), recursion
 * method 1:
 * f(i) represents the max revenue of cutting and selling rod with length i
 * final result f(n)
 * f(i) = for j in i
 *          max(dp[i - j] + arr[j])
 *
 * O(n^2) time and O(n) space
 *
 * ivs:
 * dp(0) = 0;
 *
 *
 * method 2:
 * cut or not cut at position i
 * f(i) represents the rod position
 * f(i) = max(price[i - start + 1] + f(
 * f(i, start, n, sum)
 * cut = f(i + 1, i + 1, n, sum += price[i - start + 1]);
 * not cut = f(i + 1, start, n, sum);
 * need a matrix, not easy to write a logic in term of dp
 *
 */
public class RodCutting {
    //note that len may be equals prices.length
    public int findMaxProfit(int len, int[] prices) {
        if (prices == null || prices.length == 0 || len < 0) throw new IllegalArgumentException();
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= Math.min(i, prices.length); j++) {
                dp[i] = Math.max(prices[j - 1] + dp[i - j], dp[i]);
            }
        }

        return dp[len];
    }
}

/**test
 * len      prices          exp     act
 * 0        [1,2,3]         0       0
 * 1        [1,2,3]         1       1
 * 2        [2,2,3]         4       4
 */
