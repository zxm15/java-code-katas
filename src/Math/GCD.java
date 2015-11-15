package Math;

/**
 * Created by ZXM on 11/12/15.
 */
public class GCD {

    public int findGCD(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int sign = 1;

        if (a < 0) {
            a = -a;
            sign *= -1;
        }
        if (b < 0) {
            b = -b;
            sign *= -1;
        }
        return sign * findGreatestCommonDivisor(a, b);
    }
    public int findGreatestCommonDivisor(int a, int b) {

        if (a < b) return findGreatestCommonDivisor(b, a);
        if (a % b == 0) return b;
        return findGreatestCommonDivisor(b, a % b);
    }

    public int findGCDIterative(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;

        }
        while (a % b != 0) {

            int temp = a;
            a = b;
            b = temp % b;
        }

        return b;
    }

}
