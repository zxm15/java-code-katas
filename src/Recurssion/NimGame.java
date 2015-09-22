package Recurssion;

/**
 * Created by ZXM on 9/22/15.
 * Question
 * You are playing the following Nim Game with your friend: there is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

 Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

 For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

 Hint:

 If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be the winner?
 */

/**
 * analysis
 *
 * clarification:
 * 1. n <= 0
 * false;
 *
 * pattern matching:
 * one has three options to determine result => recursion
 * only need next three results to get current one => dp
 *
 * algo:
 * dp[i] = ! (dp[i + 1] | dp[i + 2] | dp[i + 3])
 * need first, second, third pointers.
 * O(n) time and O(1) space
 * final result dp[0];
 * ivs:
 * dp[n - 1] = dp[n - 2] = dp[n - 3] = true;
 * if n <= 3 return true;
 */

public class NimGame {
    public boolean couldWinNimGame(int n) {
        if (n <= 0) return false;
        if (n <= 3) return true;
        boolean first = true, second = true, third = true;
        for (int i = n - 4; i >= 0; i--) {
            boolean curr = (!first | !second | !third);
            third = second;
            second = first;
            first = curr;
        }

        return first;
    }
}
