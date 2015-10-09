package Math;

/**
 * Created by ZXM on 10/9/15.
 * Calculate x power of y
 * assume y is an integer
 *
 * follow up:
 * can you implement it without recursion?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**analysis
 * clarification
 * y could be negative?
 * yes
 * x could be double?
 * yes
 *
 * integer overflow?
 * x is double
 * double overflow?
 * assume not.
 *
 * x^y
 * y % 2 == 0 ==> x ^ (y / 2) * x ^ (y / 2)
 * y % 2 == 1 ==> x * x ^ (y / 2) * x ^ (y / 2)
 *
 *
 * half = x
 * power = 1
 * power * 2 <= y half = half * half;
 * 15 / 2 = 7 1
 * 7 / 2 = 3  1
 * 3 / 2 = 1  1
 * 1 / 2 = 0  1
 *
 *
 * 1 * 2 = 2
 * 2 * 2 = 4
 * 4 * 2 = 8
 * 8 * 2 = 16
 *
 * wrong
 */


public class CalculatePower {
    public double power(double x, int y) {
        if (y == 0) return 1;
        if (y < 0) return power(1/x, -y);
        double half = power(x, y / 2);
        return y % 2 == 0 ? half * half : half * half * x;
    }

    public double powerIterate(double x, int y) {
        if (y == 0) return 1;
        if (y < 0) return powerIterate(1/x, -y);
        Map<Integer, Double> powerValueMap = new HashMap<>();
        Map<Integer, Integer> remainingPowerMap = new HashMap<>();
        List<Integer> powerList = new ArrayList<>();
        int n = y;
        while (n != 0) {
            powerList.add(n);
            int remainingPower = n % 2;
            remainingPowerMap.put(n, remainingPower);
            n /= 2;
        }

        powerValueMap.put(0, 1.0);

        for (int i = powerList.size() - 1; i >= 0; i--) {
            int power = powerList.get(i);
            double half = powerValueMap.get(power / 2);
            double value = remainingPowerMap.get(power) == 1 ? half * half * x : half * half;
            powerValueMap.put(power, value);
        }

        return powerValueMap.get(y);
    }
}
