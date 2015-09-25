package Math;

/**
 * Created by ZXM on 9/24/15.
 * Add two numbers without using the addition/subtraction operations.

 Note: you may assume the result is within the range of a 32-bit signed integer.
 */

/**analysis
 *
 * clarification:
 * interger overflow?
 * if > max value, return max value;
 * eles if < min value, return min value;
 *
 * pattern matching:
 * think of how computer achieve addition?
 * bit operations
 *
 * example
 * 0 + 0 = 0
 * 0 + 1 = 1
 * 1 + 0 = 1
 * 1 + 1 = 0
 *
 * a ^ b is above
 * special case 1 + 1: generate carry 1 and left shift
 * how to get carry ?
 * (a & b) << 1
 *
 * how do I know integer overflow?
 * a and b has different sign, no overflow
 * a > 0 and b > 0, could overflow max
 * diff = max - a; then if diff < b, overflow
 * a < 0 and b < 0, could overflow min
 * diff = min - a, then if diff > b overflow
 *
 *
 * algo:
 * if oveflow, return value;
 * while (b != 0) {
 *     sum = a ^ b;
 *     b = (a & b) << 1;
 * }
 *
 *
 *
 *
 */
public class Addition {

    public int addition(int a, int b) {
        if (a > 0 && b > 0) {
            int diff = Integer.MAX_VALUE - b;
            if (a > diff) return Integer.MAX_VALUE;
        }
        if (a < 0 && b < 0) {
            int diff = Integer.MIN_VALUE - b;
            if (a < diff) return Integer.MIN_VALUE;
        }
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }

        return a;
    }
}
