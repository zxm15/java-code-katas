package DynamicProgramming;

/**
 * Created by ZXM on 12/3/15.
 * Find all palindrome by deleting charactes in a string
 *
 *
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**analysis
 * given examples,  we could find the problem is to find all subsequences that are palindrome in the string
 * starting with f(i) but we find that to solve the problem we actually need f(i, j)
 *
 * f(i, j) = all the subsequences in the substring str(i , j)
 *
 * f(i, j) is an aggregation = f(i + 1, j - 1) if s[i] == s[j]
 *                              + f(i + 1, j) + f(i, j - 1);
 *
 * calculate it from left to right, bottom up, it takes O(n) space and O(mn) * set copy time
 * ivs: i == j set(s[i]);
 * final result = f(0, n - 1);
 *
 *
 */
public class FindAllPalindromeByDeletingCharactersInString {
    public Set<String> findAllPalindromicSubsequences(String str) {
        if (str == null || str.length() == 0) return null;
        int n = str.length();
        Set<String>[] dp = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashSet<>(Arrays.asList(""));
        }
        for (int i = n; i >= 1; i--) {
            Set<String> lowerLeft = dp[i - 1];
            for (int j = i; j <= n; j++) {
                Set lower = dp[j];
                Set left = dp[j - 1];
                if (i == j) {
                    dp[j] = new HashSet<>(Arrays.asList("" + str.charAt(i - 1), ""));

                } else {

                    Set<String> curr = new HashSet<>();
                    curr.addAll(lower);
                    curr.addAll(left);
                    if (str.charAt(i - 1) == str.charAt(j - 1)) {
                        for (String palindrome : lowerLeft) {
                            curr.add(str.charAt(i - 1) + palindrome + str.charAt(i - 1));
                        }
                    }
                    dp[j] = curr;
                }

                lowerLeft = lower;

            }
        }

        return dp[n];
    }
}
