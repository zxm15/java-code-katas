package DynamicProgramming;

/**
 * Created by ZXM on 9/24/15.
 * Given a sequence s of brackets ('(', ')', '[', ']', '{', '}'), return the minimum number of brackets needed to be added to make the sequence of brackets valid.

 For example, if s = "()[", return 1 since we just need to add 1 ']' at the end of s to make it valid (s will become "()[]").

 If s = "()[{}]", return 0 since s is already valid and no more brackets need to be added.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**analysis
 * clarification
 * 1. empty inut?
 * return 0;
 * 2. invalid characters?
 * assume all characters are valid
 *
 * pattern matching
 * keyword: shortest, parentheses matching => dp & stack
 *
 * dp works.
 *
 * ({()) => ({)
 * {((){()} => {(}
 *
 * do preprocessing to store only invalid paretheses
 * then use dp to find the min value
 *
 * how dp works?
 * two pointers i, j
 * dp[i,j] reprensents the number of min insertions needed to make list[i,j] a valid paren
 * final dp[0, n -1];
 * if (list[i] match list[j])
 *      dp[i][j] = dp[i + 1][j - 1];
 * dp[i][j] = min(dp[i][j], min(dp[i + 1][j], dp[i][j - 1]) + 1);
 *
 * calculate dp using bottom up manner, left to right
 * then only one array is needed
 * we know i <= j
 * ivs:
 * dp = new int[n + 1];
 * when i = j dp[j] = 1;
 *
 */
public class ShortestValidParentheses {
    final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};
    public int ShortestValidParenthesesDP(char[] parens) {
        if (parens == null || parens.length == 0) return 0;
        List<Character> list = findInvalidParentheses(parens);
        return findSmallestNumberOfInsertionDP(list);
    }

    public List<Character> findInvalidParentheses(char[] parens) {
        List<Character> invalidParens = new ArrayList<>();
        for (char ch : parens) {
            if (! invalidParens.isEmpty()) {
                char top = invalidParens.get(invalidParens.size() - 1);
                if (map.containsKey(top) && map.get(top) == ch) {
                    invalidParens.remove(invalidParens.size() - 1);
                    continue;
                }
            }
            invalidParens.add(ch);
        }

        return invalidParens;
    }

    public int findSmallestNumberOfInsertionDP(List<Character> list) {
        if (list.isEmpty()) return 0;
        int n = list.size();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, list.size());
        for (int i = n; i >= 1; i--) {
            int downRight = dp[i - 1];
            for (int j = i; j <= n; j++) {
                int down = dp[j];
                dp[j] = Math.min(down, dp[j - 1]) + 1;
                if (map.get(list.get(i - 1)) == list.get(j - 1)) dp[j] = Math.min(dp[j], downRight);
                if (i == j) {
                    dp[j] = 1;
                }
                downRight = down;
            }
        }

        return dp[n];
    }
}

/**test
 *  ((
 * 222
 * 221
 * 211
 * 221
 * 212
 *
 * 21
 *  ({)
 * 3333
 * 3331
 * 3311
 *   31
 * 3312
 * 3112
 *  31
 * 3122
 *   12
 *    1
 *
 *555555
 *555551
 *55551
 *
 */
