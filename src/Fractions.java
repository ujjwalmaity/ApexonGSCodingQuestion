

import java.util.*;

public class Fractions {

    public static void main(String[] args) {
        // Give two fractions, the numerator and denominator represented as a pair of ints,
        // return them in their simplest form after adding them.
        //
        // Examples:
        // {Numerator_frac1 = 1, Denominator_frac1 = 3} // 1/3
        // {Numerator_frac2 = 3, Denominator_frac2 = 9} // 3/9
        // Return Numerator_ans = 2, Denominator_ans = 3 // 2/3
        //
        // {Numerator_frac1 = 1, Denominator_frac1 = 2} // 1/2
        // {Numerator_frac2 = 3, Denominator_frac2 = 2} // 3/2
        // Return Numerator_ans = 2, Denominator_ans = 1 // 2/1

        int num1 = 1;
        int den1 = 3;

        int num2 = 3;
        int den2 = 9;

        int den3 = getLcm(den1, den2);
        int num3 = (num1 * (den3 / den1)) + (num2 * (den3 / den2));

        int commonFactor = getHcf(den3, num3);
        den3 = den3 / commonFactor;
        num3 = num3 / commonFactor;

        System.out.println(num3 + "/" + den3);
    }

    static int getLcm(int a, int b) {
        int lcm = (a * b) / getHcf(a, b);
        return lcm;
    }

    static int getHcf(int a, int b) {
        if (b == 0) return a;
        return getHcf(b, a % b);
    }
}

