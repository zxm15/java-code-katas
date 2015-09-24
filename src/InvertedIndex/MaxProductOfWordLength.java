package InvertedIndex;

/**
 * Created by ZXM on 9/24/15.
 * Given a list of words, find the max product of word length between a pair of words that share no common letters.

 You may assume all words are in lowercase letters.

 For example,
 Given [fish, far, truck], max product = 5x4 = 20 (fish and truck do not share common letters).
 */

import java.util.HashSet;
import java.util.Set;

/**analysis
 * clarification:
 * empty string array?
 * return 0;
 *
 * pattern matching:
 * keyword: max, string => two pointers, greedy, dp
 * think of a two pointer solution and it does not work because there is no good way of
 * determining which pointer to move.
 * greedy: we could sort the strings base on length, then start from the longest strings.
 * still, it does not have good logic to determine which pointer to move.
 * dp: no good way to use previous result. each word is independent.
 *
 * Then what?
 * Brute force:
 * try every pair of word, check if they do not share common letters, calculate the product and compare it to the max product
 * two ways to optimize it:
 * 1. optimize the process of determine if two words share common letters.
 * 2. do we need to compare with every pair?
 *
 * optimization to 1 is inverted index
 * for each character, store a set of index of word which contains the letter
 *
 * optimization to 2
 * based on 1, we do not need to check every pair. but we still need to traverse the array
 *
 * algo:
 * keep an array of hashset sets
 * foreach i in n
 *  foreach character c in words[i]
 *      sets[c - 'a'].add(i);
 *
 * for i in n
 *  set = new set();
 *  foreach character c in words]i]
 *      set.addAll(sets[c - 'a'])
 *  for j in (i + 1, n)
 *      if set does not contains j
 *          maxProduct = max(maxProduct, words[i].length() * words[j].length());
 *
 *
 * return maxProduct;
 *
 * complexity:
 * time: O(nk) + O(n * max(k, n))
 *
 *
 */
public class MaxProductOfWordLength {

    public int findMaxProductOfWordLengthWithoutCommonLetters(String[] words) {
        if (words == null || words.length == 0) return 0;
        Set<Integer>[] sets = new HashSet[26];
        int n = words.length;
        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                int index = ch - 'a';
                if (sets[index] == null) sets[index] = new HashSet<>();
                sets[index].add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (words[i].length() == 0) continue;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                int index = ch - 'a';
                set.addAll(sets[index]);
            }
            for (int j = i + 1; j < n; j++) {
                if (! set.contains(j)) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }

        return maxProduct;
    }
}
