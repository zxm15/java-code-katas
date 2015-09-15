package Math;

/**
 * Created by ZXM on 5/22/15.
 * Implement +, - , *, /, mod, sqrt, lcf,
 */
public class Operators {
    public int add(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

    public int addIterative(int a, int b) {
        int sum = a;
        int carry = b;
        while (carry != 0) {
            int digit = sum ^ carry;
            carry = (sum & carry) << 1;
            sum = digit;
        }
        return sum;

    }

    public int flip(int n) {
        return ~ n + 1;
    }

    public int subtract(int a, int b) {
        return add(a, flip(b));
    }

    public int multiply(int a, int b) {
        int product = 0;
        for (int i = 0; i < 32; i++) {
            if ((b & 1 << i) > 0) product += a << i;
        }
        return product;
    }

    public int abs(int n) {
        return n < 0 ? flip(n) : n;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("divisor cannot be zero");
        int sign = 1;
        if (a < 0 && b > 0 || a > 0 && b < 0) sign = -1;
        a = abs(a);
        b = abs(b);

        int quotient = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                quotient |= 1 << i;
                a -= b << i;
            }

        }
        return sign * quotient;
    }

    public int mod(int a, int b) {
        int quotient = divide(a ,b);
        return a - quotient * b;
    }

    public int sqrt(int a) {
        if (a < 0) throw new IllegalArgumentException("The value must be positive");
        if (a <= 1) return a;
        int s = 1, e = a;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (a / m == m) return m;
            else if (a / m > m) s = m + 1;
            else e = m;
        }
        return a / s >= s ? s : s - 1;
    }

    public int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0 || a % b == 0) return b;
        return gcd(b, a % b);
    }

    //implement the -, * and / by only using +, no bit wise operator
    public int negate(int n) {
        int sign = n >= 0 ? 1 : -1;
        int res = 0;
        for (int i = 0; i < sign * n; i++) {
            res += -sign;
        }
        return res;
    }
    public int subtarctOnlyWithAdd(int a, int b) {
        return a + negate(b);
    }

    public int absOnlyWithAdd(int n) {
        return n >= 0 ? n : negate(n);
    }

    public int multiplyOnlyWithAdd(int a, int b) {
        int sign = 1;
        if (a > 0 && b < 0) sign = -1;
        a = abs(a);
        b = abs(b);
        int product = 0;
        if (a < b) {
           product = multiplyOnlyWithAdd(b, a);
           return sign == 1 ? product : negate(product);
        }
        for (int i = 0; i < b; i++) product += a;
        return product;
    }

    public int divideOnlyWithAdd(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Divisor cannot be zero");
        int sign = 1;
        if (a > 0 && b < 0 || a < 0 && b > 0) sign = -1;
        a = abs(a);
        b = abs(b);
        int count = 0;
        while (a >= b) {
            a -= b;
            count++;
        }
        return sign == 1 ? count : negate(count);
    }


    public static void main(String[] args) {
        Operators operator = new Operators();
        System.out.println(operator.add(-1, 10001));
        System.out.println(operator.addIterative(1, -100));
        System.out.println(~ 3 + 1);
        System.out.println(operator.subtract(3, 100));
        System.out.println(operator.multiply(-300, -11));
        System.out.println(operator.divide(2147483647, -2147483648));
        System.out.println(operator.abs(-2147483648));
        System.out.println(operator.flip(-2147483648));
        System.out.println(operator.mod(10, -3));
        System.out.println(operator.sqrt(214783647));
        System.out.println(operator.gcd(18, 12));
        System.out.println(operator.subtarctOnlyWithAdd(3, -4));
        System.out.println(operator.negate(10));
        System.out.println(operator.multiplyOnlyWithAdd(-4, 5));
        System.out.println(operator.divideOnlyWithAdd(-16, 5));
        System.out.println(Math.abs(-2147483648 / - 2));


    }

}
