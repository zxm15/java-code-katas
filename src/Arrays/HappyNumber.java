package Arrays;

/**
 * Created by Gavin on 4/7/2015.
 */

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers,
 * while those that do not end in 1 are unhappy numbers (or sad numbers)
 */
public class HappyNumber {

    public static boolean isHappyNumber(int n)
    {
        int count = 100;
        while (true) {
            if (n == 1) return true;
            else {
                int sum = 0;
                while (n != 0) {
                    int digit = n % 10;
                    sum += (int) Math.pow(digit, 2);
                    n /= 10;
                }
                n = sum;
            }
            if (--count == 0) break;
        }
        return false;
    }

    public static void main(String[] args)
    {
        int n = 101;
        if (isHappyNumber(n)) System.out.println(n + " is a happy number");
        else System.out.println(n + " is not a happy number");
    }
}
