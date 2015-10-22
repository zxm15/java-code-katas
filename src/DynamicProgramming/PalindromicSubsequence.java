package DynamicProgramming;

/**
 * Created by ZXM on 10/22/15.
 * find all palindromic subsequence in a given string
 *
 *
 */

/**analysis
 * ababba

 f(i, j) = number of palindromic subsequence
 speical case f(empty) = 1;

 final result f(0, n - 1)
 f(i, j) = sum of
 for k from i to j

 chose str[k] as the leftmost character of the subseqence
 count = 1; //single character
 for l from k + 1 to j
 if str[l] == str[k]
 count += f(k, l)

 calcualte order
 i, j is result from down and lef results
 then bottom up and left to right

 ivs: i <= j dp[i,j] = 1


 another way of doing dp

 f(i) = numbers of palindromic subsequences in substring str(0, i)
 final result f(n - 1)
 what are new values?
 single character
 if there is str[j] where j < i
 dp[i] += 1 + paldindromic subsequences from f(j + 1, i - 1);

 it appears we will still need a start pointers

 f(i, j) = numbers of palindromic subsequences in substring str(i, j)
 it leads to an improved version of method 1
 f(i, j - 1) known
 f(i, j) = f(i, j - 1) + all paldindromic subsequences in substring(i, j) ending with j (x)

 x = 1
 for k from i, j - 1
 if (str[k] == str[j])
 x += 1 + f(k + 1, j - 1);
 */
public class PalindromicSubsequence {
    public int findAllPalindromicSubsequence(String str) {
        if (str == null || str.length() == 0) return 0;
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1;
                for (int k = i; k <= j - 1; k++) {
                    if (str.charAt(k) == str.charAt(j)) {
                        dp[i][j] += 1 + dp[k + 1][j - 1];
                    }

                }
            }
        }

        return dp[0][n - 1];
    }

}
